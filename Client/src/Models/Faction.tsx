import axios, { AxiosResponse } from "axios";

export default class Faction implements IFactionAttributes {
	constructor(attributes?: Partial<IFactionAttributes>) {
		// super(attributes);

		if (attributes) {
			if (attributes.name) {
				this.name = attributes.name;
			}
			if (attributes.origin) {
				this.origin = attributes.origin;
			}
		}
	}
	name: string;
	origin: string;

	public create = (): Promise<AxiosResponse<Faction>> => {
		return axios.post("/api/faction/", {
			name: this.name,
			origin: this.origin,
		});
	};
}

export interface IFactionAttributes {
	name: string;
	origin: string;
}
