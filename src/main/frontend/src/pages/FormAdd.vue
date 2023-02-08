<script setup>
import { ref } from "vue";
import { Notify, useQuasar } from "quasar";
import { useRouter } from "vue-router";
import axios from "axios";

const router = useRouter();

const $q = useQuasar();
const redirectToLogin = () => {
  router.push({ path: "/list" });
};

const userForm = ref({
  name: "",
  // date: "",
  // type: "",
  // family: "",
  // country: "",
  // gender: "",
});
let nameModel = ref("");
let typeModel = ref("");
let genderModel = ref("");
let familyModel = ref("");
let countryModel = ref("");

const onSubmit =  async() => {

    axios({
      method: 'POST',
      url: "http://localhost:8080/api/animals/",

      data: {
        name: nameModel.value,
        type: typeModel.value,
        gender: genderModel.value,
        country: countryModel.value,
        family: familyModel.value
        // type:{
        //   "type": typeModel.value
        // },
        // gender:{
        //   "gender": genderModel.value
        // },
        // type:{
        //   "type": typeModel.value
        // },
      }
    })
      .then(res=>console.log(res))
      .catch(err=>console.log(err))
    };


const onReset = () => {
  userForm.value = {
    name: "",
    // password1: "",
    // password2: "",
    // conditions: false,
    // errorConditions: false,
  };
};
</script>
<template>
  <q-page class="row">
    <div class="q-pa-md q-gutter-sm bg-grey-3 col-12">
    <q-breadcrumbs>
      <q-breadcrumbs-el icon="fa-solid fa-house-circle-xmark" to="/" style="font-size:16px;" />
      <q-breadcrumbs-el label="List" icon="fa-solid fa-list" to="/list" />
    </q-breadcrumbs>
  </div>
    <div class="row col-12 items-center">
      <q-img
        src="https://images.moviesanywhere.com/cac313fcf9373e9446b6bb8ff171b8d1/8b8d6a81-b8e6-49ad-b835-32c2f01a03c5.jpg"
        spinner-color="white"
        class="col-0 col-xl-7 col-lg-7 col-md-7"
        style="height: 100vh"
      />
      <q-form
        @submit="onSubmit"
        @reset="onReset"
        class="column q-gutter-xl col-10 col-md-4 col-lg-4 col-xl-4 q-pl-xl"
      >
        <span class="text-h1 text-weight-bold">Add Animal</span>
        <q-input
          filled
          v-model="nameModel"
          label="Name"
          type="text"
          lazy-rules
        />

        <q-input
          filled
          v-model="typeModel"
          label="Type"
          type="text"
          lazy-rules

        />

        <q-input
          filled
          v-model="genderModel"
          label="Gender"
          type="text"
          lazy-rules

        />

        <q-input
          filled
          v-model="countryModel"
          label="country"
          type="text"
          lazy-rules

        />

        <q-input
          filled
          v-model="familyModel"
          label="family"
          type="text"
          lazy-rules

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
  </q-page>
</template>

<style lang="scss" scoped>
.btn-reset {
  border: 1px solid black;
}
</style>
