package peli;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class Pelilauta extends JPanel{

	Nappula nap;
	
	//Piirt‰‰ pelilaudan
	public void paint(Graphics g) {
	
		g.setColor(Color.darkGray);
		g.setFont(new Font("Ariel", Font.BOLD,28));
		g.drawString("1:New Game,  2:Save Game,  3:Load Game", 10, 40);
		g.setFont(new Font("Abadi", Font.BOLD,18));
		
		//Kertoo vuoron
		if(Pelilogiikka.vuoroValk) {
			g.setColor(Color.WHITE);
			g.fillRect(650, 20, 200, 35);
			g.setColor(Color.BLACK);
			g.drawString("Valkoisen vuoro", 650, 40);
		}
		else {
			g.setColor(Color.WHITE);
			g.fillRect(650, 20, 200, 35);
			g.setColor(Color.BLACK);
			g.drawString("Mustan vuoro", 650, 40);
		}
		
		
		//Kertoo valitun nappulan
		if(Pelilogiikka.valinta != null) {
			g.setColor(Color.WHITE);
			g.fillRect(270, 55, 280, 35);
			g.setColor(Color.BLACK);	
			
			g.drawString("Valinta: "+Pelilogiikka.valinta.annaNimi()+" X:"+(int)Pelilogiikka.valinnanSijainti.getX()+" Y:"+(int)Pelilogiikka.valinnanSijainti.getY(), 280, 78);
		}else {
			g.setColor(Color.WHITE);
			g.fillRect(270, 55, 280, 35);
			g.setColor(Color.BLACK);	
			
			
			g.drawString("Ei valintaa" , 280, 78);	
		}
		
		
		
		//Menn‰‰n l‰pi jokainen pelilaudan kohta (64)
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if((i+j)%2==1) {
					g.setColor(new Color(156, 93, 82));
					
				}
				else {
					g.setColor(new Color(245,245,220));
					
				}
				
			
				g.fillRect(i*100, 100+j*100, 100, 100);
				
				if(Pelilogiikka.valinta != null && Pelilogiikka.valinnanSijainti.equals(new Point (i,j))) {
					g.setColor(new Color(100,255,100));
					g.fillRect(i*100, 100+j*100, 100, 100);
				}
				
				
				if(Pelilogiikka.sallitutLiikkeet!=null) {
					if(Pelilogiikka.sallitutLiikkeet.contains(new Point(i,j))) {
						g.setColor(new Color(64,224,208));
						g.fillRect(i*100, 100+j*100, 100, 100);
					//maalataan liike ruutu keltaiseksi jos siin‰ vastapuolen kuningas
						if(Pelilogiikka.pelilauta.get(new Point(i,j)) != null && Pelilogiikka.pelilauta.get(new Point(i,j)) instanceof Kuningas && Pelilogiikka.pelilauta.get(new Point(i,j)).v‰riValk != Pelilogiikka.vuoroValk ) {
							g.setColor(new Color(240,218,10));
							g.fillRect(i*100, 100+j*100, 100, 100);
					//maalataan liike ruutu punaiseksi jos siin‰ vastapuolen nappula paitsi kuningas	
						}else if(Pelilogiikka.pelilauta.get(new Point(i,j)) != null && Pelilogiikka.pelilauta.get(new Point(i,j)).v‰riValk != Pelilogiikka.vuoroValk) {
							g.setColor(new Color(224,30,30));
							g.fillRect(i*100, 100+j*100, 100, 100);
						
						}
						
					 }	
					}
				
				//Piirret‰‰n nappula
				ImageIcon a= null;
				if(Pelilogiikka.pelilauta.get(new Point(i,j))!=null) {
					Nappula nap = Pelilogiikka.pelilauta.get(new Point(i,j));
				if(nap.v‰riValk) {
					a = new ImageIcon(nap.kuvaV);
				}
				else {
					a = new ImageIcon(nap.kuvaM);
				}
				Image b = a.getImage();
				g.drawImage(b, i*100+20, 120+j*100, null);
				}
			}
		}
		
	}
}
