package com.everis.agenda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.everis.agenda.modelo.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO extends SQLiteOpenHelper{
    public AlunoDAO(Context context) {
        super(context,"Agenda", null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String command = " CREATE TABLE Alunos(id INTEGER PRIMARY KEY, nome TEXT NOT NULL, telefone TEXT, endereco TEXT, email TEXT, avaliacao real);";
        db.execSQL(command);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String command = "DROP TABLE IF EXISTS Alunos";
        db.execSQL(command);
        onCreate(db);
    }

    public void insertAluno(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("nome", aluno.getNome());
        content.put("endereco", aluno.getEndereco());
        content.put("telefone", aluno.getTelefone());
        content.put("email", aluno.getEmail());
        content.put("avaliacao", aluno.getAvaliacao());

        db.insert("Alunos",null, content);
    }

    public List<Aluno> getAlunos() {
        String command = "SELECT * FROM Alunos";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(command,null);
        List<Aluno> alunoList = new ArrayList<>();
        while (cursor.moveToNext()){
            Aluno aluno  = new Aluno();
            aluno.setId(cursor.getInt(cursor.getColumnIndex("id")));
            aluno.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            aluno.setEndereco(cursor.getString(cursor.getColumnIndex("endereco")));
            aluno.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            aluno.setAvaliacao(cursor.getInt(cursor.getColumnIndex("avaliacao")));
            alunoList.add(aluno);
        }
        cursor.close();
        return alunoList;
    }
}
