<template>
  <div class = "shapes-buttons">
    <button class="ShapeButton" @click="this.$emit('select','line')">Line</button>
    <button class="ShapeButton" @click="this.$emit('select','square')">Square</button>
    <button class="ShapeButton" @click="this.$emit('select','rectangle') ">Rectangle</button>
    <button class="ShapeButton" @click="this.$emit('select','triangle')">Triangle</button>
    <button class="ShapeButton" @click="this.$emit('select','circle')">Circle</button>
    <button class="ShapeButton" @click="this.$emit('select','ellipse')">Ellipse</button>
  </div>
</template>

<script >
export default {
  emits:['select'],
}
</script>

<style scoped>

.ShapeButton{
  width: 130px;
  height: 100%;
  border: 2px solid black;
  border-radius: 10px;
  background-color: rgb(34, 1, 1);
  opacity: 0.5;
  margin: 5px;
  font-size: 25px;
  font-weight: 600;
  color: rgb(230, 0, 0);
  cursor: pointer;
}
.shapes-buttons{
  width: 1200px;
  margin: auto;
  display: flex;
  justify-content: space-around;
}
</style>