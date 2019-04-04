package com.example.josepablo.palindromo;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText Palabra;
    Button Aceptar, info;
    TextView Respuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Palabra = (EditText) findViewById(R.id.Palabra);
        Aceptar = (Button) findViewById(R.id.Aceptar);
        Respuesta = (TextView) findViewById(R.id.Respuesta);
        info = (Button) findViewById(R.id.info);

        Aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validar()){
                    //agregar significado y ejemplos
                    //modificar la interfaz

                    String palabra = Palabra.getText().toString();

                    if (palindromo(palabra)){
                        Respuesta.setText(palabra + " Es un Palindromo");
                    } else {
                        Respuesta.setText(palabra + " No es un Palindromo");
                    }
                }
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogoInfo();
            }
        });
    }

    static boolean palindromo(String palabra) {
        //Quitar espacios y convertirlo a minusculas para hacer las comparaciones
        String modificado = palabra.replaceAll(" ","").toLowerCase();
        int i=0;
        while (i < modificado.length() / 2)
        {
            if (modificado.charAt(i) != modificado.charAt(modificado.length() -1 -i))
                return false;
            i++;
        }
        return true;
    }

    public boolean validar(){
        String palabra = Palabra.getText().toString();
        if(palabra.isEmpty()){
            Palabra.setError("Ingresar una palabra o frase");
            return false;
        } else {
            return true;
        }
    }

    private void DialogoInfo (){
        //Diseño Dialogo
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_info);

        Button btn_dialog = (Button) dialog.findViewById(R.id.btn_dialog);

        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
