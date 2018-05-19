package com.fa7.calculadora;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnSoma, btnSubtracao;
    Button btnMultiplicacao, btnDivisao, btnLimpar, btnResultado, btnHistorico;
    EditText txtResultado;

    Double primeiroNumero;
    String operacao;
    String strResultado = "";
    ArrayList<String> resultados = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResultado = (EditText) findViewById(R.id.txtResultado);

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);

        btnSoma = (Button) findViewById(R.id.btnSoma);
        btnSubtracao = (Button) findViewById(R.id.btnSubtracao);
        btnMultiplicacao = (Button) findViewById(R.id.btnMultiplicacao);
        btnDivisao = (Button) findViewById(R.id.btnDivisao);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);
        btnResultado = (Button) findViewById(R.id.btnResultado);
        btnHistorico = (Button) findViewById(R.id.btnHistorico);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResultado.setText(txtResultado.getText().toString().concat("0"));
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResultado.setText(txtResultado.getText().toString().concat("1"));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResultado.setText(txtResultado.getText().toString().concat("2"));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResultado.setText(txtResultado.getText().toString().concat("3"));
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResultado.setText(txtResultado.getText().toString().concat("4"));
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResultado.setText(txtResultado.getText().toString().concat("5"));
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResultado.setText(txtResultado.getText().toString().concat("6"));
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResultado.setText(txtResultado.getText().toString().concat("7"));
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResultado.setText(txtResultado.getText().toString().concat("8"));
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResultado.setText(txtResultado.getText().toString().concat("9"));
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResultado.setText("");
            }
        });

        btnSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                primeiroNumero = Double.parseDouble(txtResultado.getText().toString());
                operacao = " + ";
                txtResultado.setText("");
            }
        });

        btnSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                primeiroNumero = Double.parseDouble(txtResultado.getText().toString());
                operacao = " - ";
                txtResultado.setText("");
            }
        });

        btnMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                primeiroNumero = Double.parseDouble(txtResultado.getText().toString());
                operacao = " * ";
                txtResultado.setText("");
            }
        });

        btnDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                primeiroNumero = Double.parseDouble(txtResultado.getText().toString());
                operacao = " / ";
                txtResultado.setText("");
            }
        });

        btnHistorico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HistoricoActivity.class);
                intent.putExtra("resultados", resultados);
                startActivity(intent);
            }
        });
    }

    public void onClickSalvar(View view){

        Double vrResultado = 0.0;
        Double segundoNumero = Double.parseDouble(txtResultado.getText().toString());

        switch (operacao) {
            case " + ":
                vrResultado = primeiroNumero + segundoNumero;
                break;
            case " - ":
                vrResultado = primeiroNumero - segundoNumero;
                break;
            case " * ":
                vrResultado = primeiroNumero * segundoNumero;
                break;
            case " / ":
                vrResultado = primeiroNumero / segundoNumero;
                break;
            default:
                vrResultado = 0.0;
        }

        strResultado = primeiroNumero.toString() + operacao + segundoNumero.toString() + " = " + vrResultado.toString();

        txtResultado.setText(strResultado);
        resultados.add(strResultado);

        GravaDados.saveText(this, "CalcResult", GravaDados.getText(this, "CalcResult") +  strResultado + "\n");
    }
}
