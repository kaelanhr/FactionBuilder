import ReactDOM from "react-dom/client";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import App from "./App";
import CreateFaction from "./Pages/CreateFaction";
import Faction from "./Pages/Faction";
import Home from "./Pages/Home";
import Layout from "./Pages/Layout";
import reportWebVitals from "./reportWebVitals";

const root = ReactDOM.createRoot(
	document.getElementById("root") as HTMLElement
);

root.render(
	<BrowserRouter>
		<Routes>
			<Route path="/" element={<App />}>
				<Route index element={<Home />} />
				{/* <Route element={<NotFound />} /> */}
				<Route path="faction" element={<Layout />}>
					<Route index element={<Faction />} />
					<Route path="create" element={<CreateFaction />} />
				</Route>
			</Route>
		</Routes>
	</BrowserRouter>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();

function NotFound() {
	return (
		<div id="not-found">
			<h1>The Page you were looking for was not found</h1>
		</div>
	);
}
