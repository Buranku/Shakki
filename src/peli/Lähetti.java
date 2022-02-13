package peli;

import java.awt.Point;
import java.util.ArrayList;

public class Lähetti extends Nappula {
	
	private String nimi = "Lähetti";
	
	public Lähetti(Boolean väri) {
		super(väri, "src/peli/lähettiV.png", "src/peli/lähettiM.png");
	}
	
public ArrayList<Point> liike(int x, int y, boolean väri) {
		
	ArrayList<Point> taul = new ArrayList<Point>();
	
	//tarkistetaan viistorivi alaoikealle nappulasta
	for(int i = 1; i<8; i++) {
		
		
		
		if(x+i<8 && y+i<8 &&Pelilogiikka.pelilauta.get(new Point(x+i,y+i))==null  ) {
			
		
			taul.add(new Point (x+i,y+i));
			continue;
		}
	
		 if(x+i<8 && y+i<8 &&Pelilogiikka.pelilauta.get(new Point(x+i,y+i))!=null  && Pelilogiikka.pelilauta.get(new Point(x+i,y+i)).väriValk != väri )	{
			
			taul.add(new Point (x+i,y+i));
			break;
		}
		
	
		 if(x+i<8 && y+i<8 && Pelilogiikka.pelilauta.get(new Point(x+i,y+i))!=null &&Pelilogiikka.pelilauta.get(new Point(x+i,y+i)).väriValk == väri ) {
			
			break;
		}
	
	}
	//tarkistetaan viistorivi alavasemmalle nappulasta
	for(int i = 1; i<8; i++) {
	

		if(x-i>=0 && y+i<8 &&Pelilogiikka.pelilauta.get(new Point(x-i,y+i))==null) {
			
		
			taul.add(new Point (x-i,y+i));
		}
		if(x-i>=0 && y+i<8 && Pelilogiikka.pelilauta.get(new Point(x-i,y+i))!=null && Pelilogiikka.pelilauta.get(new Point(x-i,y+i)).väriValk != väri)	{
			
			taul.add(new Point (x-i,y+i));
			break;
		}
	
		if(x-i>=0 && y+i<8 && Pelilogiikka.pelilauta.get(new Point(x-i,y+i))!=null && Pelilogiikka.pelilauta.get(new Point(x-i,y+i)).väriValk == väri) {
			
			break;
		}
	}
	 // tarkistetaan viisto rivi yläoikealle nappulasta
	 for(int i = 1; i<8; i++) {
		

		if( x+i<8 && y-i>=0 && Pelilogiikka.pelilauta.get(new Point(x+i,y-i))==null) {
			
		
			taul.add(new Point (x+i,y-i));
		}
		if(x+i<8 && y-i>=0 && Pelilogiikka.pelilauta.get(new Point(x+i,y-i))!=null && Pelilogiikka.pelilauta.get(new Point(x+i,y-i)).väriValk != väri)	{
			
			taul.add(new Point (x+i,y-i));
			break;
		}
	
		if(x+i<8 && y-i>=0 && Pelilogiikka.pelilauta.get(new Point(x+i,y-i))!=null &&  Pelilogiikka.pelilauta.get(new Point(x+i,y-i)).väriValk == väri) {
			
			break;
		}
	}	
		// tarkistetaan viistorivi ylävasemmalle nappulasta
		for(int i = 1; i<8; i++) {
			

			if(x-i>=0 && y-i>=0 &&  Pelilogiikka.pelilauta.get(new Point(x-i,y-i))==null) {
				
			
				taul.add(new Point (x-i,y-i));
			}
			if(x-i>=0 && y-i>=0 && Pelilogiikka.pelilauta.get(new Point(x-i,y-i))!=null && Pelilogiikka.pelilauta.get(new Point(x-i,y-i)).väriValk != väri)	{
				
				taul.add(new Point (x-i,y-i));
				break;
			}
		
			if(x-i>=0 && y-i>=0 && Pelilogiikka.pelilauta.get(new Point(x-i,y-i))!=null &&  Pelilogiikka.pelilauta.get(new Point(x-i,y-i)).väriValk == väri) {
				
				break;
			}
		}		
			
	
	
	return taul;
	}
	
	


public String annaNimi() {
	return nimi;
}
}
