import java.util.ArrayList;

public class Tester {

	private ArrayList<Integer> fun;
	private ArrayList<Object> yay;
	String stuff;

	public Tester() {
		fun = new ArrayList<Integer>();
		fun.add(1);
		fun.add(2);
		fun.add(3);
		fun.add(4);
		fun.add(5);
		fun.add(6);
		fun.add(7);
		fun.add(8);
		
		yay = new ArrayList<Object>();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tester t1 = new Tester();
		t1.print();
		t1.proaa(1);
		// t1.set(2, 15);

	}

	public void print() {

		System.out.println(fun);

	}

	public ArrayList<Integer> proaa(int n) {

		ArrayList<Integer> yaya = fun;
		
		
		
		
		for(int i = 0; i < fun.size()/2; i++) {
			if (i%2==0) {
				fun.remove(i);
				fun.add(yaya.get(i));
			}
		}

		for(int j = fun.size()/2; j < fun.size()-1; j++) {
			if (j%2!=0) {
				fun.remove(j);
				fun.add(yaya.get(j));
			}
		}
		
	
	
		return fun;

	}

}
