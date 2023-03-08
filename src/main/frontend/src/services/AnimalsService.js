import { ref } from "vue";
import axios from "axios";
import { transformData } from "../functions/functions.js";

class AnimalsService {
  animals;
  url = "http://localhost:8080/api/animals/";

  constructor() {
    this.animals = ref([]);
  }

  getAnimals() {
    return this.animals;
  }

  async fetchAll() {
    try {
      await axios.get(this.url).then((response) => {
        const transformedData = transformData(response.data);
        this.animals.value = transformedData;
        console.log(transformedData)
      });
    } catch (err) {}
  }

  async deleteAnimal(props, rows) {
    try {
      axios
        .delete(this.url + props.id)
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
