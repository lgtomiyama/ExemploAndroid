package com.everis.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.everis.agenda.dao.AlunoDAO;
import com.everis.agenda.helpers.FormularioHelper;
import com.everis.agenda.modelo.Aluno;

import java.util.List;

public class FormularioActivity extends AppCompatActivity {

    private FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        Button btnEnviar = (Button) findViewById(R.id.formulario_btnSalvar);
        helper = new FormularioHelper(this);

        btnEnviar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(FormularioActivity.this,"Alo", Toast.LENGTH_SHORT).show();
                Intent intenttoLista = new Intent(FormularioActivity.this,ListaAlunosActivity.class);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_formulario_ok:

                Intent intenttoLista = new Intent(FormularioActivity.this,ListaAlunosActivity.class);
                Aluno aluno = helper.getAluno();

                AlunoDAO dao = new AlunoDAO(this);
                dao.insertAluno(aluno);
                dao.close();

                Toast.makeText(FormularioActivity.this,aluno.getNome(), Toast.LENGTH_SHORT).show();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
