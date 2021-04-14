package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import DAO.AnagrammaDAO;

public class Model {
	// attenzione all'inizializzzione per i anagrammadao, meglio farla fuori!!!
	private AnagrammaDAO AnagrammaDAO= new AnagrammaDAO();
	private HashSet<String> anagrammi= new HashSet<String>();
	
	/*public void Model() {
		AnagrammaDAO= new AnagrammaDAO();
	}*/
	public Set<String> doAnagramma(String parola){
		permuta("",parola,0);
		return this.anagrammi;
		}
	public void clearAnagrammi() {
		this.anagrammi.clear();
	}
	
	private void permuta(String parziale,String lettere,int livello) {
		if(lettere.length()==0) {//caso terminale
			// la soluzione parziale diventa quindi una soluzione completa
			// e quindi lo stampiamo
			//System.out.println(parziale);
			// non posso scrivere qua un ritorno parzialeperchè ritornerebbe solo al precedente
//			 mi serve un luogo per salvare le cose
			this.anagrammi.add(parziale);
			// 2 oppure questo controllo lo faccio nel caso terminale, (se parola è corretta la ggiungo) evito di aggiun
			// gere qualcosa che poi devo cancellare
		}else {
//			fai ricorsione
			// sottoproblema== una lettera di lettere (singolo carattere)
			for(int pos=0;pos<lettere.length();pos++) {
				char tentativo= lettere.charAt(pos);
				// stringa + un char che concatena
				// backtracking ho sporcato la sol parziale e devo togliere il valore precedente 
				String nuovaParziale=parziale + tentativo;
				String nuovaLettere= lettere.substring(0,pos)+lettere.substring(pos+1);// togli carattere pos dalle lettere per tornare alla sol precedente
				
				//3 posso controllare se la nuovaParziale è prefisso valido di almeno una parola nel dizionario
				// aqz, no (car si) ma non è detto che questo metodo si efficiente
				
				permuta(nuovaParziale,nuovaLettere,livello+1);
				// backtracking(ora non serve perchè abbiamo stringhe temporanee)
				// rimetti aposto parziale e rimetti a posto le lettere
			}
		}
	}
	public boolean prova(String s) {
	return AnagrammaDAO.isCorrect(s);
	}
		
		public Map<String,Boolean> corretto(Set<String> a){
//			List<Boolean> giusto= new ArrayList<Boolean>();
			Map<String,Boolean> mappa=new HashMap<String,Boolean>();
			for(String s:a) {
			if(AnagrammaDAO.isCorrect(s)) {
					mappa.put(s,true);
				}
				else {
					mappa.put(s, false);
				}
			
		}
			return mappa;

		}
}

