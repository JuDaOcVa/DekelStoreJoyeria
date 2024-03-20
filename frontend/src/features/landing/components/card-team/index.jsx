import './style.css';

export default function index({img, name, position}) {
  return <div className='card-team'>
    <div className='cont-img-team'>
      <img src={img} alt='Not Found' />
    </div>
    <div className='cont-txt-team'>
      <h4 className='name-member'>{name}</h4>
      <p className='desp-mamber'>{position}</p>
    </div>
  </div>
}
