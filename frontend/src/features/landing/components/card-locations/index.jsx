import './style.css';

export default function index({adreess, city}) {
  return <div className='card-location'>
    <ion-icon name="location-outline" id="icon"></ion-icon>
    <p>{city}</p>
    <h4>{adreess}</h4>
  </div>
}
