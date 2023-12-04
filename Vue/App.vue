<template>

  <NavBar @Color="CrntOprtn='Cl'" @Size="CrntOprtn='S'" @Copy="CrntOprtn='Cp'" @Del="CrntOprtn='Dl'" ></NavBar>
  <span>
    <CP v-if="CrntOprtn === 'Cl'" style="float: left;margin-left: 420px;" inline v-model="color"/>
    <DrawingArea :shapes="shapes" @add = "addShape" @shapeClick = "handleShapeClicking"></DrawingArea>
  </span>
  <ShapesButtons @select = "selectShape"></ShapesButtons>

</template>

<script>
import NavBar from "@/components/NavBar.vue";
import DrawingArea from "@/components/DrawingArea.vue";
import ShapesButtons from "@/components/ShapesButtons.vue";
import axios from "axios";
export default {

  name: 'App',
  components: {ShapesButtons, DrawingArea, NavBar},
  data () {
    return {
      shapes:[],
      configKonva:{
        width: 800,
        height: 500
      },
      CrntOprtn: '',
      selectedShape:'',
      color: '',
    }
  },
  methods:{
    addShape(e){
      if(this.CrntOprtn!='Dr') return
      const shapeRequest = {
        shapeType : this.selectedShape,
        id: Date.now().toString(),
        x : e.evt.offsetX,
        y : e.evt.offsetY,
      }
      axios.post('http://localhost:8080/paint/shapes', JSON.stringify(shapeRequest),{
        headers: {'Content-Type': 'application/json'}})
          .then((response) => {
            console.log(response.data)
            this.shapes.push(response.data)
          })
          .catch((error) => console.log(error))

    },
    selectShape(shape){
      this.CrntOprtn = 'Dr'
      this.selectedShape = shape
    },
    handleShapeClicking(shape){
      if(this.CrntOprtn==='Cl')this.colorShape(shape)
      else if(this.CrntOprtn==='Dl')this.deleteShape(shape)
    },colorShape(shape){
      shape.fill = '#'+this.color
    },deleteShape(shape){
      //delete shape from shapes array
      let shapeToBeRemoved = this.shapes.findIndex(s => s.id === shape.id)
      this.shapes.splice(shapeToBeRemoved,1)
      //delete shape from list of shapes in backend
      axios.delete('http://localhost:8080/paint/shapes/' + shape.id)
      .then((response) => console.log(response.data))
      .catch((error) => console.log(error))
    }
  }
}
</script>

<style>
body{
  background-color: rgb(243, 243, 243);
}
#app{
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  margin-top: 35px;
}
</style>