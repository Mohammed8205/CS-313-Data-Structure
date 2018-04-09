import java.util.ArrayList;
import java.util.Iterator;

public class Tree<K> {
   protected Node<K> root;
   protected int size;

   public Tree() {
      root = null;
      size = 0;
   }

   public Node<K> root() {
      return root;
   }

   public Node<K> parent(Node<K> v) {
      return v.getParent();
   }

   public Iterator<? extends Node<K>> children(Node<K> v) {
      return v.children();
   }

   public boolean isRoot(Node<K> v) {
      return v == root;
   }

   public boolean isInternal(Node<K> v) {
      return children(v).hasNext();
   }

   public boolean isLeaf(Node<K> v) {
      return !isInternal(v);
   }

   public int size() {
      return size;
   }

   public boolean empty() {
      return size == 0;
   }

   public void replace(Node<K> v, K t) {
      v.setData(t);
   }

   public int depth(Node<K> v) {
      if (isRoot(v))
         return 0;
      return 1 + depth(parent(v));
   }

   public int height(Node<K> v) {
      if (isLeaf(v))
         return 0;
      int maxChild = 0;
      Iterator<? extends Node<K>> c = children(v);
      while (c.hasNext()) {
         int hc = height((Node<K>) c.next());
         if (hc > maxChild)
            maxChild = hc;
      }
      return maxChild + 1;
   }

   public int height() {
      if (root == null)
         return -1;
      return height(root);
   }

   public ArrayList<Node<K>> preOrder() {
      ArrayList<Node<K>> answer = new ArrayList<>();
      preOrder(root(), answer);
      return answer;
   }

   public void preOrder(Node<K> n, ArrayList<Node<K>> v) {
      if (n == null)
         return;
      v.add(n);
      Iterator<? extends Node<K>> x = children(n);
      while (x.hasNext()) {
         Node<K> m = x.next();
         preOrder(m, v);
      }
   }

   public ArrayList<Node<K>> postOrder() {
      ArrayList<Node<K>> answer = new ArrayList<Node<K>>();
      postOrder(root(), answer);
      return answer;
   }

   public void postOrder(Node<K> n, ArrayList<Node<K>> v) {
      if (n == null)
         return;
      Iterator<? extends Node<K>> x = children(n);
      while (x.hasNext()) {
         Node<K> m = x.next();
         postOrder(m, v);
      }
      v.add(n);
   }

   public ArrayList<Node<K>> levelOrder() {
      ArrayList<Node<K>> waiting = new ArrayList<>();
      waiting.add(null);
      if (root() == null)
         return waiting;
      waiting.add(root());
      int done = 0;
      while (done < waiting.size()) {
         Node<K> oldNode = waiting.get(done++);
         if (oldNode == null) {
            if (done < waiting.size())
               waiting.add(null);
            continue;
         }
         Iterator<? extends Node<K>> c = children(oldNode);
         while (c.hasNext())
            waiting.add(c.next());
      }
      return waiting;
   }

   public ArrayList<? extends Node<K>> flatOrder() {
      return preOrder();
   }

   public String toString() {
      return treePrint(null);
   }

   public String treePrint(Node<K> cursor) {
      String answer = "  ";
      Iterator<Node<K>> lev = levelOrder().iterator();
      Iterator<? extends Node<K>> flat = flatOrder().iterator();
      lev.next(); // skip first new line
      while (lev.hasNext()) {
         Node<K> o = lev.next();
         if (o == null) {
            answer += "\n  ";
            flat = flatOrder().iterator();
         } else
            while (true) {
               boolean atCursor = false;
               Node<K> n = flat.next();
               if (n == cursor)
                  atCursor = true;
               String s = n.getData().toString();
               if (atCursor)
                  s = "* " + s + " *";
               if (n == o) {
                  answer += s;
                  break;
               } else
                  for (int i = 0; i < s.length(); i++)
                     answer += ' ';
            }
      }
      return answer;
   }
}