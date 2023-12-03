<template>

  <div class="ToolBar">
    <span style="position: absolute;left: 0;">
      <button class="UnRedo"><i class="fas fa-undo"></i></button>
      <button class="UnRedo"><i class="fas fa-redo"></i></button>
    </span>
    <span>
      <button class="function" @click = "chooseColor" >Color</button>
      <button class="function">Resize</button>
      <button class="function">Copy</button>
      <button class="function">Delete</button>
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
  emits: ['choose'],
  methods: {
    chooseColor() {
      this.$emit('choose')
    }
  },
}

</script>

<style scoped>
.ToolBar{
  position: relative;
  margin: auto auto 2px;
  width: 1200px;
  height: 30px;
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
</style>