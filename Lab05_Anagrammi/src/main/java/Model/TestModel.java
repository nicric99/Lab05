package Model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestModel {

	public static void main(String[] args) {
		Map<String,Boolean> mappa= new HashMap<String,Boolean>();
		Model model= new Model();
//	System.out.println(model.doAnagramma("asso").toString());
		mappa=model.corretto(model.doAnagramma("asso"));
//		Set<String> a = new HashSet<String>();
//		a.add("ass");
//		model.corretto(a);
		model.prova("os");
		System.out.println(mappa.toString());

	}

}
