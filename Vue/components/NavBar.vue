<template>
  <div class="ToolBar">
    <span style="position: absolute;left: 0;">
      <button class="UnRedo"><i class="fas fa-undo"></i></button>
      <button class="UnRedo"><i class="fas fa-redo"></i></button>
    </span>
    <span>
      <button class="function" @click="chooseColor">Color</button>
      <button class="function">Resize</button>
      <button class="function">Copy</button>
      <button class="function">Delete</button>
    </span>
    <span style="position: absolute;right: 0;">
      <button class="SaveLoad" @click="Saver" >Save</button>
      <button class="SaveLoad" @click="this.$emit('load')">Load</button>
    </span>
  </div>
  <div>
    <div v-if="showDropdown" class="dropdown">
      <label for="myDropdown">Select an option:</label>
      <select v-model="selectedOption" id="myDropdown">
        <option v-for="file in fileType" :key="file">
          {{ file}}
        </option>
      </select>
    </div>
  </div>
  <span>{{selectedOption}}</span>
</template>


<script>

export default {
  name: 'NavBar',
  emits: ['choose', 'save', 'load'],
  data() {
    return {
      selectedFile: null,
      showDropdown: false,
      fileType:['json','xml'],
    };
  },
  methods: {
    Saver(){
      this.toggleDropdown()
      this.$emit('save')
      
    },
    chooseColor() {
      this.$emit('choose')
    },
    toggleDropdown() {
      this.showDropdown = !this.showDropdown;
    },
  }
}

</script>

<style scoped>
.ToolBar {
  position: relative;
  margin: auto auto 2px;
  width: 1200px;
  height: 30px;
}

.SaveLoad {
  border: 2px solid black;
  border-radius: 5px;
  background: none;
  cursor: pointer;
  font-size: 22px;
  margin-left: 5px;
}

.UnRedo {
  border: none;
  background: none;
  cursor: pointer;
  font-size: 21px;
  margin-top: 5px;
}

.function {
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