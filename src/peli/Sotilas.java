package peli;

import java.awt.Point;
import java.util.ArrayList;

public class Sotilas extends Nappula{
	
	private String nimi = "Sotilas";
	
	
	public Sotilas(Boolean väri) {
		super(väri, "src/peli/sotilasV.png", "src/peli/sotilasM.png");
	}
	
public ArrayList<Point> liike(int x, int y, boolean väri) {
		
	ArrayList<Point> taulValk = new ArrayList<Point>();
	ArrayList<Point> taulMusta = new ArrayList<Point>();
	
	
	
	if(y == 1 && !väri) {
		
		if(Pelilogiikka.pelilauta.get(new Point(x,y+1))==null) {
			taulMusta.add(new Point(x,y+1));
		}
		if(Pelilogiikka.pelilauta.get(new Point(x,y+2))==null&&Pelilogiikka.pelilauta.get(new Point(x,y+1))==null) {
			taulMusta.add(new Point(x,y+2));
		}
		if(x-1>-1&&Pelilogiikka.pelilauta.get(new Point(x-1,y+1))!=null) {
			if(Pelilogiikka.pelilauta.get(new Point(x-1,y+1)).väriValk!=väri) {
				taulMusta.add(new Point(x-1,y+1));
		}
		}
		
		if(x+1<8&&Pelilogiikka.pelilauta.get(new Point(x+1,y+1))!=null) {
			if(Pelilogiikka.pelilauta.get(new Point(x+1,y+1)).väriValk!=väri) {
				taulMusta.add(new Point(x+1,y+1));
			}
		}
		
		
		
		
		
	}
	else if(!väri) {
		if(Pelilogiikka.pelilauta.get(new Point(x,y+1))==null) {
			taulMusta.add(new Point(x,y+1));
		}
		if(x-1>-1&&Pelilogiikka.pelilauta.get(new Point(x-1,y+1))!=null) {
			if(Pelilogiikka.pelilauta.get(new Point(x-1,y+1)).väriValk!=väri) {
				taulMusta.add(new Point(x-1,y+1));
			}
			}
			
			if(x+1<8&&Pelilogiikka.pelilauta.get(new Point(x+1,y+1))!=null) {
				if(Pelilogiikka.pelilauta.get(new Point(x+1,y+1)).väriValk!=väri) {
					taulMusta.add(new Point(x+1,y+1));
				}
			}
	}
	
	
	if(y == 6 && väri) {
		
		if(Pelilogiikka.pelilauta.get(new Point(x,y-1))==null) {
			taulValk.add(new Point(x,y-1));
		}
		if(Pelilogiikka.pelilauta.get(new Point(x,y-2))==null&&Pelilogiikka.pelilauta.get(new Point(x,y-1))==null) {
			taulValk.add(new Point(x,y-2));
		}
		if(x-1>-1&&Pelilogiikka.pelilauta.get(new Point(x-1,y-1))!=null) {
		if(Pelilogiikka.pelilauta.get(new Point(x-1,y-1)).väriValk!=väri) {
			taulValk.add(new Point(x-1,y-1));
		}
		}
		
		if(x+1<8&&Pelilogiikka.pelilauta.get(new Point(x+1,y-1))!=null) {
			if(Pelilogiikka.pelilauta.get(new Point(x+1,y-1)).väriValk!=väri) {
				taulValk.add(new Point(x+1,y-1));
			}
		}
		
		
	}
	else if(väri) {
		if(Pelilogiikka.pelilauta.get(new Point(x,y-1))==null) {
			taulValk.add(new Point(x,y-1));
		}
		if(x-1>-1&&Pelilogiikka.pelilauta.get(new Point(x-1,y-1))!=null) {
			if(Pelilogiikka.pelilauta.get(new Point(x-1,y-1)).väriValk!=väri) {
				taulValk.add(new Point(x-1,y-1));
			}
			}
			
			if(x+1<8&&Pelilogiikka.pelilauta.get(new Point(x+1,y-1))!=null) {
				if(Pelilogiikka.pelilauta.get(new Point(x+1,y-1)).väriValk!=väri) {
					taulValk.add(new Point(x+1,y-1));
				}
			}
		}
	
	
	if(väri) {
	return taulValk;
	}else {
		return taulMusta;
	}
}
	public String annaNimi() {
		return nimi;
	}
}