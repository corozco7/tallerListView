package com.example.android.listview;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Cono extends AppCompatActivity {

    private EditText txtRadio, txtAltura;
    private Resources recursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cono);
        txtRadio = findViewById(R.id.txtRadio);
        txtAltura = findViewById(R.id.txtAltura);
        recursos = this.getResources();
    }

    public void calcular(View v){
        if (validar()) {
            double radio, altura, resultado;
            radio = Integer.parseInt(txtRadio.getText().toString());
            altura = Integer.parseInt(txtAltura.getText().toString());
            resultado = Metodos.volumenCono(radio, altura);
            Toast.makeText(this, recursos.getString(R.string.mensaje_volumen)
                    + " " + resultado, Toast.LENGTH_SHORT).show();
            borrar();
        }
    }

    public boolean validar(){
        if (txtRadio.getText().toString().isEmpty()){
            txtRadio.setError(recursos.getString(R.string.error_uno));
            txtRadio.setText("");
            txtAltura.setText("");
            return false;
        }
        if (txtAltura.getText().toString().isEmpty()){
            txtAltura.setError(recursos.getString(R.string.error_uno));
            txtRadio.setText("");
            txtAltura.setText("");
            return false;
        }
        int com = Integer.parseInt(txtRadio.getText().toString());
        int com1 = Integer.parseInt(txtAltura.getText().toString());
        if (com <= 0){
            txtRadio.setError(recursos.getString(R.string.error_dos));
            txtRadio.setText("");
            txtAltura.setText("");
            return false;
        }
        if (com1 <= 0){
            txtAltura.setError(recursos.getString(R.string.error_dos));
            txtRadio.setText("");
            txtAltura.setText("");
            return false;
        }
        return true;
    }

    public void limpiar (View v){
        borrar();
    }

    private void borrar(){
        txtRadio.setText("");
        txtAltura.setText("");
    }

}
