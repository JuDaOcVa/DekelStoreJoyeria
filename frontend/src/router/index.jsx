import { lazy } from 'react'
import { Routes, Route } from "react-router-dom";

const Public = lazy(() => import('./Public'));

export default function Index() {
    return (
        <Routes>
            <Route path="/*" element={<Public />} />
        </Routes>
    )
}