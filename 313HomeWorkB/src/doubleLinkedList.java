/***********
 Homework B

 Edit the following file and save it as Bxxxxxxxx.java where xxxxxxxx is
 replaced by your 8 digit ID number. Change the class name to reflect this
 file name. Include a comment with your name at the top of the program in case
 there is a problem with automatic recognition of your ID number. Submit this
 one file as an email attachment to alexander.ryba@qc.cuny.edu

 Remove any initial package declaration that might be added to your
 file in case you edit it in eclipse.

 The file B00000000.java contains :

 a class B00000000 with a main method --- which you should change to report your name
 you should also rename this to match your file name
 an interface Deque --- no changes should be made to this
 an implementation class ArrayDeque --- no changes are to be made to this
 a  class DNode for doubly linked nodes --- no changes should be made to this
 an implementation class LinkedDeque  --- the methods of this class are missing.

 The homework assignment is to complete the methods:
 LinkedDeque(), size(), empty(), removeFront(), removeRear(),
 addRear(), addFront(), toString(), main().

 The only change needed in main() is to make it print your name and
 8-digit ID in addition to the other tasks which are already programmed.

 When your homework is correctly implemented, the two deques will operate
 identically and produce duplicate prompts when the main program is run.

 In the other methods, you should supply an implementation using doubly linked
 nodes in such a way that a client would not see a difference between the
 operation of the classes ArrayDeque and Linked Deque.  You must not add any
 additional instance variables to the class LinkedDeque.

 ********************************************************************/

import java.util.Scanner;

public class doubleLinkedList {
	public static void main(String args[]) throws Exception {
		System.out.println("Homework B by  Mohammed Islam "); // fill in your name here
		//Deque<String> q = new ArrayDeque<>();
		LinkedDeque<String> qLink = new LinkedDeque<>();
		DNode <String> d = new DNode<String>("a",null,null);
		qLink.addFront("a");
		qLink.addFront("b");
		qLink.addRear("c");
		qLink.addRear("d");
		qLink.addFront("e");
		qLink.addbeforV("1","a");
		
		System.out.println(qLink);
		//testDeque(q, qLink); // test both together
	}

}	


	// methods for testing purposes
	/*public String toString() {
		int i, j;
		String ans = "";
		for (i = 0, j = front + 1; i < size; i++, j++) {
			if (j == capacity)
				j = 0;
			ans += data[j];
			if (i < size - 1) ans += " -> ";
		}
		return ans;
	}

}*/

class DNode<T> {
	private T data;
	private DNode<T> prev, next;

	public DNode(T x, DNode<T> p, DNode<T> n) {
		data = x;
		prev = p;
		next = n;
	}

	public T getData() {
		return data;
	}

	public DNode<T> getNext() {
		return next;
	}

	public DNode<T> getPrev() {
		return prev;
	}

	public void setData(T x) {
		data = x;
	}

	public void setNext(DNode<T> n) {
		next = n;
	}

	public void setPrev(DNode<T> p) {
		prev = p;
	}
}

class LinkedDeque<T>{
	private DNode<T> front, rear;
	private int size;

	// add implementations for the following methods
	// your code should perform in exactly the same way as the corresponding
	// ArrayDeque<T> methods
	// you should not add any extra instance variables to the class and must
	// use a doubly linked list implementation.

	public LinkedDeque() {
		// add implementation
		rear=front=null;
		size=0;
	}

	public int size() {
		return size;
	}

	public boolean empty() {
		return size==0;
	}

	public T removeFront() throws Exception {
		if(front==null) throw new Exception("List is empty");
		T rd=front.getData(); 
		front=front.getNext();
		size--;
		return rd;
	}

	public T removeRear() throws Exception {
		DNode <T> prev = null;
		if(front==null){
		throw new Exception("list is empty");}
		if(front.getNext()==null){
			front=null;
		}
	else{
		DNode <T> current = front;
		while(current.getNext()!=null){
			 prev = current;
			current=current.getNext();
		}
		rear=prev;
		rear.setNext(null);
	}
		size--;
		return null;	
	}

	public void addRear(T x) throws Exception {
		DNode<T> newNode= new DNode<T>(x,null,null);
		if(front==null){
			rear=front=newNode;
		}else{
			rear.setNext(newNode);
			newNode.setPrev(newNode);
			rear=newNode;
			rear.setNext(null);
		}
		size++;
	}

	public void addFront(T x) throws Exception {
		DNode<T> newNode = new DNode<>(x,null,null);
		if(front==null){
			front=newNode;
			rear=front;
			front.setPrev(null);
		}
		else{
			front.setPrev(newNode);
		newNode.setNext(front);
		front=newNode;
		}
		size++;	
	}
	/*public String toString() {
		String ans = "";
		DNode<T> n = front;
		//ans += "(H)-->";
		while (n != null) {
			ans += n.getData();
			ans += " -> ";
			n = n.getNext();
		}
		return ans;
	}*/
	//add before given V
	public void addbeforV(T x, T y){
		DNode<T> newNode= new DNode <T>(x,null,null);
		DNode <T> back = null;
		if(y==front.getData()){
			newNode.setNext(front);
			front.setPrev(newNode);
			front=newNode;
			front.setPrev(null);
		}else{
			DNode <T> current=front;
			while(current.getData() != y){
				back=current;
				current=current.getNext();
			}
			if(current != null){
			newNode.setNext(current);
			newNode.setPrev(back);
			current.setPrev(newNode);
			back.setNext(newNode);
			size++;
			}
			else{
				System.out.println("Item not found");
			}
		}
	}

	public String toString() {
	       StringBuffer obj = new StringBuffer();
	      
	       if (size != 0) {
	           DNode<T> data = front;
	           obj.append(data.getData());
	           data = data.getNext();
	          
	           while (data != null) {
	               obj.append(" -> " + data.getData());
	               data = data.getNext();
	           }
	       }
	      
	       return obj.toString();
	   }
	}

