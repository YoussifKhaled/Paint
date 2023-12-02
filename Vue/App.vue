<template>
  <div class="ToolBar">
    <span style="position: absolute;left: 0;">
      <button class="UnRedo"><i class="fas fa-undo"></i></button>
      <button class="UnRedo"><i class="fas fa-redo"></i></button>
    </span>
    <span>
      <button class="function">Color</button>
      <button class="function">Resize</button>
      <button class="function">Copy</button>
      <button class="function">Delete</button>
    </span>
    <span style="position: absolute;right: 0;">
      <button class="SaveLoad">Save</button>
      <button class="SaveLoad">Load</button>
    </span>
  </div>
  <div class="canvas">
  </div>
  <div>
    <table>
      <tr style="height: 70px;">
        <button class="ShapeButton">Line</button>
        <button class="ShapeButton">Square</button>
        <button class="ShapeButton">Rectangle</button>
        <button class="ShapeButton">Triangle</button>
        <button class="ShapeButton">Circle</button>
        <button class="ShapeButton">Ellipse</button>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
body{
  background-color: rgb(181, 51, 77);
}
.ToolBar{
  position: relative;
  margin: auto;
  margin-bottom: 2px;
  width: 806px;
  height: 30px;
}
.function{
  background: none;
  border: none;
  font-size: larger;
  font-weight: bold;
  text-decoration: underline;
  color: black;
  cursor: pointer;
  margin-left: 10px;
  margin-right: 10px;
}
.SaveLoad{
  border: 2px solid black;
  border-radius: 5px;
  background: none;
  cursor: pointer;
  font-size: 22px;
  margin-left: 5px;
}
.UnRedo{
  border: none;
  background: none;
  cursor: pointer;
  font-size: 21px;
  margin-top: 5px;
}
.ShapeButton{
  width: 130px;
  height: 100%;
  border: 2px solid black;
  border-radius: 10px;
  background-color: rgb(34, 1, 1);
  opacity: 0.5;
  margin: 2px;
  font-size: 25px;
  font-weight: 600;
  color: rgb(230, 0, 0);
  cursor: pointer;
}
.canvas{
  margin: auto;
  background-color: azure;
  width: 800px;
  height: 400px;
  border: 3px solid #000000;
}
#app{
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  margin-top: 35px;
}
</style>
