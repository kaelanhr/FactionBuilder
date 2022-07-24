import { useEffect, useState } from "react";
import "./App.css";
import axios from "axios";
import { Outlet } from "react-router";
import { Link } from "react-router-dom";
interface City {
	id: String;
	description: String;
	status: String;
}

function App() {
	const [first, setfirst] = useState<any>("loading");
	const [data, setData] = useState<City[] | null>(null);

	useEffect(() => {
		fetchData();
	}, []);

	const fetchData = async () => {
		await axios.get<City[]>(`/api/city`).then((response) => {
			if (response.data != null) {
				setData(response.data);
				setfirst("Finished");
			}
		});
	};

	const cities = data?.map((city) => {
		return (
			<>
				<p>ID: {city.id}</p>
				<p>Description: {city.description}</p>
				<p>Status: {city.status}</p>
			</>
		);
	});

	return (
		<>
			<div className="App">
				<header className="App-header">
					<Link to="">Home</Link>
				</header>
				{cities?.length || <p>No cities found</p>}
					<Outlet />
			</div>
		</>
	);
}

export default App;
