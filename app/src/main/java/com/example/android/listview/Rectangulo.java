package com.example.android.listview;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Rectangulo extends AppCompatActivity {

    private EditText txtBase, txtAltura;
    private Resources recursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);
        txtBase = findViewById(R.id.txtBase);
        txtAltura = findViewById(R.id.txtAltura);
        recursos = this.getResources();
    }

    public void calcular(View v){
        if (validar()) {
            double base, altura, resultado;
            base = Integer.parseInt(txtBase.getText().toString());
            altura = Integer.parseInt(txtAltura.getText().toString());
            resultado = Metodos.areaRectangulo(base, altura);
            Operacion o = new Operacion(recursos.getString(R.string.area_operacion)+ " "
                    + recursos.getString(R.string.rectangulo),recursos.getString(R.string.base)
                    + " " +base+" " + recursos.getString(R.string.altura) + " " + altura,
                    ""+resultado);
            o.guardar();
            Toast.makeText(this, recursos.getString(R.string.mensaje_area)
                    + " " + resultado, Toast.LENGTH_SHORT).show();
            borrar();
        }
    }

    public boolean validar(){
        if (txtBase.getText().toString().isEmpty()){
            txtBase.setError(recursos.getString(R.string.error_uno));
            txtBase.setText("");
            txtAltura.setText("");
            return false;
        }
        if (txtAltura.getText().toString().isEmpty()){
            txtAltura.setError(recursos.getString(R.string.error_uno));
            txtBase.setText("");
            txtAltura.setText("");
            return false;
        }
        int com = Integer.parseInt(txtBase.getText().toString());
        int com1 = Integer.parseInt(txtAltura.getText().toString());
        if (com <= 0){
            txtBase.setError(recursos.getString(R.string.error_dos));
            txtBase.setText("");
            txtAltura.setText("");
            return false;
        }
        if (com1 <= 0){
            txtAltura.setError(recursos.getString(R.string.error_dos));
            txtBase.setText("");
            txtAltura.setText("");
            return false;
        }
        return true;
    }

    public void limpiar (View v){
        borrar();
    }

    private void borrar(){
        txtBase.setText("");
        txtAltura.setText("");
    }
}
