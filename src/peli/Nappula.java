package peli;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

public class Nappula implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Boolean väriValk;
	final String kuvaV;
	final String kuvaM;
	
	public Nappula(Boolean väri, String V, String M) {
		this.väriValk = väri;
		this.kuvaV = V;
		this.kuvaM = M;
	}
	
	//Palauttaa nappulan sallitut liikkeet ArrayListana
	public ArrayList<Point> liike(int x, int y, boolean väri) {
	
		return new ArrayList<Point>();
	}
	
	public String annaNimi() {
		return null;
	}
}		
