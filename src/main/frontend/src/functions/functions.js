import axios from "axios";


let family;
const typeFamily = (type) => {
  if(type === "Lion" || type === "Tiger" || type === "Leopard" || type === "Jaguar" ) return "Felidae";
  if(type === "Cocodrile" || type === "Snake" || type === "Iguana"  ) return "Reptiles";
  if(type === "Orangutan" || type === "Gorilla" || type === "Chimpanzee"  ) return "Hominidae";
  if(type === "Jackal" || type === "Wolf" || type === "Fox"  ) return "Canidae";
  if(type === "Wasel" || type === "Otter" ) return "Mustelidae";
}

export const transformData = (data) => {
  return data.map((item) => {
    let type = item.type.type;
    console.log(type)
    return {
      id: item.id,
      name: item.name,
      date: item.date,
      country: item.country.country,
      type: item.type.type,
      family:typeFamily(type),
      gender: item.gender
    };
  });
};

