import { lazy } from 'react';
import './Styles/App.css';
import { BrowserRouter } from "react-router-dom";

const Router = lazy(() => import('./router/'));

function App() {
  return <main>
    <BrowserRouter>
      <Router />
    </BrowserRouter>
  </main>
}

export default App
