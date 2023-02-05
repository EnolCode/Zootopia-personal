<script setup>
import {  ref, onBeforeMount, computed } from 'vue'
import EssentialLink from 'components/EssentialLink.vue'
import { linksList } from 'src/router/link-list';
import  { useStore } from "src/stores/btn-menu"
import { storeToRefs } from 'pinia';

const store = useStore()
let { stateMenu } = storeToRefs(store)
let { toggleSideMenu } = store

// console.log(toggleSideMenu)

// let sideMenuOpen = computed(()=>{ stateMenu.value })
// console.log(sideMenuOpen)

</script>
<template>

  <q-layout view="lHh Lpr lFf">
    <q-header elevated>
      <q-toolbar>
        <q-btn
          flat
          dense
          round
          icon="fa-solid fa-bars"
          aria-label="Menu"
          @click="toggleSideMenu"
        />

        <q-toolbar-title>
          Quasar App
        </q-toolbar-title>

        <!-- TODO: <div>Quasar v{{ $q.version }}</div> -->
      </q-toolbar>
    </q-header>

    <q-drawer
      v-model="stateMenu"
      show-if-above
      bordered
    >
      <q-list>
        <q-item-label
          header
        >
          Essential Links
        </q-item-label>

        <EssentialLink
          v-for="link in linksList"
          :key="link.title"
          v-bind="link"
        />
      </q-list>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

