import { Link } from "react-router-dom";

export default function Home() {
  return (
		<>
			<Link to="faction">Factions</Link>
			<Link to="locations">Locations</Link>
			<Link to="characters">Characters</Link>
		</>
	);
}
