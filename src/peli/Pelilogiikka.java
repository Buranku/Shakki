package peli;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Pelilogiikka extends JPanel implements KeyListener, ActionListener{


	private static final long serialVersionUID = -1069267511822233639L;
	public static boolean vuoroValk =true;
	public static HashMap<Point, Nappula> pelilauta;
	JFrame frame;
	Pelilauta gui;
	public static ArrayList<Point> sallitutLiikkeet;
	public static Nappula valinta = null;
	public static Point   kohde = null;
	public static Point   valinnanSijainti = null;
	public Pelilogiikka() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		JFrame frame = new JFrame("Shakki");
		gui = new Pelilauta();
		frame.getContentPane().add(gui);
		frame.setSize(816, 939);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocation(dim.width/2-816/2,dim.height/2-939/2);
		
		pelilauta = new HashMap<Point, Nappula>();
		gui.repaint();
		
		
		
		//Ohjelma kuuntelee näppäimistöä, käytetään numeroita 1, 2 ja 3 toimintoihin.
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
				int key = e.getKeyCode();
				
				// Painamalla 1, pelinappulat laitetaan oletuspaikoille (NEW GAME)
				if(key == KeyEvent.VK_1) {
					
					vuoroValk =true;
					sallitutLiikkeet = null;
				    valinta = null;
				    kohde = null;
				    valinnanSijainti = null;
					
					for(int i=0;i<8;i++) {
						for(int j=0;j<8;j++) {
							pelilauta.replace(new Point(i,j),null);
						}
					}
					
					for(int i=0;i<16;i++) {
						if(i<8) {
							pelilauta.put(new Point(i,1), new Sotilas(false));
						}
						else {
							pelilauta.put(new Point(i-8,6), new Sotilas(true));
						}
					}
					pelilauta.put(new Point(0,0), new Torni(false));
					pelilauta.put(new Point(1,0), new Ratsu(false));
					pelilauta.put(new Point(2,0), new Lähetti(false));
					pelilauta.put(new Point(3,0), new Kuningatar(false));
					pelilauta.put(new Point(4,0), new Kuningas(false));
					pelilauta.put(new Point(5,0), new Lähetti(false));
					pelilauta.put(new Point(6,0), new Ratsu(false));
					pelilauta.put(new Point(7,0), new Torni(false));
					pelilauta.put(new Point(0,7), new Torni(true));
					pelilauta.put(new Point(1,7), new Ratsu(true));
					pelilauta.put(new Point(2,7), new Lähetti(true));
					pelilauta.put(new Point(3,7), new Kuningatar(true));
					pelilauta.put(new Point(4,7), new Kuningas(true));
					pelilauta.put(new Point(5,7), new Lähetti(true));
					pelilauta.put(new Point(6,7), new Ratsu(true));
					pelilauta.put(new Point(7,7), new Torni(true));
					
					
					
					gui.repaint();
				}
				
				//Tähän pelin tallentaminen
				if(e.getKeyCode() == KeyEvent.VK_2) {
					tallennaPeli();
				}
				
				//Tähän pelin lataaminen entisestä tallennuksesta
				else if(key == KeyEvent.VK_3&& (new File("src/tallennus.txt")).exists()){ 
					
					lataaPeli();
					gui.repaint();
				}
				
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		//Kuuntelee hiiren painalluksia, käytetään nappuloiden painamiseen.
		frame.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton()==MouseEvent.BUTTON1) {
				
				logiikka(e);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
	
	//Logiikka, siitä minne nappuloita saa liikuttaa
	public void logiikka(MouseEvent e) {
		int x = e.getX()-8;
		int y = e.getY()-130;
		
		x=x/100;
		y=y/100;
		
		// Kun nappula on valittu ja kohteen väri on eri
		if(pelilauta.get(new Point(x,y))!=null&&valinta!=null) {
		if(pelilauta.get(new Point(x,y)).väriValk!=valinta.väriValk) {
			kohde = new Point(x,y);
		}
		}
		//Kun nappulaa ei ole vielä valittu
		if(pelilauta.get(new Point(x,y))!=null  && pelilauta.get(new Point(x,y)).väriValk == vuoroValk && valinta==null) {
		
	    
		sallitutLiikkeet=pelilauta.get(new Point(x,y)).liike(x,y,vuoroValk);
		
		
		
		
		valinta = pelilauta.get(new Point(x,y));
	    valinnanSijainti = new Point (x,y);
		
		gui.repaint();
		
		}
		  //siirretään nappula uuteen paikkaan jos kohderuudussa ei mitään
		else if(valinta != null && kohde == null && sallitutLiikkeet!=null) {
			kohde = new Point (x,y);
			
		
			if(sallitutLiikkeet.contains(kohde)) {
				pelilauta.replace(kohde,null);
				pelilauta.put(kohde,valinta);
			    pelilauta.put(valinnanSijainti, null);
				valinta = null;
			    kohde   = null;
			    valinnanSijainti = null;
			    sallitutLiikkeet=null;
			    vuoroValk = !vuoroValk;
			    gui.repaint();
			}
			else {
				valinta = null;
				kohde = null;
				sallitutLiikkeet=null;
				gui.repaint();
			}
			
		//liikutetaan varattuun ruutuun vain jos vihollisnappula ruudussa eli syöminen 
		}else if(valinta != null && kohde != null && pelilauta.get(kohde).väriValk != vuoroValk ){
			
			
				if(sallitutLiikkeet.contains(kohde) && !(pelilauta.get(kohde) instanceof Kuningas)) {
					pelilauta.replace(kohde,null);
					pelilauta.put(kohde,valinta);
					pelilauta.put(valinnanSijainti, null);
					valinta = null;
					kohde   = null;
					valinnanSijainti = null;
					sallitutLiikkeet=null;
					vuoroValk = !vuoroValk;
					gui.repaint();
			
				}else {
					valinta = null;
				    kohde   = null;
				    valinnanSijainti = null;
				    sallitutLiikkeet=null;
				    gui.repaint();
					
				}
		}// Jos kohde ei ole sallittu
		else {
			valinta = null;
		    kohde   = null;
		    valinnanSijainti = null;
		    sallitutLiikkeet=null;
		    gui.repaint();
		}
		
		//Sotilas kuningattareksi
		if(pelilauta.get(new Point(x,y)) instanceof Sotilas && y==0) {
			boolean vari = pelilauta.get(new Point(x,y)).väriValk;
			pelilauta.replace(new Point(x,y), null);
			pelilauta.put(new Point(x,y), new Kuningatar(vari));
			pelilauta.put(valinnanSijainti, null);
			
			valinta = null;
			kohde   = null;
			
			gui.repaint();
		}
		else if(pelilauta.get(new Point(x,y)) instanceof Sotilas && y==7) {
			boolean vari = pelilauta.get(new Point(x,y)).väriValk;
			pelilauta.replace(new Point(x,y), null);
			pelilauta.put(new Point(x,y), new Kuningatar(vari));
			pelilauta.put(valinnanSijainti, null);
			valinta = null;
			kohde   = null;
		
			
			gui.repaint();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**Tallentaa pelitilan tiedostoon kohteeseen src/tallennus.ser
	 * 
	 */
	public void tallennaPeli() {
		
		
		
		try {
			FileOutputStream fileOut = new FileOutputStream("src/tallennus.txt");
			ObjectOutputStream o = new ObjectOutputStream(fileOut);
		
			o.writeObject(new Pelitila(pelilauta,vuoroValk));
			o.close();
			fileOut.close();
		
		} catch (IOException ioe) {
			// virhe tallennustiedostoon kirjoittamisessa
			ioe.printStackTrace();
		}
	}		
	
	/**Lataa pelitilan tiedostosta kohteesta src/tallennus.ser
	 * 
	 */
	public void lataaPeli() {
		
		Pelitila pelitila;
		
		try {
			
			FileInputStream fileIn = new FileInputStream("src/tallennus.txt");
		    ObjectInputStream in   = new ObjectInputStream(fileIn);
		    
		    pelitila =  (Pelitila) in.readObject();
		    pelilauta = pelitila.annaPelilauta();
		    vuoroValk = pelitila.annaVuoro();
		   
			sallitutLiikkeet = null;
		    valinta = null;
		    kohde = null;
		    valinnanSijainti = null;
		 			
		    in.close();
		    fileIn.close();			
		    			
		} catch(IOException ioe) {
			// virhe tallennustiedoston luvussa
			ioe.printStackTrace();
			
		} catch (ClassNotFoundException cnfe) {
			// tallennustiedostoa ei löydy
			cnfe.printStackTrace();
		}
	}	
	
}