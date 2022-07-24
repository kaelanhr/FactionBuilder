import {Route, Routes} from 'react-router'
import App from '../../App';
import CreateFaction from '../Faction/FactionCreate';
import FactionList from '../Faction/FactionList';
import Home from '../Home';
import Layout from '../Layout';

export default function RoutePages() {
  return (
		<Routes>
			<Route path="/" element={<App />}>
				<Route index element={<Home />} />
				<Route  path="*" element={<NotFound />} />
				<Route path="faction" element={<Layout />}>
					<Route index element={<FactionList />} />
					<Route path="create" element={<CreateFaction />} />
					<Route path="view/:id" element={<CreateFaction />} />
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