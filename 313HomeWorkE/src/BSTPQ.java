/*//import tree.Node;

public class BSTPQ<K extends Comparable<K>> extends BST<K> implements PriorityQueue<K> {
		
		public void insert(K x) throws Exception {
			
			BNode<K> dup = findNode(x);
			while ( dup != null && dup.getLeft() != null && ( dup.getData()).equals(x) ){
				
			dup = findNode(dup.getLeft(), x);
			}
			if (dup == null){
				addRoot(x);
			}
			else if ((dup.getData()).compareTo(x) < 0){
				addRight(dup, x);
			}
			else if (( dup.getData()).compareTo(x) >= 0){
				addLeft(dup, x);
			}

			
	}
	
		public K removeMin() throws Exception {
			if (root() == null) throw new Exception("Tree is empty");
			BNode<K> del = (BNode<K>) root();
			while (del.getLeft() != null){
				del = del.getLeft();
			}
			K d =  del.getData();
			removeNode(del);
			return  d;
			}
}
*/