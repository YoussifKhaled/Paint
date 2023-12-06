<template>

  <NavBar @Color="CrntOprtn='Cl'" @Size="CrntOprtn='S'" @Copy="CrntOprtn='Cp'" @Del="CrntOprtn='Dl'" ></NavBar>
  <span>
    <CP v-if="CrntOprtn === 'Cl'" style="float: left;margin-left: 420px;" inline v-model="color"/>
    <DrawingArea :shapes="shapes" @add = "addShape" @shapeClick = "handleShapeClicking"></DrawingArea>
  </span>
  <ShapesButtons @select = "selectShape"></ShapesButtons>
  <p>Mouse position X: {{mousePosX}}</p>
  <p>Mouse position Y: {{mousePosY}}</p>
  <template v-for = "shape in shapes" :key ="shape.id">[{{shape.x}},{{shape.y}},{{shape.points}}] </template>

</template>

<script>
import NavBar from "@/components/NavBar.vue";
import DrawingArea from "@/components/DrawingArea.vue";
import ShapesButtons from "@/components/ShapesButtons.vue";
import axios from "axios";
export default{
  name: 'App',
  components: {ShapesButtons, DrawingArea, NavBar},
  data() {
    return {
      mousePosX: 0,
      mousePosY: 0,
      shapes:[],
      configKonva:{
        width: 800,
        height: 500
      },
      CrntOprtn: '',
      selectedShape:'',
      color: '00fac0',
    }
  },
  mounted() {
    document.addEventListener("mousemove", (event) => {
      this.mousePosX = event.clientX-624;
      this.mousePosY = event.clientY-69;
    });
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
      axios.post('http://localhost:8080/paint/create', JSON.stringify(shapeRequest),{
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
      else if(this.CrntOprtn==='S')this.ResizeShape(shape)
    },
    colorShape(shape){
      shape.fill = '#'+this.color
    },
    deleteShape(shape){
      //delete shape from shapes array
      let shapeToBeRemoved = this.shapes.findIndex(s => s.id === shape.id)
      this.shapes.splice(shapeToBeRemoved,1)
      //delete shape from list of shapes in backend
      axios.delete('http://localhost:8080/paint/delete/' + shape.id)
      .then((response) => console.log(response.data))
      .catch((error) => console.log(error))
    },
    ResizeShape(shape){// Cast event to MouseEvent
      const updateShapeSize = (event) => {
        const mouseX = event.clientX - 624;
        const mouseY = event.clientY - 69;
        const centerDistance = Math.sqrt(
          Math.pow(mouseX - shape.x, 2) + Math.pow(mouseY - shape.y, 2)
          );
        const ax = mouseX-shape.x;
        const ay = mouseY-shape.y;
        switch(shape.type){
          case 'triangle':
          case 'circle':
            shape.radius = centerDistance;
            break;
          case 'rectangle':
          if(ax>=0 && ay>=0){
            if(ay/ax>shape.height/shape.width)
              shape.height = ay;
            else
              shape.width = ax;
            }
            break;
          case 'square':
            if(ax>=0 && ay>=0){
              shape.height = Math.max(ax,ay);
              shape.width = shape.height;
            }
            break;
          case 'line':
            shape.points = [0,0,ax,ay]; 
            break;
          case 'ellipse':
            if(Math.abs(ax)<Math.abs(ay))
              shape.radiusY = centerDistance;
            else
              shape.radiusX = centerDistance;
            break;
          default:
            break;
        }
        document.addEventListener('click', handleClick);
      };
      const handleClick = () => {
        document.removeEventListener('mousemove', updateShapeSize);
        document.addEventListener('click', handleClick);
        return;
      };
      document.addEventListener('mousemove', updateShapeSize);
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
