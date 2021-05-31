package com.salesianostriana.dam;

import java.time.LocalDate;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.salesianostriana.dam.model.Evento;
import com.salesianostriana.dam.servicios.EventoService;
import lombok.RequiredArgsConstructor;
/**
 * Esta clase se encarga de introducir los datos iniciales a la base de datos.En este
 * caso son eventos.
 * @author Daniel de Luna Rodríguez
 *
 */
@Component
@RequiredArgsConstructor
public class InitData {
	
	@Autowired
	private final EventoService eventoServicio;
	
	@PostConstruct
	public void init(){

		List<Evento> eventosIniciales=List.of(new Evento("Tomorrowland", "Tomorrowland es un festival de música electrónica de baile celebrado anualmente en la localidad de Boom (Bélgica). "
													+ "El festival es organizado por las empresas propias del festival "
													+ "(We Are One World y Tomorrowland Foundation) en conjunción con la promotora.",LocalDate.of(2021, 6, 27),105.5,"https://www.mondosonoro.com/wp-content/uploads/2020/07/Tomorrowland.jpg","Foto de Tomorrowland"),
											
											new Evento("Leeds Festival", "El Festival de Reading y Leeds es un festival musical anual que se realiza en las ciudades de Reading y de Leeds, en Inglaterra. Los eventos tienen lugar "
													+ "simultáneamente el viernes, sábado y domingo en el bank holiday de agosto.",
													LocalDate.of(2021, 8, 20),90.5,"https://como-funciona.com/wp-content/uploads/2019/03/leeds-festival-main-stage-music-nextfest-1500x840.jpg","Foto de Leeds Festival."),
											
											new Evento("Defqon. 1", "Es un festival de varios días, el cual se realiza en Biddinghuizen. En el 2004, "
													+ "la primera edición se llevó a cabo en la playa de Almere. Con el paso de los años, Defqon. 1 se ha transformado "
													+ "en uno de los festivales de Hardstyle más populares en Holanda.",
													LocalDate.of(2021, 7, 26),132,"https://nightlifemexico.com/wp-content/uploads/2021/02/Defqon1-pospuesto-hasta-2022.jpg","Foto de Defqon1"),
											
											new Evento("Rock in Rio Lisboa 2021", "Rock in Rio es un evento originario de Brasil que incluye una serie de conciertos "
													+ "de rock y pop.Es conocido mundialmente como \"El festival más grande del mundo\".",
													LocalDate.of(2021, 5, 3),112,"https://static1.abc.es/media/cultura/2021/03/05/rioo-U26555534755eGR-1024x512@abc.jpg","Foto de Rock in Rio Lisboa"),
											
											new Evento("Festival BBK", "The Killers, Kendrick Lamar o Placebo, son algunos de los 93 artistas que cierran el cartel para el Bilbao BBK Live 2021. "
													+ "Uno de los festivales de España más populares y multitudinarios del panorama europeo.",
													LocalDate.of(2021, 9, 15),140.5,"https://fotografias.antena3.com/clipping/cmsimages02/2018/06/15/B0449046-1695-4721-8FCC-5F2B6DF296A2/58.jpg","Foto de Bilbao BBK"),
											
											new Evento("Festival Creamfields", "El festival de Creamfields espera a todos sus seguidores a finales de agosto en Daresbury (Reino Unido). Contará con cientos "
													+ "de artistas de renombre como Tiësto, Armin Van Buuren o Hardwell, entre muchos otros.",
													LocalDate.of(2021, 8, 20),210.5,"https://cdn.shortpixel.ai/client/q_lossy,ret_img,w_1000/https://reservafreetour.com/wp-content/uploads/2020/10/Festival-Creamfields.jpg","Foto de festival Creamfields"),
											
											new Evento("Festival Sónar", "Si te apasiona la música electrónica experimental, Sónar es tu cita obligada.Se llevará a cabo en Barcelona. "
													+ "Tendrá lugar los días 18, 19 y 20 de junio, un fin de semana inolvidable para todo aquel que se acerque a disfrutar de él.",
													LocalDate.of(2021, 6, 18),140.5,"https://cdn.shortpixel.ai/client/q_lossy,ret_img,w_1000/https://reservafreetour.com/wp-content/uploads/2020/10/Sonar-Barcelona.jpg","Foto fesitival sónar"),

											new Evento("Garden of Madness", "La franquicia más exitosa del mundo de la música electrónica, Tomorrowland, ha organizado este festival otoño-invernal en la ciudad de Amberes. En el cartel encontrarás "
													+ "artistas de la talla de Dimitri Vegas,Armin Van Buuren y Niky Romero.",
													LocalDate.of(2021, 12, 14),154,"https://i.ytimg.com/vi/qM0hMs1oMfI/maxresdefault.jpg","Foto de Garden of Madness"),
											
											new Evento("Primavera Sound", "El \"rey del indie\" y fiel apoyo para la música más novedosa, Primavera Sound, "
													+ "se enorgullece de servir como plataforma para la música alternativa. ",
													LocalDate.of(2021, 6, 2),75.5,"https://d49r1np2lhhxv.cloudfront.net/www/admin/uploads/images/TOP20Primavera.jpg","Foto de Primavera Sound"),
											
											new Evento("Tomorrowland Winter", "Tomorrowland Winter es la edición más fría del festival de verano. Nació tan solo en 2019 y vuelve por segundo año "
													+ "para invadir el pintoresco municipio de Alpe d'Huez durante toda una semana.  ",
													LocalDate.of(2021, 3, 14),95.5,"https://media.resources.festicket.com/www/admin/uploads/images/tomorrowlandwinter1.jpg","Foto de Tomorrowland Winter"));
		
		
		
		
		for(Evento e: eventosIniciales)
			eventoServicio.save(e);

		
		
	}
	
}
