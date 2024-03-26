/* eslint-disable react-hooks/rules-of-hooks */
import { ImgEmpresa, ImgHistoriaEmpresa } from '../../../../assets'
import { useString } from '../../../../hooks'
import { CardLocation, CardTeam } from '../../components';
import Atropos from 'atropos/react';
import './style.css'

export default function index() {

  const { texts } = useString("about");
  const { title, about, history, team, location } = texts;
  const { subtitle, aboutUs } = about || {};
  const { historyTitle, historyDescription } = history || {};
  const { teamSubtitle, members } = team || {};
  const { locationSubTitle, locations } = location || {};

  return <div className='about-body'>
    <section className='cont-about-empresa'>
      <h1 className='titleSite'>{title}</h1>
      <Atropos className='my-atropos'
        shadow={false}
      >
        <div className='cont-info-empresa' >
          <img src={ImgEmpresa} alt='Not Found'  />
          <div className='cont-txt-empresa'>
            <h3>{subtitle}</h3>
            <p>{aboutUs}</p>
          </div>
        </div>
      </Atropos>
    </section>
    <section className='cont-historia-empresa'>
      <div className='cont-txt-historia'>
        <h3>{historyTitle}</h3>
        <p>{historyDescription}</p>
      </div>
      <Atropos className='my-atropos-img'
        activeOffset={10}
        shadowScale={1.05}
      >
        <img src={ImgHistoriaEmpresa} className='img-historia' alt='Not Found' />
      </Atropos>
    </section>
    <section className='cont-teams-empresa'>
      <h3 className='subtitle-team'>{teamSubtitle}</h3>
      <div className='cont-members'>
        {members && members.map((member, index) => {
          return <CardTeam key={index} img={member.image} name={member.name} position={member.position} />
        })}
      </div>
    </section>
    <section className='cont-location-empresa'>
      <h3 className='subtitle-location'>{locationSubTitle}</h3>
      <div className='cont-locations'>
        {locations && locations.map((location, index) => {
          return <CardLocation key={index} adreess={location.ubication} city={location.city} />
        })}
      </div>
    </section>
    <section className='cont-testimonial-empresa'>
      <h3 className='subtitle-testimonial'>{locationSubTitle}</h3>
      <div className='cont-testimonials'>
        {locations && locations.map((location, index) => {
          return <CardLocation key={index} adreess={location.ubication} city={location.city} />
        })}
      </div>
    </section>
  </div>
}
