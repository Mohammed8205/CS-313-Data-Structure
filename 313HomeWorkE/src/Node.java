import java.util.Iterator;

public abstract class Node<K> {
   protected Node<K> parent;
   protected K data;

   public abstract Iterator<? extends Node<K>> children();

   public void setParent(Node<K> n) {
      parent = n;
   }

   public void setData(K t) {
      data = t;
   }

   public Node<K> getParent() {
      return parent;
   }

   public K getData() {
      return data;
   }
}