public class Presenca {
    private int id;
    private int alunoId;
    private String data;
    private boolean presente;

    public Presenca(int id, int alunoId, String data, boolean presente) {
        this.id = id;
        this.alunoId = alunoId;
        this.data = data;
        this.presente = presente;
    }

    // Getters
    public int getId() { return id; }
    public int getAlunoId() { return alunoId; }
    public String getData() { return data; }
    public boolean isPresente() { return presente; }

    @Override
    public String toString() {
        return "ID: " + id + "\nAluno ID: " + alunoId + "\nData: " + data + "\nPresente: " + presente;
    }
}
