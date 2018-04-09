

import java.util.Scanner;

//import class17.HeapPriorityQueue;
//import class17.PriorityQueue;


class PQunsorted<K extends Comparable<K>> implements PriorityQueue<K> {
	K[] data;
	int size;
	int capacity;

	public PQunsorted() {
		capacity = 100;
		size = 0;
		data = (K[]) new Comparable[capacity];
	}
	
	// easy insertion
	public void insert(K x) throws Exception {
		if (size >= capacity) throw new Exception("Queue full");
		data[size++] = x;
	}

	public K removeMin() throws Exception {
        // TODO complete code to remove min here
        
        int i=0;
        int min = 0;
        if(size == 0)return null;
        while(i<size)//finding min
        {
           if(data[min].compareTo(data[i])>0)
           min=i;
              
           i++;
       }
       i=min;
       K swap;
       while(i<size-1)//removing min
       {
           swap = data[i];
           data[i]=data[i+1];
           data[i+1]=swap;
           i++;  
       }
       size--;//removing min element
      
       K rdata = data[i];
      
      
      
        return rdata;
	}

}
		

class PQsorted<K extends Comparable<K>> implements PriorityQueue<K> {
	K[] data;
	int size;
	int capacity;

	public PQsorted() {
		capacity = 100;
		size = 0;
		data = (K[]) new Comparable[capacity];
	}
	public void insert(K x) throws Exception {
		if(size>capacity) throw new Exception("Array is full");
		data[size++]=x;
		for(int i=0; i<size; i++){
			if(data[size-1].compareTo(data[i])>0){
				K temp= data[size-1];
				data[size-1]=data[i];
				data[i]=temp;
			}
		}

	}

        // easy removal in this implementation
	public K removeMin() throws Exception {
		if (size == 0) throw new Exception("Queue Empty");
		return data[--size];
	}
}

// ---------------------- main program to test implementations ---

class PQT {
	public static void main(String args[]) {
		PriorityQueue<String> pq = new HeapPriorityQueue<>();
		PriorityQueue<String> pqU = new PQunsorted<>();
		PriorityQueue<String> pqS = new PQsorted<>();
		boolean done = false;
		Scanner sc = new Scanner(System.in);
		while (!done) {
			try {
				// add your name into the following print statement
				System.out.println(
                                  "\nProgram by: xxxx ---- cmds are + - Q: >>");
				String cmd = sc.next();
				String entry = null;
				char command = cmd.charAt(0);
				if (command == '+')
					entry = sc.next();
				switch (cmd.charAt(0)) {
				case 'Q':
					done = true;
					break;
				case '+':
					pq.insert(entry);
					pqU.insert(entry);
					pqS.insert(entry);
					break;
				case '-':
					System.out.print(pq.removeMin() + "  ");
					System.out.print(pqU.removeMin() + "  ");
					System.out.print(pqS.removeMin() + "\n");
					break;
				}
			} catch (Exception e) {
				System.out.println("Error " + e.toString());
			}
		}
		sc.close();
	}
}