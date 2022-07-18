import {Route, Routes} from 'react-router'
import App from '../../App';
import CreateFaction from '../CreateFaction';
import Faction from '../Faction';
import Home from '../Home';
import Layout from '../Layout';

export default function RoutePages() {
  return (
		<Routes>
			<Route path="/" element={<App />}>
				<Route index element={<Home />} />
				<Route  path="*" element={<NotFound />} />
				<Route path="faction" element={<Layout />}>
					<Route index element={<Faction />} />
					<Route path="create" element={<CreateFaction />} />
				</Route>
			</Route>
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