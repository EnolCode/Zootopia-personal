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
    label: "ID",
    field: "id",
    align: "left",
  },
  {
    name: "name",
    label: "Name",
    align: "center",
    field: "name",
    sortable: true,
  },
  {
    name: "date",
    label: "Date of admission",
    field: "date",
    align: "center",
    sortable: true,
  },

  {
    name: "country",
    label: "Country",
    field: "country",
    align: "center",
    sortable: true,
  },

  {
    name: "type",
    label: "Type",
    field: "type",
    align: "center",
    sortable: true,
  },

  {
    name: "family",
    label: "Family",
    field: "family",
    align: "center",
    sortable: true,
  },

  {
    name: "gender",
    label: "Gender",
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
<div class="q-pa-md q-gutter-sm bg-grey-3">
    <q-breadcrumbs>
      <q-breadcrumbs-el icon="fa-solid fa-house-circle-xmark" to="/" style="font-size:16px;" />
      <q-breadcrumbs-el label="Add Animal" icon="fa-solid fa-user-plus" to="/formAdd" />
    </q-breadcrumbs>
  </div>


  <div class="column q-pa-md ">
    <q-table
      title="Animales"
      :rows="rows"
      :columns="columns"
      row-key="name"
      dark
      color="amber"
      selection="single"
      v-model:selected="selected"
      class="col-8"
    />
    <q-btn-group class="self-end q-my-lg">
      <q-btn color="amber" rounded glossy icon="fa-solid fa-trash-can" @click="deleteAnimal" />
      <q-btn color="amber" rounded glossy icon-right="fa-solid fa-pencil"  />
    </q-btn-group>

  </div>
</template>

<style lang="scss" scoped></style>
