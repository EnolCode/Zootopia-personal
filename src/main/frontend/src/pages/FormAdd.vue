<script setup>
import { ref } from "vue";
import { Notify, useQuasar } from "quasar";
import { useRouter } from "vue-router";
import axios from "axios";

const router = useRouter();

const $q = useQuasar();

const gender = ref(null);
const options = ["Male", "Female"];

let nameModel = ref("");
let typeModel = ref("");
let genderModel = ref("");
let countryModel = ref("");

const onSubmit = async () => {
  axios({
    method: "POST",
    url: "http://localhost:8080/api/animals/",

    data: {
      name: nameModel.value,
      type: typeModel.value,
      gender: genderModel.value,
      country: countryModel.value,
    },
  })
    .then((res) =>
      $q.notify({
        type: "positive",
        message: "Animal added successfully!",
        icon: "fa-solid fa-circle-check",
      })
    )
    .catch((err) => console.log(err));
  onReset();
};

const onReset = () => {
  nameModel.value = "";
  typeModel.value = "";
  genderModel.value = "";
  countryModel.value = "";
};
</script>
<template>

<q-page class="row justify-between ">

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

    <div class="row col-12 col-md-5 col-lg-5 col-xl-5 justify-center items-center">
      <q-form
        @submit="onSubmit"
        @reset="onReset"
        class="q-gutter-lg col-8 "
      >
        <span class="text-h3 text-weight-bold">Add Animal</span>
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

        <q-input
          filled
          v-model="typeModel"
          label="Type"
          type="text"
          lazy-rules="ondemand"
          :rules="[
            (typeModel) =>
              (typeModel && typeModel.length > 3) || 'This field is required',
          ]"
        />

        <q-select
          filled
          v-model="genderModel"
          :options="options"
          label="Gender"
          required
        />

        <q-input
          filled
          v-model="countryModel"
          label="country"
          type="text"
          lazy-rules="ondemand"
          :rules="[
            (val) => (val && val.length > 3) || 'This field is required',
          ]"
        />

        <div class="column justify-end">
          <q-btn
            label="Reset"
            type="reset"
            color="black"
            flat
            class="q-mb-md btn-reset"
          />
          <q-btn unelevated label="Submit" type="submit" color="black" />
        </div>
      </q-form>
    </div>
    <q-img
      src="https://3.bp.blogspot.com/-2F5CBcSeVbs/VtVvzRarBYI/AAAAAAAAMHA/1F30Ax_zWks/s1600/zootopia-zootropolis-poster.jpg"
      spinner-color="white"
      class="col-0 col-xl-7 col-lg-7 col-md-7"
      style="height: 95vh"
    />

  </q-page>
</template>

<style lang="scss" scoped>
.btn-reset {
  border: 1px solid black;
}

.nav{
  width: 100vw;
}
</style>
