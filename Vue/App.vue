<template>

  <NavBar @choose="color = 'red' "></NavBar>
  <DrawingArea :shapes="shapes" @add = "addShape" @color = "colorShape"></DrawingArea>
  <ShapesButtons @select = "selectShape"></ShapesButtons>

</template>

<script>
import NavBar from "@/components/NavBar.vue";
import DrawingArea from "@/components/DrawingArea.vue";
import ShapesButtons from "@/components/ShapesButtons.vue";
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
      if(this.selectedShape === 'circle') this.addCircle(e)
      else if(this.selectedShape === 'rectangle') this.addRectangle(e)
      else if(this.selectedShape === 'ellipse') this.addEllipse(e)
      else if(this.selectedShape === 'square') this.addSquare(e)
      else if(this.selectedShape === 'triangle') this.addTriangle(e)
      else if(this.selectedShape === 'line') this.addLine(e)
    },
    addCircle(e){
      this.shapes.push({
        type: 'circle',
        x: e.evt.offsetX,
        y: e.evt.offsetY,
        radius: 50,
        stroke: 'black',
        draggable: true
      })
    },
    addRectangle(e){
      this.shapes.push({
        type: 'rectangle',
        x: e.evt.offsetX - 100,
        y: e.evt.offsetY - 50,
        width: 200,
        height: 100,
        stroke: 'black',
        draggable: true
      })
    },
    addLine(e){
      this.shapes.push({
        type: 'line',
        points: [e.evt.offsetX, e.evt.offsetY, e.evt.offsetX + 200, e.evt.offsetY],
        stroke: 'black',
        draggable: true
      })
    },
    addTriangle(e){
      this.shapes.push({
        type: 'triangle',
        points: [e.evt.offsetX, e.evt.offsetY, e.evt.offsetX+200, e.evt.offsetY, e.evt.offsetX+100, e.evt.offsetY-150],
        stroke: 'black',
        draggable: true,
      })
    },
    addSquare(e){
      this.shapes.push({
        type: 'square',
        x: e.evt.offsetX - 50,
        y: e.evt.offsetY - 50,
        width: 100,
        height: 100,
        stroke: 'black',
        draggable: true
      })
    },
    addEllipse(e){
      this.shapes.push({
        type: 'ellipse',
        x: e.evt.offsetX,
        y: e.evt.offsetY,
        radiusX: 70,
        radiusY: 35,
        stroke: 'black',
        draggable: true
      })
    },
    selectShape(shape){
      this.selectedShape = shape
      this.color = ''
    },
    colorShape(shape){
      if(this.color)
      shape.fill = 'red'
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
