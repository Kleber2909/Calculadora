package com.fa7.calculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoricoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        Intent intent = getIntent();
        ArrayList<String> lista = intent.getStringArrayListExtra("resultados");

        ListView lvHistorico = (ListView)findViewById(R.id.lvHistorico);

        ArrayAdapter<String> adapterResultados = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        lvHistorico.setAdapter(adapterResultados);

        TextView txtTodoHistorico = (TextView)findViewById(R.id.txtTodoHistorico);
        txtTodoHistorico.setText(GravaDados.getText(this, "CalcResult"));

    }
}
