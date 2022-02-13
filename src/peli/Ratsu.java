package peli;

import java.awt.Point;
import java.util.ArrayList;

public class Ratsu extends Nappula {
	
	private String nimi = "Ratsu";
	
	public Ratsu(Boolean väri) {
		super(väri, "src/peli/ratsuV.png", "src/peli/ratsuM.png");
	}
	
public ArrayList<Point> liike(int x,int y, boolean väri) {
		
	ArrayList<Point> taul = new ArrayList<Point>();
	
		if(x+2<8&&y+1<8) {
		if(Pelilogiikka.pelilauta.get(new Point(x+2,y+1))!=null) {
		if(Pelilogiikka.pelilauta.get(new Point(x+2,y+1)).väriValk!=väri){
			taul.add(new Point(x+2,y+1));
		}
		}
		else {
			taul.add(new Point(x+2,y+1));
		}
		}
	
		if(x+2<8&&y-1>-1) {
		if(Pelilogiikka.pelilauta.get(new Point(x+2,y-1))!=null) {
		if(Pelilogiikka.pelilauta.get(new Point(x+2,y-1)).väriValk!=väri){
			taul.add(new Point(x+2,y-1));
		}
		}
		else {
			taul.add(new Point(x+2,y-1));
		}
		
		}
		
		if(x-2>-1&&y+1<8){
		if(Pelilogiikka.pelilauta.get(new Point(x-2,y+1))!=null) {
		if(Pelilogiikka.pelilauta.get(new Point(x-2,y+1)).väriValk!=väri){
			taul.add(new Point(x-2,y+1));
		}
		}
		else {
			taul.add(new Point(x-2,y+1));
		}
		}
		
		if(x-2>-1&&y-1>-1) {
		if(Pelilogiikka.pelilauta.get(new Point(x-2,y-1))!=null) {
		if(Pelilogiikka.pelilauta.get(new Point(x-2,y-1)).väriValk!=väri){
			taul.add(new Point(x-2,y-1));
		}
		}
		else {
			taul.add(new Point(x-2,y-1));
		}

		}

		
		if(y+2<8&&x+1<8) {
		if(Pelilogiikka.pelilauta.get(new Point(x+1,y+2))!=null) {
		if(Pelilogiikka.pelilauta.get(new Point(x+1,y+2)).väriValk!=väri){
			taul.add(new Point(x+1,y+2));
		}
		}
		else {
			taul.add(new Point(x+1,y+2));
		}
		
		}
		
		
		if(y+2<8&&x-1>-1) {
		if(Pelilogiikka.pelilauta.get(new Point(x-1,y+2))!=null) {
		if(Pelilogiikka.pelilauta.get(new Point(x-1,y+2)).väriValk!=väri){
			taul.add(new Point(x-1,y+2));
		}
		}
		else {
			taul.add(new Point(x-1,y+2));
		}
		
		}
		
		if(y-2>-1&&x+1<8) {
		if(Pelilogiikka.pelilauta.get(new Point(x+1,y-2))!=null) {
		if(Pelilogiikka.pelilauta.get(new Point(x+1,y-2)).väriValk!=väri){
			taul.add(new Point(x+1,y-2));
		}
		}
		else {
			taul.add(new Point(x+1,y-2));
		}
		
		}
		
		if(y-2>-1&&x-1>-1) {
		if(Pelilogiikka.pelilauta.get(new Point(x-1,y-2))!=null) {
		if(Pelilogiikka.pelilauta.get(new Point(x-1,y-2)).väriValk!=väri){
			taul.add(new Point(x-1,y-2));
		}
		}
		else {
			taul.add(new Point(x-1,y-2));
		}
		}
	
	return taul;
	}


public String annaNimi() {
	return nimi;
}	
}
