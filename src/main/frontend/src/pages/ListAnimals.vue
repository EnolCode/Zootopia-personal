<script setup>
import { onMounted, ref, reactive } from "vue"
import axios from "axios"
let datos = reactive("")
const rows = ref([])
onMounted(()=>{
   axios.get("https://jsonplaceholder.typicode.com/posts/")
    .then(response => rows.value = response.data )
    rows.value.forEach((row, index) => {
      row.index = index
    })
  })
  console.log(rows)

  const columns = [
  {
    name: 'id',
    label: '#',
    field: 'id',
    align: 'left',
  },
  {
    name: 'userId',
    label: 'userId',
    field: 'userId',
    sortable: true
  },

  { name: 'title',  label: 'title', field: 'title', sortable: true, align: 'center', },
  { name: 'body', label: 'body', field: 'body', sortable: true, align: 'center',}
]



// export default {
//   setup () {
//     return {
//       columns,
//       rows,

      pagination: ref({
        rowsPerPage: 10
      })
//     }
  // }
  // }
</script>
<template>
  <!-- <div v-for="post in datos" :key="post.id">
    <h2>{{ post.body }}</h2>
  </div> -->

   <div class="q-pa-md">
    <q-table
      title="Animales"
      :rows="rows"
      :columns="columns"
      row-key="name"
      dark
      color="amber"
    />
  </div>
</template>

<style lang="scss" scoped>


</style>
