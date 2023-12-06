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
  border: none;
  border-radius: 10px;
  background-color: rgb(41, 173, 178);
  margin: 5px;
  font-size: 25px;
  font-weight: 600;
  color: rgb(7, 102, 173);
  cursor: pointer;
}
.shapes-buttons{
  width: 1100px;
  margin: auto;
  display: flex;
  justify-content: space-around;
}
</style>