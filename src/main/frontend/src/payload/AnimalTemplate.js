export default class AnimalTemplate {
	#name;
	#date;
	#country;
	#family;


	constructor(name, date, country, family) {
		this.name = name;
		this.date = date;
		this.country = country.country;
    this.family = family.name
	}

	get name() {
		return this.#name;
	}

	set name(name) {
		this.#name = name;
	}

	get date() {
		return this.#date;
	}

	set date(subject) {
		this.#date = date;
	}

	get country() {
		return this.#country;
	}

	set country(country) {
		this.#country = country;
	}

  get family(){
    this.#family
  }

  set family(family) {
		this.#family = family;
	}
}
