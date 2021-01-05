

import java.net.URL;
import java.util.*;
public class Json_wiki {
	public ArrayList<String> wiki(String str)  {
		ArrayList<String> al=new ArrayList<String>();
		try {
			URL u = new URL(str);
			int a=str.lastIndexOf('/');
			String title="";
			for(int k=a+1;k<str.length();k++)
				title+=str.charAt(k);
			//System.out.println(title);
			String link="https://en.wikipedia.org/w/api.php?format=json&action=query&titles="+title+"&prop=revisions&rvprop=content";
			//System.out.println(link);
			URL url = new URL(link);
			Scanner sc = new Scanner(url.openStream());
			StringBuffer sb = new StringBuffer();
		      while(sc.hasNext()) {
		         sb.append(sc.next());
		         sb.append(" ");
		      }
		      
		     String result = sb.toString();
		     
		     int i=result.indexOf("pageid");
		     String pid="";
		     int j=i+8;
		     while(Character.isDigit(result.charAt(j)))
		     {
		    	 pid+=result.charAt(j);
		    	 j++;
		     }
		     System.out.println("pageid="+pid);
		     al.add(pid);
		     int p=result.lastIndexOf("See also");
		     System.out.println(p);
		     int q=p+10;
		     String seea="";
		     
		     int c=0,c1=0;
		     while(!(result.charAt(q)=='=' && result.charAt(q+1)=='='))
		     {
		    	 if(result.charAt(q)=='*')
		    		 c++;
		    	 if(result.charAt(q)=='[')
		    		 c1++;
		    	 if(c!=0 && c1!=0)
		    	 {if(result.charAt(q-1)!='\\' && (Character.isAlphabetic(result.charAt(q)) || Character.isDigit(result.charAt(q)) || result.charAt(q)=='(' || result.charAt(q)=='\'' || result.charAt(q)==')'))
		    	 {
		    		 seea+=result.charAt(q);
		    	 }
		    	 else if(result.charAt(q)==' ')
		    	 {
		    		 seea+='_';
		    	 }
		    	 else if(result.charAt(q)=='|')
		    	 {
		    		 c1=0;
		    		 al.add(seea);
		    		 seea="";
		    	 }
		    	 else if(result.charAt(q)==']' && result.charAt(q-1)==']')
		    	 {
		    		 al.add("https://en.wikipedia.org/wiki/"+seea);
		    		 seea="";
		    	 }}
		    	 q++;
		    	 
		     }
		     
		     System.out.println(al);
		     
		} catch (Exception ex) {
			al.add("Enter valid url");
			return al;
		}
		return al;
	}
	
}
