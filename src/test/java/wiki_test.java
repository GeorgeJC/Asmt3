import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class wiki_test {
	Json_wiki jw;
	@Before
	public void setup()
	{
		 jw=new Json_wiki();
	}
	@Test
	public void testhappy() {
		String link="https://en.wikipedia.org/wiki/SMALL";
		ArrayList<String> al=new ArrayList<String>();
		al.add("1808130");
		al.add("https://en.wikipedia.org/wiki/Lua_(programming_language)");
		al.add("https://en.wikipedia.org/wiki/Squirrel_(programming_language)");
		
		try {
			assertEquals(al, jw.wiki(link));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testHappy2() {
		String link="https://en.wikipedia.org/wiki/C";
		ArrayList<String> al=new ArrayList<String>();
		al.add("5200013");
		al.add("https://en.wikipedia.org/wiki/Hard_and_soft_C");
		al.add("https://en.wikipedia.org/wiki/Speed_of_light");
		
		try {
			assertEquals(al, jw.wiki(link));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testInvalid() {
		String link="";
		ArrayList<String> al=new ArrayList<String>();
		al.add("Enter valid url");
		try {
			assertEquals(al, jw.wiki(link));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testInvalid2() {
		String link="asdf/dsdfr.com";
		ArrayList<String> al=new ArrayList<String>();
		al.add("Enter valid url");
		try {
			assertEquals(al, jw.wiki(link));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
