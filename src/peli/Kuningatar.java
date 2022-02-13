package peli;

import java.awt.Point;
import java.util.ArrayList;

public class Kuningatar extends Nappula {
	private String nimi = "Kuningatar";
	public Kuningatar(Boolean v�ri) {
		super(v�ri, "src/peli/kuningatarV.png", "src/peli/kuningatarM.png");
	}
	
public ArrayList<Point> liike(int x, int y,boolean v�ri) {
		
	ArrayList<Point> taul = new ArrayList<Point>();
	
	//tarkistetaan viistorivi alaoikealle nappulasta
	for(int i = 1; i<8; i++) {
		
		
		
		if(x+i<8 && y+i<8 &&Pelilogiikka.pelilauta.get(new Point(x+i,y+i))==null  ) {
			
		
			taul.add(new Point (x+i,y+i));
			continue;
		}
	
		 if(x+i<8 && y+i<8 &&Pelilogiikka.pelilauta.get(new Point(x+i,y+i))!=null  && Pelilogiikka.pelilauta.get(new Point(x+i,y+i)).v�riValk != v�ri )	{
			
			taul.add(new Point (x+i,y+i));
			break;
		}
		
	
		 if(x+i<8 && y+i<8 && Pelilogiikka.pelilauta.get(new Point(x+i,y+i))!=null &&Pelilogiikka.pelilauta.get(new Point(x+i,y+i)).v�riValk == v�ri ) {
			
			break;
		}
	
	}
	//tarkistetaan viistorivi alavasemmalle nappulasta
	for(int i = 1; i<8; i++) {
	

		if(x-i>=0 && y+i<8 &&Pelilogiikka.pelilauta.get(new Point(x-i,y+i))==null) {
			
		
			taul.add(new Point (x-i,y+i));
		}
		if(x-i>=0 && y+i<8 && Pelilogiikka.pelilauta.get(new Point(x-i,y+i))!=null && Pelilogiikka.pelilauta.get(new Point(x-i,y+i)).v�riValk != v�ri)	{
			
			taul.add(new Point (x-i,y+i));
			break;
		}
	
		if(x-i>=0 && y+i<8 && Pelilogiikka.pelilauta.get(new Point(x-i,y+i))!=null && Pelilogiikka.pelilauta.get(new Point(x-i,y+i)).v�riValk == v�ri) {
			
			break;
		}
	}
	 // tarkistetaan viisto rivi yl�oikealle nappulasta
	 for(int i = 1; i<8; i++) {
		

		if( x+i<8 && y-i>=0 && Pelilogiikka.pelilauta.get(new Point(x+i,y-i))==null) {
			
		
			taul.add(new Point (x+i,y-i));
		}
		if(x+i<8 && y-i>=0 && Pelilogiikka.pelilauta.get(new Point(x+i,y-i))!=null && Pelilogiikka.pelilauta.get(new Point(x+i,y-i)).v�riValk != v�ri)	{
			
			taul.add(new Point (x+i,y-i));
			break;
		}
	
		if(x+i<8 && y-i>=0 && Pelilogiikka.pelilauta.get(new Point(x+i,y-i))!=null &&  Pelilogiikka.pelilauta.get(new Point(x+i,y-i)).v�riValk == v�ri) {
			
			break;
		}
	}	
		// tarkistetaan viistorivi yl�vasemmalle nappulasta
		for(int i = 1; i<8; i++) {
			

			if(x-i>=0 && y-i>=0 &&  Pelilogiikka.pelilauta.get(new Point(x-i,y-i))==null) {
				
			
				taul.add(new Point (x-i,y-i));
			}
			if(x-i>=0 && y-i>=0 && Pelilogiikka.pelilauta.get(new Point(x-i,y-i))!=null && Pelilogiikka.pelilauta.get(new Point(x-i,y-i)).v�riValk != v�ri)	{
				
				taul.add(new Point (x-i,y-i));
				break;
			}
		
			if(x-i>=0 && y-i>=0 && Pelilogiikka.pelilauta.get(new Point(x-i,y-i))!=null &&  Pelilogiikka.pelilauta.get(new Point(x-i,y-i)).v�riValk == v�ri) {
				
				break;
			}
		}		
			
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
