<script setup>
import { ref } from "vue";
import { Notify, useQuasar } from "quasar";
import { useRouter } from "vue-router";
import axios from "axios";

const router = useRouter();

const $q = useQuasar();

const options = [
  { value: "Male", label: "Male" },
  { value: "Female", label: "Female" },
];
const optionsCountry = [
  { value: 1, label: "Spain" },
  { value: 2, label: "French" },
  { value: 3, label: "Belgium" },
  { value: 4, label: "Australia" },
  { value: 5, label: "Canada" },
  { value: 6, label: "India" },
  { value: 7, label: "Ireland" },
  { value: 8, label: "Jamaica" },
  { value: 9, label: "New Zealand" },
  { value: 10, label: "Singapore" },
  { value: 11, label: "South Africa" },
  { value: 12, label: "United Kingdom" },
  { value: 13, label: "United States" },
];

const optionsType = [
  { value: 1, label: "Lion" },
  { value: 2, label: "Tiger" },
  { value: 3, label: "Orangutan" },
  { value: 4, label: "Iguana" },
  { value: 5, label: "Fox" },
  { value: 6, label: "Snake" },
  { value: 7, label: "Crocodile" },
  { value: 8, label: "Wolf" },
  { value: 9, label: "Jaguar" },
  { value: 10, label: "Leopard" },
  { value: 11, label: "Gorilla" },
  { value: 12, label: "Chimpanzee" },
  { value: 13, label: "weasel" },
  { value: 14, label: "jackal" },
  { value: 15, label: "otter" },
];

const selectRule = (val) => {
  if (!val) {
    return "You must make a selection!";
  }
};

let nameModel = ref("");
let typeModel = ref("");
let genderModel = ref("");
let countryModel = ref("");
let dateModel = ref("");

const onSubmit = async () => {
  axios({
    method: "POST",
    url: "http://localhost:8080/api/animals/",

    data: {
      name: nameModel.value,
<<<<<<< HEAD
      type: typeModel.value,
      gender: genderModel.value,
      country: countryModel.value,
=======
      gender: genderModel.value,
      date: dateModel.value,
      country: {
        idCountry: countryModel.value.value +1,
      },
      type: {
        idType: typeModel.value.value +1,
      },
>>>>>>> refactorizandoServicios
    },
  })
  // axios({
  //   method: "POST",
  //   url: "http://localhost:8080/api/type/",

  //   data: {
  //     type: typeModel.value
  //     // gender: genderModel.value,
  //     // country: countryModel.value,
  //   },
  // })
  // axios({
  //   method: "POST",
  //   url: "http://localhost:8080/api/country/",

  //   data: {
  //     // name: nameModel.value,
  //     // type: typeModel.value,
  //     // gender: genderModel.value,
  //     country: countryModel.value,
  //   },
  // })
    .then((res) =>
      $q.notify({
        type: "positive",
        message: "Animal added successfully!",
        icon: "fa-solid fa-circle-check",
      })
      )
      // console.log(data)
    .catch((err) => console.log(err));
  onReset();
};

const onReset = () => {
  nameModel.value = "";
  typeModel.value = "";
  genderModel.value = "";
  countryModel.value = "";
  dateModel.value = "";
};
</script>
<template>
  <q-page class="row justify-between bg-brown-1">
    <div class="nav q-pa-md q-gutter-sm bg-grey-3">
      <q-breadcrumbs>
        <q-breadcrumbs-el
          icon="fa-solid fa-house-circle-xmark"
          to="/"
          style="font-size: 16px"
        />
        <q-breadcrumbs-el label="List" icon="fa-solid fa-list" to="/list" />
      </q-breadcrumbs>
    </div>
    <q-img
      src="https://3.bp.blogspot.com/-2F5CBcSeVbs/VtVvzRarBYI/AAAAAAAAMHA/1F30Ax_zWks/s1600/zootopia-zootropolis-poster.jpg"
      spinner-color="white"
      class="col-sm-6 col-md-7 col-lg-7 gt-xs"
      style="height: 95vh"
    />

    <div class="container-form row col-12 col-sm-6 col-md-5 col-lg-5 col-xl-5 flex-center"
    >
      <q-form @submit="onSubmit" @reset="onReset" class="q-gutter-lg col-8">
        <span class="title text-h3 text-weight-bold">Add Animal</span>
        <q-input
          filled
          v-model="nameModel"
          label="Name"
          type="text"
          lazy-rules="ondemand"
          :rules="[
            (val) => (val && val.length > 3) || 'This field is required',
          ]"
        />

        <q-select
          filled
          v-model="typeModel"
          :options="optionsType"
          label="type"
          lazy-rules="ondemand"
          :rules="[selectRule]"
          behavior="menu"
        />

        <q-select
          filled
          v-model="countryModel"
          :options="optionsCountry"
          label="Country"
          lazy-rules="ondemand"
          :rules="[selectRule]"
          behavior="menu"
        />

        <q-input
          v-model="dateModel"
          filled
          type="date"
          hint="Date of admission"
        />

        <div class="q-pa-sm">
          <q-option-group
            v-model="genderModel"
            :options="options"
            color="brown"
            inline
            dense
            :rules="[selectRule]"
          />
        </div>
        <div class="column justify-end">
          <q-btn
            label="Reset"
            type="reset"
            color="brown-8"
            flat
            class="q-mb-md btn-reset"
          />
          <q-btn unelevated label="Submit" type="submit" color="brown-8" />
        </div>
      </q-form>
    </div>
  </q-page>
</template>

<style lang="scss" scoped>
@use "../css/mixins.scss" as m;
.btn-reset {
  border: 1px solid $brown;
}

.nav {
  width: 100vw;
}

.title {
  color: $brown;
  @include m.mv(850px){
                  font-size: 2em;
          }

  @include m.mv(500px){
                  font-size: 2.5em;
          }
}

.container-form {
  @include m.mv(600px){
                  align-items: start;
          }

}

</style>
