<script setup>
import { ref } from "vue";
import { Notify, useQuasar } from "quasar";
import { useRouter } from 'vue-router';

const router = useRouter()

const $q = useQuasar();
const redirectToLogin = () => {
   router.push({ path: '/list'})
  }

const userForm = ref({
  email: "",
  password1: "",
  password2: "",
  conditions: false,
  errorConditions: false,
});

const onSubmit = () => {
  redirectToLogin()
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
  return emailPattern.test(val) || "El correo no parece ser válido";
};

const isSendPassword = (val) => {
  return val === userForm.value.password1 || "Las contraseñas no son iguales";
};
</script>

<template>
  <q-page class="row justify-between ">
    <div class="row col-5 justify-center items-center">

      <q-form
        @submit="onSubmit"
        @reset="onReset"
        class="q-gutter-lg col-10 col-md-4 col-lg-4 col-xl-8"
      >
      <span class="text-h3 text-weight-bold">Welcome Again <q-icon name="fa-solid fa-paw" /> </span>
        <q-input
          filled
          v-model="userForm.email"
          label="Correo electrónico"
          type="email"
          lazy-rules
          :rules="[
            (val) => (val && val.length > 0) || 'Este campo es obligatorio',
            isValidEmail,
          ]"
        />

        <q-input
          filled
          type="password"
          v-model="userForm.password1"
          label="Contraseña"
          lazy-rules
          :rules="[
            (val) => (val && val.length > 0) || 'Este campo es obligatorio',
          ]"
        />

        <q-input
          filled
          type="password"
          v-model="userForm.password2"
          label="Repetir contraseña"
          lazy-rules
          :rules="[
            (val) => (val && val.length > 0) || 'Este campo es obligatorio',
            isSendPassword,
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
          <q-btn unelevated label="Submit" type="submit" class="btn-submit" />
        </div>
      </q-form>
    </div>

    <q-img
        src="https://images.moviesanywhere.com/cac313fcf9373e9446b6bb8ff171b8d1/8b8d6a81-b8e6-49ad-b835-32c2f01a03c5.jpg"
        spinner-color="white"
        class="col-0 col-xl-7 col-lg-7 col-md-7 self-end"
        style="height: 100vh;"
      />

  </q-page>
</template>

<style lang="scss" scoped>
.text-h3{
  color: $orange;
}
.btn-reset{
  border: 1px solid black;
}

.btn-submit{
  color: white;
  background-color: $orange;
}
</style>
