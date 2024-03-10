import { Logo } from "../../../../assets";
import { ITEM_MENU } from "../../../../utils/Constants";
import "./style.css";
import { ItemNav } from "..";

export default function index() {
  return (
    <nav className="cont-navbar">
      <img src={Logo} className="logo" alt="GKE" />
      <div className="cont-links">
        <ul>
          {ITEM_MENU.map(({ TITLE, PATH }) => <ItemNav key={TITLE} name={TITLE} url={PATH} />)}
        </ul>
      </div>
      <button className="btn-contact">Contacto</button>
    </nav>
  );
}
