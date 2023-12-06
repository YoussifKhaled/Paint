<template>
  <div class="ToolBar">
    <span style="position: absolute;left: 0;">
      <button class="UnRedo"><i class="fas fa-undo"></i></button>
      <button class="UnRedo"><i class="fas fa-redo"></i></button>
    </span>
    <span>
      <button class="function" :class="{Selected: CrntOprtn === 'Cl'}" @click="this.$emit('Color')">Color</button>
      <button class="function" :class="{Selected: CrntOprtn === 'S'}" @click="this.$emit('Size')">Resize</button>
      <button class="function" :class="{Selected: CrntOprtn === 'Cp'}" @click="this.$emit('Copy')">Copy</button>
      <button class="function" :class="{Selected: CrntOprtn === 'Dl'}" @click="this.$emit('Del')">Delete</button>
    </span>
    <span style="position: absolute;right: 0;">
      <button class="SaveLoad">Save</button>
      <button class="SaveLoad">Load</button>
    </span>
  </div>
</template>

<script>
export default {
  name: 'NavBar',
  emits: ['Color','Size','Copy','Del'],
  props: {CrntOprtn: String}
}
</script>

<style scoped>
.Selected{
  border: 4px solid rgb(9, 218, 9) !important;
  border-radius: 10px !important;
  background-color: aquamarine !important;
  text-decoration: none !important;
}
.ToolBar{
  position: relative;
  margin: auto auto 2px;
  width: 800px;
  height: 30px;
}
.SaveLoad{
  border: 2px solid black;
  border-radius: 5px;
  background: rgb(197, 232, 152);
  color: rgb(7, 102, 173);
  cursor: pointer;
  font-size: 22px;
  margin-left: 5px;
}
.UnRedo{
  border-radius: 50px;
  background: rgb(197, 232, 152);
  color: rgb(7, 102, 173);
  cursor: pointer;
  font-size: 21px;
  margin-right: 3px;
}
.function{
  background: none;
  border: none;
  font-size: larger;
  font-weight: bold;
  text-decoration: underline;
  color: rgb(7, 102, 173);
  cursor: pointer;
  margin-left: 10px;
  margin-right: 10px;
}
</style>