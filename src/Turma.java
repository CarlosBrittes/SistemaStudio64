import java.util.ArrayList;
import java.util.List;

class Turma {
    private int id;
    private String nome;
    private String horario;
    private List<Aluno> alunos;
    public Turma(int id, String nome, String horario) {
        this.id = id;
        this.nome = nome;
        this.horario = horario;
        this.alunos = new ArrayList<>();
    } public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    } public void removerAluno(int alunoId) {
        alunos.removeIf(aluno -> aluno.getId() == alunoId);
    } public void removerTodosOsAlunos() {
        alunos.clear();
    } public int getId() {
        return id;
    } public String getNome() {
        return nome;
    } public String getHorario() {
        return horario;
    } public List<Aluno> getAlunos() {
        return alunos;
    } @Override
    public String toString() { return "ID: " + id + "\nNome: " + nome + "\nHorário: " + horario + "\nTotal de Alunos: " + alunos.size();
    }
}
