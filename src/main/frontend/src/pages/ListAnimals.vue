<script setup>
import { onMounted, ref, reactive } from "vue";
import axios from "axios";
let datos = reactive("");
const rows = ref([]);
onMounted(() => {
  axios
    .get("http://localhost:8080/api/animals")
    .then((response) => (rows.value = response.data));
  rows.value.forEach((row, index) => {
    row.index = index;
  });
});

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
  // { name: 'type', label: 'type', field: 'animals.gender', sortable: true, align: 'center',}
];

// export default {
//   setup () {
//     return {
//       columns,
//       rows,

pagination: ref({
  rowsPerPage: 10,
});
//     }
// }
// }
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
    />
  </div>
</template>

<style lang="scss" scoped></style>
