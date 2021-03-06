package model;

import java.util.ArrayList;

public class Path {
	public String startAngle;
	String usedPath;
	Path previousPath;
	ArrayList<Pixel> path;
	
	public Path(String startAngle, ArrayList<Pixel> path, String usedPath) {
		super();
		this.startAngle = startAngle;
		this.path = path;
	}
	
	
	public Path() {
		super();
	}


	public String getStartAngle() {
		return startAngle;
	}
	
	
	public void setStartAngle(String startAngle) {
		this.startAngle = startAngle;
	}
	
	public ArrayList<Pixel> getPath() {
		return path;
	}
	
	public void setPath(ArrayList<Pixel> path) {
		this.path = path;
	}
	
	public Pixel getPixel(int index){
		return path.get(index);
	}
	
	public int getX(int index){
		return path.get(index).x;
	}
	
	public int getY(int index){
		return path.get(index).y;
	}
	
	public int size(){
		return path.size();
	}


	public Path getPreviousPath() {
		return previousPath;
	}


	public void setPreviousPath(Path previousPath) {
		this.previousPath = previousPath;
	}
	
	
}
