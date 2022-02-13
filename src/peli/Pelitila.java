package peli;

import java.awt.Point;
import java.io.Serializable;
import java.util.HashMap;

public class Pelitila implements Serializable {


	private static final long serialVersionUID = 1L;

	private boolean vuoro;
	
	HashMap<Point,Nappula> pelilauta;
	
	/**	Konstruktori
	 * 
	 * @param HashMap<Point,Nappula> pelilauta
	 * @param Boolean vuoro
	 */
	public Pelitila(HashMap<Point,Nappula> pelilauta, Boolean vuoro) {
		
		this.pelilauta = pelilauta;
		this.vuoro = vuoro;
	}
	
	/**	Asetusmetodi pelitilan asetusta varten
	 * 
	 * @param HashMap<Point,Nappula> pelilauta
	 * @param Boolean vuoro
	 */
	public void asetaPelitila(HashMap<Point,Nappula> pelilauta, Boolean vuoro) {
		
		this.pelilauta = pelilauta;
		this.vuoro = vuoro;
		
		}
	
	/** palauttaa pelilaudan tilan HashMap<Point,Nappula> oliona
	 * 
	 * @return HashMap<Point,Nappula>
	 */
	public HashMap<Point,Nappula> annaPelilauta(){
		return pelilauta;
	}
	
	/**	Palauttaa vuoron Boolean muodossa, Musta = false, Valkoinen = true
	 * 
	 * @return Boolean vuoro
	 */
	public boolean annaVuoro() {
		return vuoro;
	}
}
