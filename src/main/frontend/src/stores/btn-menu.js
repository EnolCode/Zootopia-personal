import {ref, computed} from "vue"
import { defineStore } from 'pinia';

export const useStore = defineStore('btn',()=> {
  // state: () => {
  //   return{
  //     isSideMenuOpen: true,

  //   }
  // },
  // getters: {
  //   stateMenu: (state) => state.isSideMenuOpen
  // },
  // actions: {
  //   toggleSideMenu(state) {
  //     state.isSideMenuOpen = !state.isSideMenuOpen
  //   },
  // },

  const isSideMenuOpen = ref(true);

  const toggleSideMenu = () => {
      isSideMenuOpen.value = !isSideMenuOpen.value
  };
  return{
    //State properties
    isSideMenuOpen,
    // Getters
    stateMenu: computed(() => isSideMenuOpen.value),
    // Actions
    toggleSideMenu,
  }
});
