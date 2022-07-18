import { DefaultButton, PrimaryButton, TextField } from "@fluentui/react";
import { useNavigate } from "react-router-dom";

export default function CreateFaction() {
	let navigate = useNavigate();

	return (
		<>
			<div>CreateFaction</div>
			<TextField label="Name" />
			<TextField label="origin" multiline />
			<DefaultButton text="Cancel" onClick={() => navigate("/faction")} />
			<PrimaryButton text="Submit" onClick={() => navigate("/faction")} />
		</>
	);
}
