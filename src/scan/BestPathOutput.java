package scan;

import java.util.ArrayList;

public class BestPathOutput {
	String bestPathName; //best path P scelto
	int E; //Sum E of absolute values of prediction errors along P
	int B; //Numero di bit necessari per la codifica di P
	ArrayList<Integer> L; //Sequence L of prediction errors along P
	
	public BestPathOutput(String bestPathName, int a, int b, ArrayList<Integer> l) {
		super();
		this.bestPathName = bestPathName;
		E = a;
		B = b;
		L = l;
	}

	public BestPathOutput() {
		super();
	}

	public void setBestPathName(String bestPathName) {
		this.bestPathName = bestPathName;
	}

	public void setE(int e) {
		E = e;
	}

	public void setB(int b) {
		B = b;
	}

	public void setL(ArrayList<Integer> l) {
		L = l;
	}

	public String getBestPathName() {
		return bestPathName;
	}

	public int getE() {
		return E;
	}

	public int getB() {
		return B;
	}

	public ArrayList<Integer> getL() {
		return L;
	}
	
	
}
