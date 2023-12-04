<template>

  <NavBar @choose="color = 'red' "></NavBar>
  <DrawingArea :shapes="shapes" @add = "addShape" @shapeClick = "handleShapeClicking"></DrawingArea>
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
      configKonva: {
        width: 1200,
        height: 550
      },
      selectedShape:'',
      color: '',
    }
  },
  methods:{
    addShape(e){

      if(this.color) return

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
      this.selectedShape = shape
      this.color = ''
    },
    handleShapeClicking(shape){
      if(this.color) this.colorShape(shape)
      //else this.deleteShape(shape)
    },
    colorShape(shape){
      shape.fill = this.color
    }
  }
}
</script>

<style>
body{
  background-color: rgb(181, 51, 77);
}
#app{
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  margin-top: 35px;
}
</style>
