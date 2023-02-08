<script setup>
import { ref } from "vue";
import { Notify, useQuasar } from "quasar";
import { useRouter } from "vue-router";

const router = useRouter();

const $q = useQuasar();
const redirectToLogin = () => {
  router.push({ path: "/list" });
};

let password = ref("");
let password2 = ref("");
let isPwd = ref(true);

const userForm = ref({
  email: "",
  password1: "",
  password2: "",
});

const onSubmit = () => {
  redirectToLogin();
};

const onReset = () => {
  userForm.value = {
    email: "",
    password1: "",
    password2: "",
    conditions: false,
    errorConditions: false,
  };
};

const isValidEmail = (val) => {
  const emailPattern =
    /^(?=[a-zA-Z0-9@._%+-]{6,254}$)[a-zA-Z0-9._%+-]{1,64}@(?:[a-zA-Z0-9-]{1,63}\.){1,8}[a-zA-Z]{2,63}$/;
  return emailPattern.test(val) || "Email no valid";
};

const isSendPassword = (val) => {
  return val === userForm.value.password1 || "Las contraseñas no son iguales";
};
</script>
<template>
  <q-page class="row">
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
        <span class="text-h1 text-weight-bold">LOG IN</span>
        <q-input
          filled
          v-model="userForm.email"
          label="Email"
          type="email"
          lazy-rules
          :rules="[
            (val) => (val && val.length > 0) || 'This field is required',
            isValidEmail,
          ]"
        />

        <q-input
          v-model="userForm.password1"
          filled
          :type="isPwd ? 'password' : 'text'"
          lazy-rules
          :rules="[
            (val) => (val && val.length > 0) || 'This field is required',
            isSendPassword
          ]"
          label="Password"
        >
          <template v-slot:append>
            <q-icon
              :name="isPwd ? 'visibility_off' : 'visibility'"
              class="cursor-pointer"
              @click="isPwd = !isPwd"
            />
          </template>
        </q-input>

        <q-input
        v-model="userForm.password2"
          filled
          :type="isPwd ? 'password' : 'text'"
          lazy-rules
          :rules="[
            (val) => (val && val.length > 0) || 'This field is required',
             isSendPassword
          ]"
          label="Repeat password"
        >
          <template v-slot:append>
            <q-icon
              label="repeat password"
              :name="isPwd ? 'visibility_off' : 'visibility'"
              class="cursor-pointer"
              @click="isPwd = !isPwd"
            />
          </template>
        </q-input>

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
