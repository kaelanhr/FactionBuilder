import { DefaultButton, PrimaryButton, TextField } from "@fluentui/react";

export default function CreateFaction() {
	return (
		<>
			<div>CreateFaction</div>
			<TextField label="Name" />
			<TextField label="origin" multiline />
			<DefaultButton text="Cancel" />
			<PrimaryButton text="Submit" />
		</>
	);
}
