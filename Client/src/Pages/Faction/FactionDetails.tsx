import Faction from "../../Models/Faction";

export default function FactionDetails(faction: Faction) {
	return (
		<>
			<div>FactionDetails</div>
			<h1>{faction.name}</h1>
			<p>{faction.origin}</p>
		</>
	);
}
