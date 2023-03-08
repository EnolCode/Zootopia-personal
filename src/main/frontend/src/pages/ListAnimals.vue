<script setup>
import { onBeforeMount, ref, reactive} from "vue";
import AnimalsService from "../services/AnimalsService.js"

let rows = ref([]);
const service = new AnimalsService;
const animals = service.getAnimals();

onBeforeMount(async () => {
  await service.fetchAll();
  rows.value = animals.value
  console.log(rows.value)
})

const deleteAnimal =  async(props) => {
await service.deleteAnimal(props,rows)
};

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


</script>

<template>
<div class="q-pa-md q-gutter-sm bg-grey-3">
    <q-breadcrumbs>
      <q-breadcrumbs-el icon="fa-solid fa-house-circle-xmark" to="/" style="font-size:16px;" />
      <q-breadcrumbs-el label="Add Animal" icon="fa-solid fa-user-plus" to="/formAdd" />
    </q-breadcrumbs>
  </div>

  <div class="column q-pa-md col-6 ">
    <q-table
      title="Animales"
      :rows="rows"
      :columns="columns"
      row-key="name"
      dark
      color="amber"
      selection="single"
      class="table"
      :grid="$q.screen.lt.md"
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

<style lang="scss" scoped>

</style>
