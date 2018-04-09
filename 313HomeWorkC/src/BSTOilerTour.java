/***************  

 Homework C

 Edit the following file and save it as Cxxxxxxxx.java where xxxxxxxx is
 replaced by your 8 digit ID number. Change the class name to reflect this
 file name. Include a comment with your name at the top of the program in case
 there is a problem with automatic recognition of your ID number. Submit this
 one file as an email attachment to alexander.ryba@qc.cuny.edu

 Remove any initial package declaration that might be added to your
 file in case you edit it in eclipse.

 The goal of the homework is to add an Euler tour traversal (see page 348
 of the text) to the implementation of the class BinaryTree that we have
 considered.   Your class Cxxxxxxxx should extend the class BinaryTree
 and implement just one new method.  

 This file C00000000.java contains a shell for your new class that
 includes a title line for the method you must code and a main program
 (based on the BTreeApp demo from class) to check that your method
 works as it should.

 The only modifications that you should make are to add one or more 
 methods to the class BinaryTree to provide the traversal method called 
 eulerTour. 

 You should also modify the main method to print your name and 8 
 digit id number.

 ********************************************************************/

import java.util.ArrayList;
import java.util.Scanner;

//import class13.BinaryTree;
//import class13.BNode;



public class BSTOilerTour<T> extends BinaryTree<T> {

	public BSTOilerTour() {
		super();
	}
	public ArrayList<BNode<T>> eulerOrder() {
		ArrayList<BNode<T>> list = new ArrayList<BNode<T>>(); 
	 eulerTour((BNode<T>)root,list);
	return list;	// replace this with code that performs the Euler Tour Traversal
	}

	
	public void eulerTour( BNode<T> p, ArrayList<BNode<T>> list) {
		
		list.add(p);
		// previsit
		if(p.getLeft()!=null){
			eulerTour(p.getLeft(),list);
		
		// in visit action
		list.add(p);
		}
		
		if(p.getRight()!=null){
			eulerTour(p.getRight(), list);
		}
		
		// post visit 
		//return list;
		
	}

	// Demo program to test your method --- change this to display your
	// name and id number.  Also change C00000000 to reflect your ID number.

	public static void main(String args[]) {
		BSTOilerTour<String> g = new BSTOilerTour<>();
		BNode<String> cursor = null;
		Scanner s = new Scanner(System.in);
		while (true) {
			try {
				System.out.println(g.treePrint(cursor)
						+ "  commands act at the *cursor*: E  l r X . > < ^ H S Q:");
				String cmd = s.next();
				if (cmd.charAt(0) == 'E') {
					ArrayList<BNode<String>> tour = g.eulerOrder();
					String answer = "";
					for (BNode<String> node: tour)
						answer += node.getData();
					System.out.println(answer);
				}
				if (cmd.charAt(0) == 'Q')
					break;
				if (cmd.charAt(0) == 'H') {
					System.out.println(g.height());
					continue;
				}
				if (cmd.charAt(0) == 'S') {
					System.out.println(g.size());
					continue;
				}
				if (cmd.charAt(0) == 'X' && cursor != null) {
					g.removeNode(cursor);
					cursor = (BNode<String>) g.root();
				}
				if (cmd.charAt(0) == 'l') {
					String entry = s.next();
					if (g.size() > 0)
						g.addLeft(cursor, entry);
					else
						g.addRoot(entry);
				}
				if (cmd.charAt(0) == 'r') {
					String entry = s.next();
					if (g.size() > 0)
						g.addRight(cursor, entry);
					else
						g.addRoot(entry);
				}
				if (cmd.charAt(0) == '.')
					cursor = (BNode<String>) g.root();
				if (cmd.charAt(0) == '>')
					cursor = cursor.getRight();
				if (cmd.charAt(0) == '<')
					cursor = cursor.getLeft();
				if (cmd.charAt(0) == '^')
					cursor = (BNode<String>) cursor.getParent();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		s.close();
	}

}