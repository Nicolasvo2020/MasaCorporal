package com.example.masacorporal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {
    EditText etNombre, etTalla, etPeso;
    TextView txtResultado, txtResultado1;
    RadioButton rbVaron, rbMujer;
    Button btnCalcular, btnLimpiar, btnSalir, btnConsultar;
    RadioGroup rgGenero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombre = findViewById(R.id.etNombre); etNombre.setFocusableInTouchMode(true); etNombre.requestFocus();
        etTalla = findViewById(R.id.etTalla);
        etPeso = findViewById(R.id.etPeso);
        txtResultado = findViewById(R.id.txtResultado);
        txtResultado1 = findViewById(R.id.txtResultado1);
        rbVaron = findViewById(R.id.rbVaron);
        rbMujer = findViewById(R.id.rbMujer);
        rgGenero = findViewById(R.id.rgGenero);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnSalir = findViewById(R.id.btnSalir);
        btnConsultar = findViewById(R.id.btnConsultar);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double calcular, talla, peso;
                String mensaje = null;
                talla = Double.parseDouble(etTalla.getText().toString());
                peso = Double.parseDouble(etPeso.getText().toString());
                if (rbVaron.isChecked() == true) {
                        calcular = peso / Math.pow(talla, 2);
                        if (calcular < 21.00)
                            mensaje = String.valueOf("Peso Muy Grave");
                        else if (calcular < 26.99)
                            mensaje = String.valueOf("Peso Grave");
                        else if (calcular < 31.49)
                            mensaje = String.valueOf("Bajo Peso");
                        else if (calcular < 36.99)
                            mensaje = String.valueOf("Peso Normal");
                        else if (calcular < 41.99)
                            mensaje = String.valueOf("Sobre Peso");
                        else if (calcular < 45.99)
                            mensaje = String.valueOf("Obesidad Grado I");
                        else if (calcular < 50.99)
                            mensaje = String.valueOf("Obesidad Grado II");
                        else if (calcular > 55.00)
                            mensaje = String.valueOf("Obesidad Grado III");

                        txtResultado.setText(etNombre.getText() + " Su IMC con respecto a su peso " + etPeso.getText() + " es de " + String.format("%.2f", calcular));
                        txtResultado1.setText("Categoria de IMC " + mensaje.toString());
                    makeText(MainActivity.this, "Genero: Varon", LENGTH_SHORT).show();
                }
                else if (rbMujer.isChecked() == true) {
                    calcular = peso / Math.pow(talla, 2);
                    if (calcular < 16.00)
                        mensaje = String.valueOf("Peso bajo Muy Grave");
                    else if (calcular < 16.99)
                        mensaje = String.valueOf("Peso bajo Grave");
                    else if (calcular < 18.49)
                        mensaje = String.valueOf("Bajo Peso");
                    else if (calcular < 24.99)
                        mensaje = String.valueOf("Peso Normal");
                    else if (calcular < 29.99)
                        mensaje = String.valueOf("Sobre Peso");
                    else if (calcular < 34.99)
                        mensaje = String.valueOf("Obesidad Grado I");
                    else if (calcular < 39.99)
                        mensaje = String.valueOf("Obesidad Grado II");
                    else if (calcular > 40.00)
                        mensaje = String.valueOf("Obesidad Grado III");

                    txtResultado.setText(etNombre.getText() + " Su IMC con respecto a su peso " + etPeso.getText() + " es de " + String.format("%.2f", calcular));
                    txtResultado1.setText("Categoria de IMC " + mensaje.toString());
                    makeText(MainActivity.this, "Genero: Mujer", LENGTH_SHORT).show();
                }
                else
                    makeText(MainActivity.this, "Seleccione Genro", LENGTH_SHORT).show();
                }
                //if (rbMujer.isChecked() == true) {
                    //Toast.makeText(this,"ERES MUJER" , Toast.LENGTH_SHORT).show();

                //}
                /*else if (rbVaron.isChecked() == true){
                    //Toast.makeText(this,"ERES VARON",Toast.LENGTH_SHORT).show();
                    calcular = peso / Math.pow(talla, 2);
                    if (calcular < 16.00)
                        mensaje = String.valueOf("Peso Muy Grave");
                    else if (calcular < 16.99)
                        mensaje = String.valueOf("Peso Grave");
                    else if (calcular < 18.49)
                        mensaje = String.valueOf("Bajo Peso");
                    else if (calcular < 24.99)
                        mensaje = String.valueOf("Peso Normal");
                    else if (calcular < 29.99)
                        mensaje = String.valueOf("Sobre Peso");
                    else if (calcular < 34.99)
                        mensaje = String.valueOf("Obesidad Grado 1");
                    else if (calcular < 39.99)
                        mensaje = String.valueOf("Obesidad Grado II");
                    else if (calcular > 40.00)
                        mensaje = String.valueOf("Obesidad Grado III");

                    txtResultado.setText(etNombre.getText() + " Su IMC con respecto a su peso " + etPeso.getText() + " es de " + String.format("%.2f", calcular));
                    txtResultado1.setText("Categoria de IMC " + mensaje.toString());
                }
                else {
                    //Toast.makeText(this,"No eligio género", LENGTH_SHORT).show();
                    Toast.makeText(this, "No elegido Genero", LENGTH_LONG).show();
                }*/


        });
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }

            private void limpiar() {
                etNombre.setText("");
                etTalla.setText("");
                etPeso.setText("");
            }
        });
        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent. ACTION_VIEW,
                        Uri.parse ("https://www.google.com/search?q=categorias+de+indice+de+masa+corporal&oq=categorias+de+Indice+&aqs=chrome.1.69i57j0j0i22i30l3.16527j0j4&sourceid=chrome&ie=UTF-8"));
                startActivity(intent);
            }
        });
    }

    public void salir(View view) {
        finish();
    }

}