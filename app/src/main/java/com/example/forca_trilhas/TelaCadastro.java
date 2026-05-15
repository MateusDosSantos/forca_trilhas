package com.example.forca_trilhas;

import android.annotation.SuppressLint;
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

public class TelaCadastro extends AppCompatActivity implements View.OnClickListener {
    private Button btnCadastro, btnListar;
    private EditText caixaPalavra;
    private RadioGroup grupo;
    private String categoriaSelecionada;


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
                Toast.makeText(TelaCadastro.this, categoriaSelecionada, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}