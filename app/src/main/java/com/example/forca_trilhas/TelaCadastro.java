package com.example.forca_trilhas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class TelaCadastro extends AppCompatActivity implements View.OnClickListener {
    private Button btnCadastro, btnListar;
    private EditText caixaPalavra;
    private RadioGroup grupo;
    private String categoriaSelecionada, palavraDigitada;
    private BD bd;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnCadastro = findViewById(R.id.button2);
        btnCadastro.setOnClickListener(this);
        btnListar = findViewById(R.id.button3);
        btnListar.setOnClickListener(this);
        caixaPalavra = findViewById(R.id.editTextText);
        categoriaSelecionada = "Objeto Escolar";
        grupo = findViewById(R.id.id_grupo);
        grupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup radioGroup, int i) {
                RadioButton k = findViewById(i);                k.setId(i);
                Toast.makeText(TelaCadastro.this, k.getText().toString(), Toast.LENGTH_SHORT).show();


                if(radioGroup == grupo){
                    if(i == R.id.radioButton)
                    {
                        categoriaSelecionada = "Frutas";
                    }
                    if(i == R.id.radioButton2)
                    {
                        categoriaSelecionada = "Ferramentas";
                    }
                    if(i == R.id.radioButton3)
                    {
                        categoriaSelecionada = "Objeto Escolar";
                    }
                    if(i == R.id.radioButton4)
                    {
                        categoriaSelecionada = "Eletrodoméstico";
                    }
                    if(i == R.id.radioButton5)
                    {
                        categoriaSelecionada = "Esportes";
                    }
                }
               // Toast.makeText(TelaCadastro.this, categoriaSelecionada, Toast.LENGTH_SHORT).show();
            }
        });
        bd = new BD(TelaCadastro.this);
    }

    @Override
    public void onClick(View view) {
         if(view == btnCadastro){
             boolean verificaRadio = false;
             RadioButton r1 = findViewById(R.id.radioButton);
             RadioButton r2 = findViewById(R.id.radioButton2);
             RadioButton r3 = findViewById(R.id.radioButton3);
             RadioButton r4 = findViewById(R.id.radioButton4);
             RadioButton r5 = findViewById(R.id.radioButton5);
             if(r1.isChecked()||r2.isChecked()||r3.isChecked()||r4.isChecked()||r5.isChecked()){
                 verificaRadio = true;
             }
             boolean verificaTexto = false;
             String temporaria = caixaPalavra.getText().toString();
             if(!temporaria.isEmpty())
             {
                 verificaTexto = true;
             }
             if(verificaRadio && verificaTexto)
             {
                 palavraDigitada = caixaPalavra.getText().toString();
                 Palavra p = new Palavra();
                 p.setNome(palavraDigitada);
                 p.setCategoria(categoriaSelecionada);
                 bd.salvarPalavra(p);
                 caixaPalavra.setText("");
                 Toast.makeText(this, "Salvo!", Toast.LENGTH_SHORT).show();
             }
             else{
                 if(!verificaRadio){
                     Toast.makeText(this, "Escolha a Categoaria", Toast.LENGTH_SHORT).show();
                 }
                 if(!verificaTexto){
                     Toast.makeText(this, "Digite a palavra", Toast.LENGTH_SHORT).show();

                 }
             }

         }
        if(view == btnListar){
            startActivity(new Intent(this, TelaRecycler.class));
        }

    }
}