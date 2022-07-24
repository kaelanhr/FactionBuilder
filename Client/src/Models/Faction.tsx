export default class Faction implements IFactionAttributes {
	constructor(attributes?: Partial<IFactionAttributes>) {
		// super(attributes);

		if(attributes) {
			if(attributes.name) {
				this.name = attributes.name
			}
			if(attributes.origin) {
				this.origin = attributes.origin
			}
		}

	}
	name: String;
	origin: String;

}

export interface IFactionAttributes {
	name: String,
	origin: String
}