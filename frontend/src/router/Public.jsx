import { PATH_MODULE } from '../utils/Constants';
import { Routes, Route } from "react-router-dom";
import { NotFound, Loader, MainLanding, HomeLanding } from '../features';

export default function Public() {
  return <>
    <Routes>
        <Route path={`${PATH_MODULE.PUBLIC.HOME}`} element={<MainLanding />} >
          <Route index element={<HomeLanding />} />
          <Route path={`${PATH_MODULE.PUBLIC.ABOUT}`} element={<Loader />} />
        </Route>
        <Route path='/*' element={<NotFound />} />
    </Routes>
  </>
}