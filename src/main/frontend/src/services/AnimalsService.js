import { ref } from "vue";
import axios from "axios";
import { transformData } from "../functions/functions.js";

class AnimalsService {
  animals;

  constructor() {
    this.animals = ref([]);
  }

  getAnimals() {
    return this.animals;
  }

  async fetchAll() {
    try {
      await axios.get("http://localhost:8080/api/animals").then((response) => {
        const transformedData = transformData(response.data);
        this.animals.value = transformedData;
      });
    } catch (err) {}
  }

  async deleteAnimal(props, rows) {
    try {
      axios
        .delete("http://localhost:8080/api/animals/" + props.id)
        .then((res) => {
          const index = rows.value.findIndex((row) => row.id === props.id);
          rows.value.splice(index, 1);
        });
    } catch (err) {
      console.log(err);
    }
  }
}

export default AnimalsService;
