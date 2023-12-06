<template>

  <NavBar @selectColor = " currentOperation = 'color' "
          @delete = " currentOperation = 'delete' "
          @copy = " currentOperation = 'copy' "
          @save = " handleSave "
          @load = " handleLoad "
  ></NavBar>
  <div>
  <CP v-if = "currentOperation === 'color' " :inline = true v-model = "color" class="color-picker"/>
  <DrawingArea :shapes="shapes" @add = "addShape" @shapeClick = "handleShapeClicking"></DrawingArea>
  </div>
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
      currentOperation: '',
    }
  },
  methods:{
    addShape(e){

      if(this.currentOperation !== 'draw') return

      const shapeRequest = {
        type : this.selectedShape,
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
      this.currentOperation = 'draw'
    },
    handleShapeClicking(shape){
      //console.log(shape)

      //handle the shape clicking based on the selected option from the navbar
      switch (this.currentOperation) {
        case 'color':
          this.colorShape(shape)
          break;
        case 'delete':
          this.deleteShape(shape)
          break;
        case 'copy':
          this.copyShape(shape)
              break;
        default:
          break;
      }

    },
    colorShape(shape){
      //change color of shape in frontend
      shape.fill = '#' + this.color

      //change color of shape in backend
      axios.post('http://localhost:8080/paint/modify', JSON.stringify(shape),{
        headers: {'Content-Type': 'application/json'}})
          .then((response) => {
            console.log(response.data)
          })
          .catch((error) => console.log(error))
    },
    deleteShape(shape){

      //delete shape from shapes array
      let shapeToBeRemoved = this.shapes.findIndex(s => s.id === shape.id)
      this.shapes.splice(shapeToBeRemoved,1)

      //delete shape from list of shapes in backend
      axios.delete('http://localhost:8080/paint/shapes/' + shape.id)
          .then((response) => console.log(response.data))
          .catch((error) => console.log(error))
    },
    copyShape(shape){

      //copy shape in backend and add it to shapes array in frontend
      axios.get('http://localhost:8080/paint/copy/' + shape.id)
          .then((response) => {
            this.shapes.push(response.data)
          })
          .catch((error) => console.log(error))
    },
    handleSave(filetype) {
      let file = prompt("Please enter path to save file");
      if (file != null) {
        fetch(`http://localhost:8080/paint/save?filePath=${encodeURIComponent(file)}&fileType=${filetype}`, { method: 'get' })
            .then(res => res.text())
            .then(data => {
              console.log(data)
            })
            .catch(error => {
              console.error('Error:', error)
            });
      }

    },
    handleLoad() {
      let file = prompt("Please enter path to load file");
      if (file != null) {
        let fileType = file.split('.').pop().toLowerCase();
        axios.get(`http://localhost:8080/paint/load?filePath=${encodeURIComponent(file)}&fileType=${fileType}`,{
          headers: {'Content-Type': 'application/json'}})
            .then((response) => {
              //this.shapes.push(...response.data)
              console.log(response.data)
              this.shapes = response.data
              console.log(this.shapes)
            })
            .catch((error) => console.log(error))
      }
    },
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
.color-picker{
  position: absolute;
  top: 0;
  left: 0;
}
</style>
