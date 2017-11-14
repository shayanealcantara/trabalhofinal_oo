package dados;

public class Turma {

	private String disciplina;
	private Aluno alunos;
	private int quant_Alunos;
	
	public String getDisciplina() {
		return disciplina;
	}
  
	public void setDisciplina(String disciplina) {
		if(disciplina.equals(" ")){
			try{
				throw new DisciplinaEmBrancoException("Insira uma disciplina");
			} catch DisciplinaEmBrancoException(disciplina d)
		}
		this.disciplina = disciplina; 
	}
  
	public Aluno getAlunos() {
		return alunos;
	}
  
	public void setAlunos(Aluno alunos) {
		this.alunos = alunos;
	}
	
	public void matricular(Aluno a){
		
		if(this.quant_Alunos < 45){
			a.add();
		}
   
		try {
			if(this.quant_Alunos > 45){
				throw new TurmaCheiaException();
			}
      
		} catch (TurmaCheiaException e) {
			System.out.println("Turma cheia.");
		}
	}
	
	public void desmatricular(Aluno a){
		
		try{
		if(this.quant_Alunos == 0){
			throw new TurmaVaziaException();
		} catch (TurmaVaziaException e){
			System.out.println("Turma vazia, não há alunos para desmatricular.");
		}
	
		}
	}
}
}
