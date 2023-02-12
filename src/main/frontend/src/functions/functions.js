import axios from "axios";


export const transformData = (data) => {
  return data.map((item) => {
    return {
      id: item.id,
      name: item.name,
      date: item.date,
      country: item.country.country,
      type: item.type.type,
      family: item.family.family,
      gender: item.gender.gender,
    };
  });
};

// export const deleteRow =  async(selected,url) => {

//   axios.delete(url + selected[0].id)
//   .then((res) => {
//       const index = rows.value.findIndex( row => row.id === selected[0].id);
//       rows.value.splice(index, 1);
//     })
//     .catch((err) => console.log(err));

// };
