//package class22;

public interface BSTree<K extends Comparable<K>> {
	public void remove(K x);
	public void insert(K x) throws Exception;
	public boolean find(K x);
}