package peli;

import java.awt.Point;
import java.util.ArrayList;

public class Torni extends Nappula {
	
	private String nimi = "Torni";
	
	public Torni(Boolean väri) {
		super(väri, "src/peli/torniV.png", "src/peli/torniM.png");
	}
	
public ArrayList<Point> liike(int x, int y, boolean väri) {
		
	ArrayList<Point> taul = new ArrayList<Point>();
	
	//tarkistetaan vaakatason rivi oikealle nappulasta
	for(int i = 1; i<8; i++) {
		
		
		
		if(x+i<8 &&Pelilogiikka.pelilauta.get(new Point(x+i,y))==null  ) {
			
		
			taul.add(new Point (x+i,y));
			continue;
		}
	
		 if(x+i<8 &&Pelilogiikka.pelilauta.get(new Point(x+i,y))!=null  && Pelilogiikka.pelilauta.get(new Point(x+i,y)).väriValk != väri )	{
			
			taul.add(new Point (x+i,y));
			break;
		}
		
	
		 if(x+i<8 && Pelilogiikka.pelilauta.get(new Point(x+i,y))!=null &&Pelilogiikka.pelilauta.get(new Point(x+i,y)).väriValk == väri ) {
			
			break;
		}
	
	}
	//tarkistetaan vaakatason rivi vasemmalle nappulasta
	for(int i = 1; i<8; i++) {
	

		if(x-i>=0 &&Pelilogiikka.pelilauta.get(new Point(x-i,y))==null) {
			
		
			taul.add(new Point (x-i,y));
		}
		if(x-i>=0 && Pelilogiikka.pelilauta.get(new Point(x-i,y))!=null && Pelilogiikka.pelilauta.get(new Point(x-i,y)).väriValk != väri)	{
			
			taul.add(new Point (x-i,y));
			break;
		}
	
		if(x-i>=0 && Pelilogiikka.pelilauta.get(new Point(x-i,y))!=null && Pelilogiikka.pelilauta.get(new Point(x-i,y)).väriValk == väri) {
			
			break;
		}
	}
	 // tarkistetaan pystyrivi alaspäin nappulasta
	 for(int i = 1; i<8; i++) {
		

		if( y+i<8 && Pelilogiikka.pelilauta.get(new Point(x,y+i))==null) {
			
		
			taul.add(new Point (x,y+i));
		}
		if(y+i<8 && Pelilogiikka.pelilauta.get(new Point(x,y+i))!=null && Pelilogiikka.pelilauta.get(new Point(x,y+i)).väriValk != väri)	{
			
			taul.add(new Point (x,y+i));
			break;
		}
	
		if(y+i<8 && Pelilogiikka.pelilauta.get(new Point(x,y+i))!=null &&  Pelilogiikka.pelilauta.get(new Point(x,y+i)).väriValk == väri) {
			
			break;
		}
	}	
		// tarkistetaan pystyrivi ylöspäin nappulasta
		for(int i = 1; i<8; i++) {
			

			if( y-i>=0 && Pelilogiikka.pelilauta.get(new Point(x,y-i))==null) {
				
			
				taul.add(new Point (x,y-i));
			}
			if(y-i>=0 && Pelilogiikka.pelilauta.get(new Point(x,y-i))!=null && Pelilogiikka.pelilauta.get(new Point(x,y-i)).väriValk != väri)	{
				
				taul.add(new Point (x,y-i));
				break;
			}
		
			if(y-i>=0 && Pelilogiikka.pelilauta.get(new Point(x,y-i))!=null &&  Pelilogiikka.pelilauta.get(new Point(x,y-i)).väriValk == väri) {
				
				break;
			}
		}		
			
	
	
	return taul;
	}


public String annaNimi() {
	return nimi;
}
}
