package peli;

import java.awt.Point;
import java.util.ArrayList;

public class Torni extends Nappula {
	
	private String nimi = "Torni";
	
	public Torni(Boolean v�ri) {
		super(v�ri, "src/peli/torniV.png", "src/peli/torniM.png");
	}
	
public ArrayList<Point> liike(int x, int y, boolean v�ri) {
		
	ArrayList<Point> taul = new ArrayList<Point>();
	
	//tarkistetaan vaakatason rivi oikealle nappulasta
	for(int i = 1; i<8; i++) {
		
		
		
		if(x+i<8 &&Pelilogiikka.pelilauta.get(new Point(x+i,y))==null  ) {
			
		
			taul.add(new Point (x+i,y));
			continue;
		}
	
		 if(x+i<8 &&Pelilogiikka.pelilauta.get(new Point(x+i,y))!=null  && Pelilogiikka.pelilauta.get(new Point(x+i,y)).v�riValk != v�ri )	{
			
			taul.add(new Point (x+i,y));
			break;
		}
		
	
		 if(x+i<8 && Pelilogiikka.pelilauta.get(new Point(x+i,y))!=null &&Pelilogiikka.pelilauta.get(new Point(x+i,y)).v�riValk == v�ri ) {
			
			break;
		}
	
	}
	//tarkistetaan vaakatason rivi vasemmalle nappulasta
	for(int i = 1; i<8; i++) {
	

		if(x-i>=0 &&Pelilogiikka.pelilauta.get(new Point(x-i,y))==null) {
			
		
			taul.add(new Point (x-i,y));
		}
		if(x-i>=0 && Pelilogiikka.pelilauta.get(new Point(x-i,y))!=null && Pelilogiikka.pelilauta.get(new Point(x-i,y)).v�riValk != v�ri)	{
			
			taul.add(new Point (x-i,y));
			break;
		}
	
		if(x-i>=0 && Pelilogiikka.pelilauta.get(new Point(x-i,y))!=null && Pelilogiikka.pelilauta.get(new Point(x-i,y)).v�riValk == v�ri) {
			
			break;
		}
	}
	 // tarkistetaan pystyrivi alasp�in nappulasta
	 for(int i = 1; i<8; i++) {
		

		if( y+i<8 && Pelilogiikka.pelilauta.get(new Point(x,y+i))==null) {
			
		
			taul.add(new Point (x,y+i));
		}
		if(y+i<8 && Pelilogiikka.pelilauta.get(new Point(x,y+i))!=null && Pelilogiikka.pelilauta.get(new Point(x,y+i)).v�riValk != v�ri)	{
			
			taul.add(new Point (x,y+i));
			break;
		}
	
		if(y+i<8 && Pelilogiikka.pelilauta.get(new Point(x,y+i))!=null &&  Pelilogiikka.pelilauta.get(new Point(x,y+i)).v�riValk == v�ri) {
			
			break;
		}
	}	
		// tarkistetaan pystyrivi yl�sp�in nappulasta
		for(int i = 1; i<8; i++) {
			

			if( y-i>=0 && Pelilogiikka.pelilauta.get(new Point(x,y-i))==null) {
				
			
				taul.add(new Point (x,y-i));
			}
			if(y-i>=0 && Pelilogiikka.pelilauta.get(new Point(x,y-i))!=null && Pelilogiikka.pelilauta.get(new Point(x,y-i)).v�riValk != v�ri)	{
				
				taul.add(new Point (x,y-i));
				break;
			}
		
			if(y-i>=0 && Pelilogiikka.pelilauta.get(new Point(x,y-i))!=null &&  Pelilogiikka.pelilauta.get(new Point(x,y-i)).v�riValk == v�ri) {
				
				break;
			}
		}		
			
	
	
	return taul;
	}


public String annaNimi() {
	return nimi;
}
}
