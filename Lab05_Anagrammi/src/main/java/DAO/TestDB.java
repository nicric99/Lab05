package DAO;

public class TestDB {

	public static void main(String[] args) {
		AnagrammaDAO diz= new AnagrammaDAO();
		System.out.println(diz.getParole().toString());
		System.out.println(diz.isCorrect("aasadasd"));
		
	}

}
