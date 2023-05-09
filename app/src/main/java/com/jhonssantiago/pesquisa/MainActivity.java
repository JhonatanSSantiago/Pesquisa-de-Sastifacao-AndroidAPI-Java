package com.jhonssantiago.pesquisa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText nomeTxt;
    private AutoCompleteTextView autoCompleteTextView;
    private RatingBar estrelas;
    private ImageView imagem;
    private TextView escolheTxt;
    private Button button;
    private int op;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nomeTxt = findViewById(R.id.nome);
        autoCompleteTextView = findViewById(R.id.autoCompleteCidades);
        estrelas = findViewById(R.id.nivel);
        imagem = findViewById(R.id.img);
        escolheTxt = findViewById(R.id.escolha);
        button = findViewById(R.id.enviar);

        List<String> cidades = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.cidades)));

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,cidades);
        autoCompleteTextView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(getActivity()).create();
                dialog.setTitle("Avaliação");
                dialog.setMessage("Nome: "+nomeTxt.getText()+"\nCidade: "+autoCompleteTextView.getText() +"\nAvaliação: "+escolheTxt.getText()+" "+op+" Estrelas");
                dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Ok", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.show();

            }
        });
        estrelas.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                op = (int) rating;
                switch (op) {
                    case 1 :
                        imagem.setImageDrawable(getDrawable(R.drawable.triste));
                        escolheTxt.setText("RUIM");
                        escolheTxt.setTextColor(getColor(R.color.red));
                        imagem.setVisibility(View.VISIBLE);
                        escolheTxt.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        imagem.setImageDrawable(getDrawable(R.drawable.indiferente));
                        escolheTxt.setText("INDIFERENTE");
                        escolheTxt.setTextColor(getColor(R.color.blue));
                        imagem.setVisibility(View.VISIBLE);
                        escolheTxt.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        imagem.setImageDrawable(getDrawable(R.drawable.feliz));
                        escolheTxt.setText("BOA");
                        escolheTxt.setTextColor(getColor(R.color.green));
                        imagem.setVisibility(View.VISIBLE);
                        escolheTxt.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
    }

    public Context getActivity(){ return this; };
}