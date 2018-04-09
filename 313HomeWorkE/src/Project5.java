import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

//import class22.BST;
//import class13.BNode;
//import class17.PriorityQueue;

class BSTPQ<K extends Comparable<K>> extends BST<K> implements PriorityQueue<K> {

	public void insert(K x) throws Exception {
		
		BNode<K> nValue = findNode(x);
		while ( nValue != null && nValue.getLeft() != null && ( nValue.getData()).equals(x) ){
		nValue = findNode(nValue.left, x);
		}
		//System.out.print(nValue.getData());
		if (nValue == null){
			addRoot(x);
		}
		else if ((nValue.getData()).compareTo(x) < 0){
			addRight(nValue, x);
		}else
		//else if (( nValue.getData()).compareTo(x) >= 0){
			addLeft(nValue, x);
		//}
		
	}
	
	public K removeMin() throws Exception {
		if (root == null) throw new Exception("Tree is empty");
		BNode<K> del = (BNode<K>) root();
		while (del.left != null){
			del = del.left;
		}
		K d =  del.getData();
		//del.left=null;
		removeNode(del);
		return  d;
		}
	}



class Project5 {
   public static Iterator<Integer> PQsort(Iterator<Integer> x) throws Exception {
      PriorityQueue<Integer> q = new BSTPQ<Integer>();
      while (x.hasNext()) 
         q.insert(x.next());
      ArrayList<Integer> temp = new ArrayList<>();
      try {
         while (true) temp.add(q.removeMin());
      } catch (Exception e) {}
      return temp.iterator();
  }

  public static void main(String args[]) throws Exception {
     Random r = new Random();     
     ArrayList<Integer> v = new ArrayList<>();
     for (int i = 0; i < 20; i++)
        v.add(r.nextInt(30));
     System.out.print("Unsorted: ");
     for (Integer x:v) System.out.print("" + x + " ");
     System.out.print("\n  Sorted: ");
     Iterator<Integer> sorted = PQsort(v.iterator());
     while (sorted.hasNext())  
        System.out.print("" + sorted.next() + " ");
     System.out.println();
    
  }
}