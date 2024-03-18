import { PATH_MODULE } from '../utils/Constants';
import { Routes, Route, Navigate } from "react-router-dom";
import { Loader, MainLanding, HomeLanding } from '../features';

export default function Public() {
  return <>
    <Routes>
        <Route exact path={`${PATH_MODULE.PUBLIC.HOME}`} element={<MainLanding />} >
          <Route index element={<HomeLanding />} />
          <Route path={`${PATH_MODULE.PUBLIC.ABOUT}`} element={<Loader />} />
          <Route path={`${PATH_MODULE.PUBLIC.CATALOG}`} element={<Loader />} />
          <Route path={`${PATH_MODULE.PUBLIC.SERVICES}`} element={<Loader />} />
        </Route>
        <Route path='*' element={<Navigate to={'/notfound'} />} />
    </Routes>
  </>
}