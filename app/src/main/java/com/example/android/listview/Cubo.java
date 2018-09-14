package com.example.android.listview;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Cubo extends AppCompatActivity {

    private EditText txtLado;
    private Resources recursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cubo);
        txtLado = findViewById(R.id.txtLado);
        recursos = this.getResources();
    }

    public void calcular(View v){
        if (validar()) {
            double lado, resultado;
            lado = Integer.parseInt(txtLado.getText().toString());
            resultado = Metodos.volumenCubo(lado);
            Operacion o = new Operacion(recursos.getString(R.string.volumen_operacion)+ " "
                    + recursos.getString(R.string.cubo),recursos.getString(R.string.lado)
                    + " " + lado,""+resultado);
            o.guardar();
            Toast.makeText(this, recursos.getString(R.string.mensaje_volumen)
                    + " " + resultado, Toast.LENGTH_SHORT).show();
            borrar();
        }
    }

    public boolean validar(){
        if (txtLado.getText().toString().isEmpty()){
            txtLado.setError(recursos.getString(R.string.error_uno));
            txtLado.setText("");
            return false;
        }
        int com = Integer.parseInt(txtLado.getText().toString());
        if (com <= 0){
            txtLado.setError(recursos.getString(R.string.error_dos));
            txtLado.setText("");
            return false;
        }
        return true;
    }

    public void limpiar (View v){
        borrar();
    }

    private void borrar(){
        txtLado.setText("");
    }

}
