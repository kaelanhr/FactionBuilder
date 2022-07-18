import {Route, Routes} from 'react-router'
import Faction from '../Faction';
import Home from '../Home';

export default function RoutePages() {
  return (
		<Routes>
			<Route path="/" element={<Home />} />
				<Route path="/faction" element={<Faction />} />
				<Route element={<NotFound />} />
		</Routes>
	);
}

function NotFound() {
	return (
		<div id="not-found">
			<h1>The Page you were looking for was not found</h1>
		</div>
	);
}