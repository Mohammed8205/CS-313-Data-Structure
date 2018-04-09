import java.util.*;
import java.io.*;
public class problem11 {

	public static void main(String[] args) throws FileNotFoundException {
		Map <String , String> m= new HashMap();
		Scanner scan = new Scanner(new File("file"));
		int max=0;
		while(scan.hasNext()){
			String word= scan.next();
			if(m.containsKey(word)){
				String num= m.get(word).length()+"1";
				m.put(word, num);
				if(num.length()>max){
					max++;
				}
			}
		}
		Iterator <String> it= m.keySet().iterator();
		while(it.hasNext()){
			String result= it.next();
			String longg = m.get(result);
			if(longg.length()==max){
				System.out.print(result);
			}
		}

	}

}
