import { ImgEmpresa } from '../../../../assets'
import './style.css'

export default function index() {
  return <>
    <section>
        <h2>Sobre nosotros</h2>
        <div className='cont-info-empresa'>
            <img src={ImgEmpresa} alt='Not Found' />
            <div className='cont-txt-empresa'>
                <h3>¿Quienes somos?</h3>
                <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Ad molestias earum cum nobis deleniti, doloribus eligendi modi, dolore, eaque consequatur qui quisquam tempora maiores? Ut aspernatur dignissimos ea ad sint.</p>
            </div>
        </div>
    </section>
  </>
}
