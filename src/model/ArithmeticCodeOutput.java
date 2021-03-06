package model;

import java.util.ArrayList;

public class ArithmeticCodeOutput {
	
	private ArrayList<byte[]> stream;
	private int n0,n1,n2,n3;
	
	public ArithmeticCodeOutput(ArrayList<byte[]> stream, int n0,int n1,int n2,int n3){
		this.stream = stream;
		this.n0=n0;
		this.n1=n1;
		this.n2=n2;
		this.n3=n3;
	}

	public ArrayList<byte[]> getStream() {
		return stream;
	}

	public int getN0() {
		return n0;
	}

	public int getN1() {
		return n1;
	}

	public int getN2() {
		return n2;
	}

	public int getN3() {
		return n3;
	}

}
