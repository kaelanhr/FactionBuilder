import {
	DetailsList,
	DetailsListLayoutMode,
	IColumn,
	SelectionMode,
} from "@fluentui/react";
import axios from "axios";
import { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import Faction from "../../Models/Faction";

export interface IFaction {
	name: string;
}

export default function FactionList() {
	let navigate = useNavigate();
	const [first, setfirst] = useState<any>("loading");
	const [data, setData] = useState<Faction[] | null>(null);

	const _onRowClick = (row: string): void => {
		navigate("/faction/view/" + row);
	};

	useEffect(() => {
		fetchData();
	}, []);

	const fetchData = async () => {
		await axios.get<Faction[]>("/api/faction").then((response) => {
			if (response.data != null) {
				setData(response.data);
				setfirst("Finished");
			}
		})
	};

	const factions = data?.map((faction) => {
		return (
			<>
				<p>Name: {faction.name}</p>
			</>
		);
	});

	const columns: IColumn[] = [
		{
			key: "column1",
			name: "Name",
			ariaLabel: "Name of the faction",
			fieldName: "Name",
			minWidth: 210,
			maxWidth: 350,

			onRender: (item: IFaction) => {
				return (
					<>
						<span onClick={() => _onRowClick(item.name)}>{item.name}</span>
					</>
				);
			},
		},
	];

	const items: IFaction[] = [];

	items.push({
		name: "Galactic Empire",
	});
	items.push({
		name: "Galactic Republic",
	});
	items.push({
		name: "Imperium of Man",
	});

	return (
		<>
			<div>Factions</div>
			<Link to="/faction/create">Create faction</Link>
			{factions}

			<DetailsList
				items={items}
				compact={false}
				columns={columns}
				selectionMode={SelectionMode.none}
				layoutMode={DetailsListLayoutMode.justified}
				isHeaderVisible={true}
			/>
		</>
	);
}
