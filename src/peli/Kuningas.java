package peli;

import java.awt.Point;
import java.util.ArrayList;
	


	
public class Kuningas extends Nappula {
	private String nimi = "Kuningas";
	public Kuningas(Boolean väri) {
		super(väri, "src/peli/kuningasV.png","src/peli/kuningasM.png");
	}
	
public ArrayList<Point> liike(int x, int y, boolean väri) {
		ArrayList<Point> taul = new ArrayList<Point>();
		
		for(int i=-1;i<2;i++){
			for(int j=-1;j<2;j++){
				if(!(i==0&&j==0)) {
				if(x+i<8&&x+i>-1&&y+j<8&&y+j>-1){
					if(Pelilogiikka.pelilauta.get(new Point(x+i,y+j))==null){
						taul.add(new Point(x+i,y+j));
					}
					else{
						if(Pelilogiikka.pelilauta.get(new Point(x+i,y+j)).väriValk!=väri){
							taul.add(new Point(x+i,y+j));
						}
					}
				}
				}
			}

		}
		
		return taul;
	}


public String annaNimi() {
	return nimi;
}
}
