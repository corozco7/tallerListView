package com.example.android.listview;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Esfera extends AppCompatActivity {

    private EditText txtRadio;
    private Resources recursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esfera);
        txtRadio = findViewById(R.id.txtRadio);
        recursos = this.getResources();
    }

    public void calcular(View v){
        if (validar()) {
            double radio, resultado;
            radio = Integer.parseInt(txtRadio.getText().toString());
            resultado = Metodos.volumenEsfera(radio);
            Operacion o = new Operacion(recursos.getString(R.string.volumen_operacion)+ " "
                    + recursos.getString(R.string.esfera),recursos.getString(R.string.radio)
                    + " " + radio,""+resultado);
            o.guardar();
            Toast.makeText(this, recursos.getString(R.string.mensaje_volumen)
                    + " " + resultado, Toast.LENGTH_SHORT).show();
            borrar();
        }
    }

    public boolean validar(){
        if (txtRadio.getText().toString().isEmpty()){
            txtRadio.setError(recursos.getString(R.string.error_uno));
            txtRadio.setText("");
            return false;
        }
        int com = Integer.parseInt(txtRadio.getText().toString());
        if (com <= 0){
            txtRadio.setError(recursos.getString(R.string.error_dos));
            txtRadio.setText("");
            return false;
        }
        return true;
    }

    public void limpiar (View v){
        borrar();
    }

    private void borrar(){
        txtRadio.setText("");
    }

}
