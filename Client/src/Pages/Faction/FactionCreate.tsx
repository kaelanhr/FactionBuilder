import { DefaultButton, PrimaryButton } from "@fluentui/react";
import { useNavigate } from "react-router-dom";
import Faction from "../../Models/Faction";
import  {TextField} from "../../Components/TextField"

export default function CreateFaction() {
	let navigate = useNavigate();

	const faction = new Faction();

	const submit =  async ()  => {
		console.log(faction);
		await faction.create().then(() => {
			 navigate("/faction");
		});
	}

	return (
		<>
			<div>Create Faction</div>
			<TextField model={faction} modelProperty="name" label="Name" />
			<TextField
				model={faction}
				modelProperty="origin"
				label="Origin"
				multiline
			/>
			<DefaultButton text="Cancel" onClick={() => navigate("/faction")} />
			<PrimaryButton text="Submit" onClick={() => submit()} />
		</>
	);
}
