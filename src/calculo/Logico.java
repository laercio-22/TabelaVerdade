package calculo;
import java.util.ArrayList;
import java.util.List;

class Sequencia {
	int precedencia;
	int iTermo1;
	int iTermo2;
	int iResultado;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[Precedencia]: " + this.precedencia +
				" [iTermo1]: " + this.iTermo1 +
				" [iTermo2]: " + this.iTermo2 +
				" [iResultado]: " + this.iResultado ;
	}
	
	
}

public class Logico {

	public static String[][] calcular(String[][] tabela) {
		// TODO Auto-generated method stub
		String [] header = tabela[0];
		Sequencia [] ordem = ondernarExecucao(header);
		
		for (int i = 0; i < ordem.length; i++) {
			Sequencia s = ordem[i];
			
			for(int j = 1; j < tabela.length; j ++) {
				String t1 = tabela[j][s.iTermo1];
				String t2 = tabela[j][s.iTermo2];
				String op = tabela[0][s.iResultado];
				tabela[j][s.iResultado] = calcular(t1, op, t2);
			}
		}
		return tabela;
	}
	
	public static String[][] calcular (String termo) {
		return calcular(montarTabela(termo));
	}
	
	
	
	private static Sequencia[] ondernarExecucao(String[] header) {
		List<Sequencia> seq = new ArrayList<Sequencia>();	
		int iResultadoAnterior = -1;
		for(int i = 0; i < header.length; i++) {
			if ( eOperador(header[i]) ) {
				
				Sequencia s = new Sequencia();
				s.precedencia = precedencia(header[i]);
				//s.iTermo1 = (seq.isEmpty()) ? i-1 : iResultadoAnterior;
				s.iTermo1 = i-1;
				s.iTermo2 = i+1;
				s.iResultado = i;
				seq.add(s);
				
				//iResultadoAnterior = i;
			}
		}
		
		System.out.println("Não ordenado");
		for (Sequencia s : seq) {
			System.out.println(s);
		}
		
		seq.sort( (x, y) -> x.precedencia - y.precedencia );
		
		System.out.println("\nOrdenado");
		for (Sequencia s : seq) {
			System.out.println(s);
		}
		
		for (Sequencia s : seq) {
			if(iResultadoAnterior == -1) {
				iResultadoAnterior = s.iResultado;
			}
			else {
				if (iResultadoAnterior < s.iResultado) s.iTermo1 = iResultadoAnterior;
				else s.iTermo2 = iResultadoAnterior;
			}
		}
		
		System.out.println("\nSequenciado");
		for (Sequencia s : seq) {
			System.out.println(s);
		}
		
		
		
		Sequencia [] a = new Sequencia[seq.size()];
		return seq.toArray(a);
	}
	
	
	
	public static int precedencia(String op) {
		// TODO Auto-generated method stub
		int p = -1;
		
		if("^".equals(op)) p = 3;
		else if ("v".equals(op)) p = 4;
		else if("!".equals(op)) p = 5; //ou..ou
		else if("->".equals(op)) p = 6;
		else if("<->".equals(op)) p = 7;
		return p;
	}

	public static String[][] montarTabela(String termo) {
		// TODO Auto-generated method stub
		String [] header = termo.split(" ");
		int nP = numPreposicoes(header);
		int nO = numOperacoes(header);
		int nLinhas = numLinhas(header);
		
		String [][] tabela = new String[nLinhas+1][header.length];
		
		tabela[0] = header;
		
		int lim = 1;
		for (int i = 0; i < tabela[0].length; i++) {
			
			if (Logico.ePreposicao(tabela[0][i])) {
				int cont = 0;
				
				boolean val = true;
				
				if(tabela[0][i].contains("~")) val = false;
				
				for (int j = 1; j < tabela.length; j++, cont++ ) {
					
					if(cont >= lim) {
						val = !val;
						cont = 0;
					}
					
					if(val) tabela[j][i] = "V";
					else tabela[j][i] = "F";
					
				}
				lim = lim * 2;
			}
			
		}
		
		return tabela;
	}
	
	private static int numLinhas(String[] header) {
		// TODO Auto-generated method stub
		int nP = numPreposicoes(header);		
		return (int) Math.pow(2.0, (double) nP);
	}

	private static int numOperacoes(String[] t) {
		// TODO Auto-generated method stub
		int cont = 0;
		for (int i= 0; i < t.length; i++) {			
			if(Logico.eOperador(t[i])) cont++;
		}
		return cont;
	}

	private static int numPreposicoes(String[] t) {
		// TODO Auto-generated method stub
		int cont = 0;
		
		for(int i = 0; i < t.length; i++) {
			
			if(Logico.ePreposicao(t[i])) cont++;
		}
		
		return cont;
	}

	public static boolean eOperador(String s) {
		// TODO Auto-generated method stub
		return "v".equals(s)   ||
				"^".equals(s)  ||
				"->".equals(s) ||
				"<->".equals(s)||
				"!".equals(s);
	}
	
	public static boolean ePreposicao(String s) {
		// TODO Auto-generated method stub		
		return "P".compareToIgnoreCase(s) == 0 ||
				"Q".compareToIgnoreCase(s) == 0 ||
				"R".compareToIgnoreCase(s) == 0 ||
				"S".compareToIgnoreCase(s) == 0 ||
				"~P".compareToIgnoreCase(s) == 0 ||
				"~Q".compareToIgnoreCase(s) == 0 ||
				"~R".compareToIgnoreCase(s) == 0 ||
				"~S".compareToIgnoreCase(s) == 0 ;
	}


	public static String calcular(String P, String op, String Q) {
		// TODO Auto-generated method stub
		String result = "";
		switch(op) {
			case "->":	//se			
				if( eVerdadeiro(P) && !eVerdadeiro(Q)) result = "F";
				else result = "V";
				break;
				
			case "<->": //se e somente se
				if(eVerdadeiro(P) && eVerdadeiro(Q)) result = "V";
				else if( !eVerdadeiro(P) && !eVerdadeiro(Q)) result = "V";
				else result = "F";
				break;
				
			case "^": //e
				if(eVerdadeiro(P) && eVerdadeiro(Q)) result = "V";
				else result = "F";
				break;
				
			case "v": //ou
				if( !eVerdadeiro(P) && !eVerdadeiro(Q)) result = "F";
				else result = "V";
				break;
			
			case "!": //ou..ou
				if( eVerdadeiro(P) && !eVerdadeiro(Q)) result = "V";
				else if (!eVerdadeiro(P) && eVerdadeiro(Q)) result = "V";
				else result = "F";
				
			default:
				
		}
		return result;
	}
	
	public static boolean eVerdadeiro(String P){
		if ("V".equals(P)) return true;
		else return false;
	}

}
