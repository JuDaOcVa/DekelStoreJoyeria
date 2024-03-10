import { lazy } from "react";
import "./Styles/App.css";
import { BrowserRouter } from "react-router-dom";
import { NavBar } from "./features/landing/components";

const Router = lazy(() => import("./router/"));

function App() {
  return (
    <main>
      <BrowserRouter>
        <NavBar />
        <Router />
      </BrowserRouter>
    </main>
  );
}

export default App;
