/* eslint-disable react-hooks/rules-of-hooks */
import { Link, useLocation } from "react-router-dom";
import "./style.css";

export default function index({ name, url }) {
  const location = useLocation();
  const { pathname } = location;
  return (
    <li>
      <Link to={url} className={"link" + (pathname === url ? " active" : "")}>
        {name}
      </Link>
    </li>
  );
}
