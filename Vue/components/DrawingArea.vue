<template>
  <div class="canvas">

    <v-stage :config="configKonva" @click = "addShape">
      <v-layer>

        <template v-for = "shape in shapes" :key ="shape.x">

          <v-line v-if="shape.type === 'line' " :config="{
            points: shape.points,
            stroke: shape.stroke,
            draggable: true
          }" @click = "handleShapeClicking"></v-line>

          <v-line v-if = "shape.type === 'triangle' " :config="{
            points: shape.points,
            stroke: shape.stroke,
            fill : shape.fill,
            draggable: true,
            closed:true
          }" @click= "handleShapeClicking(shape)"></v-line>

          <v-circle v-if="shape.type === 'circle' " :config="{
          x: shape.x,
          y: shape.y,
          radius: shape.radius,
          fill: shape.fill,
          stroke: shape.stroke,
          draggable: true}" @click= "handleShapeClicking(shape)"></v-circle>

          <v-rect v-if="shape.type === 'rectangle' || shape.type === 'square' "  :config="{
          x: shape.x,
          y: shape.y,
          width: shape.width,
          height: shape.height,
          fill: shape.fill,
          stroke: shape.stroke,
          draggable: true}" @click= "handleShapeClicking(shape)"> </v-rect>

          <v-ellipse v-if="shape.type === 'ellipse' "  :config="{
          x: shape.x,
          y: shape.y,
          radiusX: shape.radiusX,
          radiusY: shape.radiusY,
          fill: shape.fill,
          stroke: shape.stroke,
          draggable: true}" @click= "handleShapeClicking(shape)"> </v-ellipse>

        </template>

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
        width: 1200,
        height: 550
      },
    }
  },
  methods:{
    addShape(e){
      this.$emit('add', e)
    },
    handleShapeClicking(shape){
      this.$emit('shapeClick', shape)
    }
  }
}

</script>

<style scoped>
.canvas{
  margin: auto;
  background-color: azure;
  width: 1200px;
  height: 550px;
  border: 3px solid #000000;
}
</style>