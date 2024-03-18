import { lazy } from 'react'
import { Routes, Route } from "react-router-dom";
import { NavBar } from "../features/landing/components";
import { NotFound } from '../features';

const Public = lazy(() => import('./Public'));

export default function Index() {
    return (
        <Routes>
            <Route path="/*" element={<><NavBar /> <Public /></>} />
            <Route path="/notfound" element={<NotFound />} />
        </Routes>
    )
}