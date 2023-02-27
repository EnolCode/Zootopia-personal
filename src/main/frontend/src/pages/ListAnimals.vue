<script setup>
import { onMounted, ref, reactive, onUpdated } from "vue";
import axios from "axios";
import  { transformData }  from "../functions/functions.js"

const rows = ref([]);
const urlAnimal = "http://localhost:8080/api/animals";

onMounted(() => {
  axios
  .get(urlAnimal)
  .then((response) => {
    const transformedData = transformData(response.data);
    rows.value = transformedData;
  });
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
    label: "Gender ",
    field: "gender",
    align: "center",
    sortable: true,
  },

  {
    name: "actions",
    label: "Actions",
    field: "actions",
    align: "center",
  },

];

pagination: ref({
  rowsPerPage: 10,
});

const deleteAnimal =  async(props) => {
console.log(props.id)
  axios.delete("http://localhost:8080/api/animals/" + props.id)
  .then((res) => {
      const index = rows.value.findIndex( row => row.id === props.id);
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
      class="col-8"
      :grid="$q.screen.sm"
      :rows-per-page-options="[10]"
    >
    <template #body-cell-actions="props">
        <q-td key="actions" align="center" >
              <q-btn name="delete"  icon='delete' size="md" class="q-mr-sm" color="red" @click="deleteAnimal(props.row)"/>
              <q-btn name="modify"  icon='edit' size="md" color="blue"/>
        </q-td>
    </template>
    </q-table>
  </div>

</template>

<style lang="scss" scoped></style>
