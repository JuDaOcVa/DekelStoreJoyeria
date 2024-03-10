import { Outlet } from 'react-router-dom';
import './style.css';

export default function index() {
  return (
    <div className='cont-main'>
      <Outlet />
    </div>
  )
}
