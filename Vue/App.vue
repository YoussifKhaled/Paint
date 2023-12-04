<template>

  <NavBar @choose = " color = 'red',this.delete = false " @delete = " this.delete = true,this.color = '' "></NavBar>
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
      delete: '',
    }
  },
  methods:{
    addShape(e){

      if(this.color || this.delete) return

      const shapeRequest = {
        shapeType : this.selectedShape,
        id: Date.now().toString(),
        x : e.evt.offsetX,
        y : e.evt.offsetY,
      }

      //add shape to list of shapes in backend and list of shapes in frontend
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
      this.delete = false
    },
    handleShapeClicking(shape){

      //handle the shape clicking based on the selected option from the navbar
      if(this.color) this.colorShape(shape)
      else if(this.delete) this.deleteShape(shape)
    },
    colorShape(shape){
      //change color of shape in frontend
      shape.fill = this.color
    },
    deleteShape(shape){

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
