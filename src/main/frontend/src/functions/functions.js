import axios from "axios";


export const transformData = (data) => {
  return data.map((item) => {
    return {
      id: item.id,
      name: item.name,
      date: item.date,
      country: item.country.country,
      type: item.type.type,
      gender: item.gender
    };
  });
};

