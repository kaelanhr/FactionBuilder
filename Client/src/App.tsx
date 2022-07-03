import React, { useEffect, useState } from "react";
import logo from "./logo.svg";
import "./App.css";
import axios from "axios";

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

	const cities = data?.map(city => {
		return (
			<>
				<p>ID: {city.id}</p>
				<p>Description: {city.description}</p>
				<p>Status: {city.status}</p>
			</>
		);

	})

	return (
		<div className="App">
			<header className="App-header">
				<img src={logo} className="App-logo" alt="logo" />
				{first}

				<a
					className="App-link"
					href="https://reactjs.org"
					target="_blank"
					rel="noopener noreferrer"
				>
					Learn React
				</a>
			</header>
			{cities}
		</div>
	);
}

export default App;
