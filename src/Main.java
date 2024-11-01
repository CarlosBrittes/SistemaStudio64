import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Aluno> alunos = new ArrayList<>();
    private static List<Turma> turmas = new ArrayList<>();
    private static List<Presenca> presencas = new ArrayList<>();
    private static int alunoCounter = 1;
    private static int presencaCounter = 1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gerenciador de Alunos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 2));

        // Botões para as funcionalidades
        JButton btnAdicionarAluno = new JButton("Adicionar Aluno");
        JButton btnListarAlunos = new JButton("Listar Alunos");
        JButton btnEditarAluno = new JButton("Editar Aluno");
        JButton btnRemoverAluno = new JButton("Remover Aluno");

        JButton btnAdicionarTurma = new JButton("Adicionar Turma");
        JButton btnListarTurmas = new JButton("Listar Turmas");
        JButton btnRemoverTurma = new JButton("Remover Turma");
        JButton btnAdicionarAlunoATurma = new JButton("Adicionar Aluno à Turma");
        JButton btnListarAlunosDaTurma = new JButton("Listar Alunos da Turma");
        JButton btnRegistrarPresencaPorTurma = new JButton("Registrar Presença por Turma");

        buttonPanel.add(btnAdicionarAluno);
        buttonPanel.add(btnListarAlunos);
        buttonPanel.add(btnEditarAluno);
        buttonPanel.add(btnRemoverAluno);
        buttonPanel.add(btnAdicionarTurma);
        buttonPanel.add(btnListarTurmas);
        buttonPanel.add(btnRemoverTurma);
        buttonPanel.add(btnAdicionarAlunoATurma);
        buttonPanel.add(btnListarAlunosDaTurma);
        buttonPanel.add(btnRegistrarPresencaPorTurma);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Ações dos botões
        btnAdicionarAluno.addActionListener(e -> adicionarAluno(textArea));
        btnListarAlunos.addActionListener(e -> listarAlunos(textArea));
        btnEditarAluno.addActionListener(e -> editarAluno(textArea));
        btnRemoverAluno.addActionListener(e -> removerAluno(textArea));

        btnAdicionarTurma.addActionListener(e -> adicionarTurma(textArea));
        btnListarTurmas.addActionListener(e -> listarTurmas(textArea));
        btnRemoverTurma.addActionListener(e -> removerTurma(textArea));
        btnAdicionarAlunoATurma.addActionListener(e -> adicionarAlunoATurma(textArea));
        btnListarAlunosDaTurma.addActionListener(e -> listarAlunosDaTurma(textArea));
        btnRegistrarPresencaPorTurma.addActionListener(e -> registrarPresencaPorTurma(textArea));

        frame.setVisible(true);
    }

    private static void adicionarAluno(JTextArea textArea) {
        String nome = JOptionPane.showInputDialog("Nome:");
        String email = JOptionPane.showInputDialog("Email:");
        String dataNascimento = JOptionPane.showInputDialog("Data de Nascimento (dd/MM/yyyy):");
        Aluno novoAluno = new Aluno(alunoCounter++, nome, email, dataNascimento);
        alunos.add(novoAluno);
        textArea.append("Aluno adicionado:\n" + novoAluno + "\n\n");
        JOptionPane.showMessageDialog(null, "Aluno adicionado com sucesso!");
    }

    private static void listarAlunos(JTextArea textArea) {
        textArea.setText(""); // Limpa a área de texto antes de listar
        textArea.append("Lista de Alunos:\n");
        for (Aluno aluno : alunos) {
            textArea.append(aluno.toString() + "\n-----------------------\n");
        }
        textArea.append("\n");
    }

    private static void editarAluno(JTextArea textArea) {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID do Aluno:"));
        for (Aluno aluno : alunos) {
            if (aluno.getId() == id) {
                String novoNome = JOptionPane.showInputDialog("Novo Nome:", aluno.getNome());
                String novoEmail = JOptionPane.showInputDialog("Novo Email:", aluno.getEmail());
                String novaDataNascimento = JOptionPane.showInputDialog("Nova Data de Nascimento:", aluno.getDataNascimento());
                aluno.setNome(novoNome);
                aluno.setEmail(novoEmail);
                aluno.setDataNascimento(novaDataNascimento);
                textArea.append("Aluno editado:\n" + aluno + "\n\n");
                JOptionPane.showMessageDialog(null, "Aluno editado com sucesso!");
                return;
            }
        }
        textArea.append("Aluno não encontrado.\n\n");
    }

    private static void removerAluno(JTextArea textArea) {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID do Aluno:"));
        alunos.removeIf(aluno -> aluno.getId() == id);
        textArea.append("Aluno removido com sucesso.\n\n");
        JOptionPane.showMessageDialog(null, "Aluno removido com sucesso!");
    }

    private static void adicionarTurma(JTextArea textArea) {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID da Turma:"));
        String nome = JOptionPane.showInputDialog("Nome da Turma:");
        String horario = JOptionPane.showInputDialog("Horário:");
        Turma novaTurma = new Turma(id, nome, horario);
        turmas.add(novaTurma);
        textArea.append("Turma adicionada:\n" + novaTurma + "\n\n");
        JOptionPane.showMessageDialog(null, "Turma adicionada com sucesso!");
    }

    private static void listarTurmas(JTextArea textArea) {
        textArea.setText(""); // Limpa a área de texto antes de listar
        textArea.append("Lista de Turmas:\n");
        for (Turma turma : turmas) {
            textArea.append(turma.toString() + "\n-----------------------\n");
        }
        textArea.append("\n");
    }

    private static void removerTurma(JTextArea textArea) {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID da Turma:"));
        turmas.removeIf(turma -> turma.getId() == id);
        textArea.append("Turma removida com sucesso.\n\n");
        JOptionPane.showMessageDialog(null, "Turma removida com sucesso!");
    }

    private static void adicionarAlunoATurma(JTextArea textArea) {
        int alunoId = Integer.parseInt(JOptionPane.showInputDialog("ID do Aluno:"));
        int turmaId = Integer.parseInt(JOptionPane.showInputDialog("ID da Turma:"));

        Aluno aluno = null;
        for (Aluno a : alunos) {
            if (a.getId() == alunoId) {
                aluno = a;
                break;
            }
        }

        Turma turma = null;
        for (Turma t : turmas) {
            if (t.getId() == turmaId) {
                turma = t;
                break;
            }
        }

        if (aluno != null && turma != null) {
            turma.adicionarAluno(aluno);
            textArea.append("Aluno " + aluno.getNome() + " adicionado à turma " + turma.getNome() + ".\n");
            JOptionPane.showMessageDialog(null, "Aluno adicionado à turma com sucesso!");
        } else {
            textArea.append("Aluno ou Turma não encontrados.\n");
        }
    }

    private static void listarAlunosDaTurma(JTextArea textArea) {
        int turmaId = Integer.parseInt(JOptionPane.showInputDialog("ID da Turma:"));

        for (Turma turma : turmas) {
            if (turma.getId() == turmaId) {
                textArea.setText("Alunos na turma " + turma.getNome() + ":\n");
                for (Aluno aluno : turma.getAlunos()) {
                    textArea.append(aluno.getNome() + "\n");
                }
                return;
            }
        }
        textArea.append("Turma não encontrada.\n");
    }

    private static void registrarPresencaPorTurma(JTextArea textArea) {
        int turmaId = Integer.parseInt(JOptionPane.showInputDialog("ID da Turma:"));

        for (Turma turma : turmas) {
            if (turma.getId() == turmaId) {
                StringBuilder presenca = new StringBuilder();
                presenca.append("Registrar presença para a turma ").append(turma.getNome()).append(":\n");
                for (Aluno aluno : turma.getAlunos()) {
                    String status = JOptionPane.showInputDialog("Presença de " + aluno.getNome() + "? (P/F)");
                    boolean presente = status.equalsIgnoreCase("P");
                    String data = LocalDate.now().toString(); // Puxando a data do sistema operacional
                    Presenca novaPresenca = new Presenca(presencaCounter++, aluno.getId(), data, presente);
                    presencas.add(novaPresenca);
                    presenca.append(aluno.getNome()).append(" - ").append(presente ? "Presente" : "Falta").append("\n");
                }
                textArea.append(presenca.toString());
                JOptionPane.showMessageDialog(null, "Presença registrada com sucesso!");
                return;
            }
        }
        textArea.append("Turma não encontrada.\n");
    }
}
