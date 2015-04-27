import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class AlgorithmAnalysis {

	private BinarySearchTree<Integer> bst;
	private AvlTreeRevised<Integer> avl;
	private LinearProbingHashTableGuinn<Integer> lpht;
	private QuadraticProbingHashTable<Integer> qpht;
	private SecondHashFunction<Integer> shf;
	private SeparateChainingHashTable<Integer> scht;

	private File insertOutput;
	private File containsOutput;

	private PrintWriter insertPw;
	private PrintWriter containsPw;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AlgorithmAnalysis a = new AlgorithmAnalysis();
		for (int i = 10000; i <= 1010000; i += 25000) {
			a.populate(i);
			a.contains(i);
			a.makeEmpty();
			System.out.println(i + "");
		}
		a.closeInsertPrintWriter();
		a.closeContainsPrintWriter();
		System.out.println("Done");
		
	}
	
	public void makeEmpty(){
		bst.makeEmpty();
		avl.makeEmpty();
		lpht.makeEmpty();
		qpht.makeEmpty();
		shf.makeEmpty();
		scht.makeEmpty();
	}
	
	public void closeInsertPrintWriter(){
		insertPw.close();
	}
	public void closeContainsPrintWriter(){
		containsPw.close();
	}

	public HW7() {
		bst = new BinarySearchTree<Integer>();
		avl = new AvlTreeRevised<Integer>();
		lpht = new LinearProbingHashTableGuinn<Integer>();
		qpht = new QuadraticProbingHashTable<Integer>();
		shf = new SecondHashFunction<Integer>();
		scht = new SeparateChainingHashTable<Integer>();

		insertOutput = new File("insert.txt");
		containsOutput = new File("contains.txt");

		try {
			insertPw = new PrintWriter(insertOutput);
			containsPw = new PrintWriter(containsOutput);
		} catch (IOException e) {
			System.out.println("File error");
		}
	}

	public void contains(int n) {
		ArrayList<Long> times = new ArrayList<Long>();
		ArrayList<Integer> initial = new ArrayList<Integer>();
		BinarySearchTree<Integer> temp = new BinarySearchTree<Integer>();
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			int next = random.nextInt(2 * n + 1);
			while (temp.contains(next)) {
				next = random.nextInt(2 * n + 1);
			}
			initial.add(next);
			temp.insert(next);
		}
		long start = System.nanoTime();
		for (Integer a : initial) {
			bst.contains(a);
		}
		times.add(System.nanoTime() - start);
		start = System.nanoTime();
		for (Integer a : initial) {
			avl.contains(a);
		}
		times.add(System.nanoTime() - start);
		start = System.nanoTime();
		for (Integer a : initial) {
			lpht.contains(a);
		}
		times.add(System.nanoTime() - start);
		start = System.nanoTime();
		for (Integer a : initial) {
			qpht.contains(a);
		}
		times.add(System.nanoTime() - start);
		start = System.nanoTime();
		for (Integer a : initial) {
			shf.contains(a);
		}
		times.add(System.nanoTime() - start);
		start = System.nanoTime();
		for (Integer a : initial) {
			scht.contains(a);
		}
		times.add(System.nanoTime() - start);

		containsPw.println(n + "\t" + times.get(0) + "\t" + times.get(1) + "\t"
				+ times.get(2) + "\t" + times.get(3) + "\t" + times.get(4)
				+ "\t" + times.get(5));
	}

	public void populate(int n) {
		ArrayList<Long> times = new ArrayList<Long>();
		Random random = new Random();
		ArrayList<Integer> initial = new ArrayList<Integer>();
		BinarySearchTree<Integer> temp = new BinarySearchTree<Integer>();
		for (int i = 0; i < n; i++) {
			int next = random.nextInt(2 * n + 1);
			while (temp.contains(next)) {
				next = random.nextInt(2 * n + 1);
			}
			initial.add(next);
			temp.insert(next);
		}
		long start = System.nanoTime();
		for (Integer a : initial) {
			bst.insert(a);
		}
		times.add(System.nanoTime() - start);
		start = System.nanoTime();
		for (Integer a : initial) {
			avl.insert(a);
		}
		times.add(System.nanoTime() - start);
		start = System.nanoTime();
		for (Integer a : initial) {
			lpht.insert(a);
		}
		times.add(System.nanoTime() - start);
		start = System.nanoTime();
		for (Integer a : initial) {
			qpht.insert(a);
		}
		times.add(System.nanoTime() - start);
		start = System.nanoTime();
		for (Integer a : initial) {
			shf.insert(a);
		}
		times.add(System.nanoTime() - start);
		start = System.nanoTime();
		for (Integer a : initial) {
			scht.insert(a);
		}
		times.add(System.nanoTime() - start);
		insertPw.println(n + "\t" + times.get(0) + "\t" + times.get(1) + "\t"
				+ times.get(2) + "\t" + times.get(3) + "\t" + times.get(4)
				+ "\t" + times.get(5));

	}
}
