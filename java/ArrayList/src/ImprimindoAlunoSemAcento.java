import java.util.*;
public class ImprimindoAlunoSemAcento {

	public static void main(String[] args) {
		
		Set<String> alunos = new HashSet<>();
		alunos.add("Paulo");
		alunos.add("Alberto");
		alunos.add("Pedro");
		alunos.add("Nico");
		
		System.out.println(alunos.size());
		
		alunos.add("Pedro");
		
		System.out.println(alunos.size());
		
		for(String aluno: alunos) {
			System.out.println(aluno);
		}

	}

}
