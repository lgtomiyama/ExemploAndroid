package com.everis.agenda.helpers;

import android.widget.EditText;
import android.widget.RatingBar;

import com.everis.agenda.FormularioActivity;
import com.everis.agenda.R;
import com.everis.agenda.modelo.Aluno;

public class FormularioHelper {
    private final EditText nome;
    private final EditText endereco;
    private final EditText email;
    private final EditText telefone;
    private final RatingBar avaliacao;
    public FormularioHelper(FormularioActivity activity){
        nome = (EditText)activity.findViewById(R.id.formulario_Nome);
        endereco = (EditText)activity.findViewById(R.id.formulario_Enderco);
        telefone = (EditText)activity.findViewById(R.id.formulario_Telefone);
        email = (EditText)activity.findViewById(R.id.formulario_email);
        avaliacao = (RatingBar)activity.findViewById(R.id.formulario_Avaliacao);
    }

    public Aluno getAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome(nome.getText().toString());
        aluno.setEndereco(endereco.getText().toString());
        aluno.setTelefone(telefone.getText().toString());
        aluno.setEmail(email.getText().toString());
        aluno.setAvaliacao(avaliacao.getProgress());
        return aluno;
    }
}
