import React, { Suspense, lazy } from 'react'
import ReactDOM from 'react-dom/client'
import './Styles/index.css'
import { Loader } from './features'

const App = lazy(() => import('./App.jsx'))

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <Suspense fallback={<Loader />}>
      <App />
    </Suspense>
  </React.StrictMode>,
)
