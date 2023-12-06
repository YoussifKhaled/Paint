<template>
  <div class="canvas">
    <v-stage :config="configKonva" @click = "addShape">
      <v-layer>
        <template v-for = "shape in shapes" :key ="shape.id">
          <v-line v-if = "shape.type === 'line' " :config="{
            x: shape.x,
            y: shape.y,
            points: shape.points,
            stroke: shape.stroke,
            draggable: true,
            id: shape.id,
          }" @click = "handleShapeClicking(shape)" @dragend = "handleDragEnd($event,shape)"></v-line>

          <v-regular-polygon v-if="shape.type === 'triangle' " :config="{
            x: shape.x,
            y: shape.y,
            sides: 3,
            radius: shape.radius,
            fill: shape.fill,
            stroke: shape.stroke,
            id: shape.id,
            draggable: true
          }" @click= "handleShapeClicking(shape)" @dragend = "handleDragEnd($event,shape)"></v-regular-polygon>

          <v-circle v-if="shape.type === 'circle' " :config="{
          x: shape.x,
          y: shape.y,
          radius: shape.radius,
          fill: shape.fill,
          stroke: shape.stroke,
          id: shape.id,
          draggable: true
          }" @click= "handleShapeClicking(shape)" @dragend = "handleDragEnd($event,shape)"></v-circle>

          <v-rect v-if="shape.type === 'rectangle' || shape.type === 'square' "  :config="{
          x: shape.x,
          y: shape.y,
          width: shape.width,
          height: shape.height,
          fill: shape.fill,
          stroke: shape.stroke,
          id: shape.id,
          draggable: true
          }" @click= "handleShapeClicking(shape)" @dragend = "handleDragEnd($event,shape)"></v-rect>

          <v-ellipse v-if="shape.type === 'ellipse' "  :config="{
          x: shape.x,
          y: shape.y,
          radiusX: shape.radiusX,
          radiusY: shape.radiusY,
          fill: shape.fill,
          stroke: shape.stroke,
          id: shape.id,
          draggable: true
          }" @click= "handleShapeClicking(shape)" @dragend = "handleDragEnd($event,shape)"></v-ellipse>
          </template>
        <v-transformer ref = "transformer"> </v-transformer>
      </v-layer>
    </v-stage>
  </div>
</template>

<script>
export default {
  name: 'DrawingArea',
  props:['shapes'],
  emits: ['add','shapeClick'],
  data () {
    return {
      configKonva: {
        width: 800,
        height: 500
      },
      selectedId:''
    }
  },
  methods:{
    addShape(e){
      this.$emit('add', e)
    },
    handleShapeClicking(shape){
      this.$emit('shapeClick', shape)
    },
    handleDragEnd(e,shape){
      shape.x = Math.round(e.target.attrs.x);
      shape.y = Math.round(e.target.attrs.y);
    }
  }
}
</script>

<style>
.canvas{
  margin: auto;
  background-color: azure;
  width: 800px;
  height: 500px;
  border: 3px solid #000000;
}
</style>