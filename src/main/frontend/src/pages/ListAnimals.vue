<script setup>
import { onMounted, ref, reactive, onUpdated } from "vue";
import axios from "axios";

const rows = ref([]);
let selected = ref([]);
onMounted(() => {
  axios
    .get("http://localhost:8080/api/animals")
    .then((response) => (rows.value = response.data));
});

onUpdated(()=>{

})


const columns = [
  {
    name: "id",
    label: "#",
    field: "id",
    align: "left",
  },
  {
    name: "name",
    label: "name",
    align: "center",
    field: "name",
    sortable: true,
  },

  {
    name: "country",
    label: "country",
    field: "country",
    align: "center",
    sortable: true,
  },

  {
    name: "type",
    label: "type",
    field: "type",
    align: "center",
    sortable: true,
  },

  {
    name: "family",
    label: "family",
    field: "family",
    align: "center",
    sortable: true,
  },

  {
    name: "gender",
    label: "gender",
    field: "gender",
    align: "center",
    sortable: true,
  },
];

pagination: ref({
  rowsPerPage: 10,
});

const deleteAnimal =  async() => {

  axios.delete("http://localhost:8080/api/animals/" + selected.value[0].id)
  .then((res) => {
      const index = rows.value.findIndex( row => row.id === selected.value[0].id);
      rows.value.splice(index, 1);
    })
    .catch((err) => console.log(err));

};
</script>

<template>
<div class="q-pa-md q-gutter-sm bg-grey-3 col-12">
    <q-breadcrumbs>
      <q-breadcrumbs-el icon="fa-solid fa-house-circle-xmark" to="/" style="font-size:16px;" />
      <q-breadcrumbs-el label="Add Animal" icon="fa-solid fa-user-plus" to="/formAdd" />
    </q-breadcrumbs>
  </div>


  <div class="q-pa-md">
    <q-table
      title="Animales"
      :rows="rows"
      :columns="columns"
      row-key="name"
      dark
      color="amber"
      selection="single"
      v-model:selected="selected"
    />
    <q-btn-group rounded>
      <q-btn color="amber" rounded glossy icon="timeline" @click="deleteAnimal" />
      <q-btn color="amber" rounded glossy icon="visibility" />
      <q-btn color="amber" rounded glossy icon-right="update" label="Update" />
    </q-btn-group>

  </div>
</template>

<style lang="scss" scoped></style>
