package peli;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

public class Nappula implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Boolean v�riValk;
	final String kuvaV;
	final String kuvaM;
	
	public Nappula(Boolean v�ri, String V, String M) {
		this.v�riValk = v�ri;
		this.kuvaV = V;
		this.kuvaM = M;
	}
	
	//Palauttaa nappulan sallitut liikkeet ArrayListana
	public ArrayList<Point> liike(int x, int y, boolean v�ri) {
	
		return new ArrayList<Point>();
	}
	
	public String annaNimi() {
		return null;
	}
}		
