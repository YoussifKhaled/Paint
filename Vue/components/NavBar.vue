<template>

  <div class="ToolBar">
    <span style="position: absolute;left: 0;">
      <button class="UnRedo"><i class="fas fa-undo"></i></button>
      <button class="UnRedo"><i class="fas fa-redo"></i></button>
    </span>
    <span>
      <button class="function" @click = "this.$emit('selectColor')" > Color</button>
      <button class="function">Resize</button>
      <button class="function" @click = "this.$emit('copy')">Copy</button>
      <button class="function" @click = "this.$emit('delete')" > Delete</button>
    </span>

    <span style="position: absolute;right: 0;">

      <span v-if="showDropdown" class="dropdown">

        <label for="myDropdown">Select file type:</label>
        <select v-model="selectedOption" id="myDropdown" @change="save">
          <option v-for="file in fileType" :key="file">
            {{ file}}
          </option>
        </select>

      </span>

      <button class="SaveLoad" @click = " this.showDropdown = !this.showDropdown" >Save</button>
      <button class="SaveLoad" @click = "this.$emit('load')">Load</button>
    </span>


  </div>
</template>


<script>
export default {
  name: 'NavBar',
  emits: ['selectColor','delete','copy','save','load'],
  data () {
    return {
      showDropdown: false,
      selectedOption: '',
      fileType: ['json', 'xml']
    }
  },
  methods:{
    save(){
      if(this.selectedOption)
      this.$emit('save',this.selectedOption)
      this.showDropdown = false
    },
  }
}

</script>

<style scoped>
.ToolBar{
  position: relative;
  margin: auto auto 2px;
  width: 1100px;
  height: 30px;
}
.SaveLoad{
  border: 2px solid black;
  border-radius: 5px;
  background:  rgb(197, 232, 152);
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