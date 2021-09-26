package org.itiud.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private Button btnSalir, btnReset, btnAcep;
    private RadioButton btnRe1, btnRe2, btnRe3, btnRe4;
    private TextView textViewPregunta,txtPremio;
    private int respuesta, cont=0, valorPremio=50000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textViewPregunta = (TextView) findViewById(R.id.txtPregunta);
        this.btnRe1 = (RadioButton) findViewById(R.id.btnR1);
        this.btnRe2 = (RadioButton) findViewById(R.id.btnR2);
        this.btnRe3 = (RadioButton) findViewById(R.id.btnR3);
        this.btnRe4 = (RadioButton) findViewById(R.id.btnR4);
        this.btnSalir = (Button) findViewById(R.id.btnSalir);
        this.btnReset = (Button) findViewById(R.id.btnReiniciar);
        this.btnAcep = (Button) findViewById(R.id.btnAceptar);
        this.txtPremio = (TextView) findViewById(R.id.txtNivelPremio);


        this.empezar();
        this.txtPremio.setText("Pregunta por: $ "+calcuPremio());

        this.btnAcep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificar();
            }
        });

        this.btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        this.btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
                overridePendingTransition(0,0);
            }
        });

    }

    public int randomSinUsados(Random rnd, int start, int end, int... exclude) {
        int random = start + rnd.nextInt(end - start + 1 - exclude.length);
        for (int ex : exclude) {
            if (random < ex) {
                break;
            }
            random++;
        }
        return random;
    }


    public void verificar() {
        if (this.btnRe1.isChecked() && respuesta == 1){
            cont++;
            Toast.makeText(getApplicationContext(), "Correcto", Toast.LENGTH_SHORT).show();
            empezar();
            this.txtPremio.setText("Pregunta por: $ "+calcuPremio());
        } else if (this.btnRe2.isChecked() && respuesta == 2) {
            cont++;
                Toast.makeText(getApplicationContext(), "Correcto", Toast.LENGTH_SHORT).show();
            empezar();
            this.txtPremio.setText("Pregunta por: $ "+calcuPremio());
        } else if (this.btnRe3.isChecked() && respuesta == 3) {
            cont++;
            Toast.makeText(getApplicationContext(), "Correcto", Toast.LENGTH_SHORT).show();
            empezar();
            this.txtPremio.setText("Pregunta por: $ "+calcuPremio());
        }else if (this.btnRe4.isChecked() && respuesta == 4) {
            cont++;
            Toast.makeText(getApplicationContext(), "Correcto", Toast.LENGTH_SHORT).show();
            empezar();
            this.txtPremio.setText("Pregunta por: $ "+calcuPremio());
        }else{
            Toast.makeText(getApplicationContext(), "Incorrecto", Toast.LENGTH_SHORT).show();
            this.finish();
        }
    }

    public int calcuPremio(){
        this.valorPremio = this.valorPremio + (cont * (12/100));
        return valorPremio;
    }

    public void empezar() {
        Random rnd = new Random();
        int niv = rnd.nextInt(4-1)+1;
        int numP = rnd.nextInt(5 - 1)+1;
        if (niv == 1) {
            if (numP == 1 ) {
                this.textViewPregunta.setText("¿En qué continente se encuentra Suecia?");
                this.btnRe1.setText("Asia");
                this.btnRe2.setText("Europa");
                this.btnRe3.setText("Africa");
                this.btnRe4.setText("America");
                respuesta = 2;
            } else if (numP == 2) {
                this.textViewPregunta.setText("¿Qué colores tiene la bandera de Gales?");
                this.btnRe1.setText("Azul/Rojo/Blanco");
                this.btnRe2.setText("Negro/Amarillo/Rojo");
                this.btnRe3.setText("Rojo/Blanco/Verde");
                this.btnRe4.setText("Verde/Morado/Blanco");
                respuesta = 3;
            } else if (numP == 3) {
                this.textViewPregunta.setText("¿Cúal producto es el más cultivado en Guatemala?");
                this.btnRe1.setText("Pepino");
                this.btnRe2.setText("Tomate");
                this.btnRe3.setText("Café");
                this.btnRe4.setText("Calabaza");
                respuesta = 3;
            }else if (numP == 4 ) {
                this.textViewPregunta.setText("¿Cúal es el país más grande del mundo?");
                this.btnRe1.setText("Rusia");
                this.btnRe2.setText("Canadá");
                this.btnRe3.setText("Brasil");
                this.btnRe4.setText("Afganistán");
                respuesta = 1;
            } else if (numP == 5 ) {
                this.textViewPregunta.setText("¿Cual es el primer metal usado por el hombre?");
                this.btnRe1.setText("Plomo");
                this.btnRe2.setText("Plata");
                this.btnRe3.setText("Oro");
                this.btnRe4.setText("Cobre");
                respuesta =4;
            }
        }else if(niv == 2){
            if (numP == 1) {
                this.textViewPregunta.setText("¿Qué animal es incapaz de vomitar?");
                this.btnRe1.setText("Perro");
                this.btnRe2.setText("Rana");
                this.btnRe3.setText("Jirafa");
                this.btnRe4.setText("Ballena");
                respuesta = 2;
            } else if (numP == 2) {
                this.textViewPregunta.setText("Animal marino más veloz.");
                this.btnRe1.setText("Marlín Negro");
                this.btnRe2.setText("Calamar");
                this.btnRe3.setText("Morena");
                this.btnRe4.setText("Cigala");
                respuesta = 1;
            } else if (numP == 3) {
                this.textViewPregunta.setText("¿De qué color es la piel del oso polar?");
                this.btnRe1.setText("Amarilla");
                this.btnRe2.setText("Negra");
                this.btnRe3.setText("Blanca");
                this.btnRe4.setText("Café");
                respuesta = 2;
            }else if (numP == 4) {
                this.textViewPregunta.setText("¿De donde son originarios los Canguros?");
                this.btnRe1.setText("Australia");
                this.btnRe2.setText("Haití");
                this.btnRe3.setText("India");
                this.btnRe4.setText("Alemanía");
                respuesta = 1;
            } else if (numP == 5) {
                this.textViewPregunta.setText("¿De qué especie es un Nasalis Larvatus?");
                this.btnRe1.setText("Arañas");
                this.btnRe2.setText("Cangrejos");
                this.btnRe3.setText("Lombrices");
                this.btnRe4.setText("Monos");
                respuesta =4;
            }
        }else if(niv == 3){
            if (numP == 1) {
                this.textViewPregunta.setText("¿Como se llama el martillo de Thor?");
                this.btnRe1.setText("Vanir");
                this.btnRe2.setText("Mjolnir");
                this.btnRe3.setText("Aesir");
                this.btnRe4.setText("Norn");
                respuesta = 2;
            } else if (numP == 2) {
                this.textViewPregunta.setText("¿De qué está hecho el escudo del Capitán América?");
                this.btnRe1.setText("Adamantium");
                this.btnRe2.setText("Vibranio");
                this.btnRe3.setText("Prometeo");
                this.btnRe4.setText("Carbonadio");
                respuesta = 2;
            } else if (numP == 3) {
                this.textViewPregunta.setText("¿Cual es el verdadero nombre de la pantera negra?");
                this.btnRe1.setText("T'Challa");
                this.btnRe2.setText("M'Baku");
                this.btnRe3.setText("N'Jadaka");
                this.btnRe4.setText("N'Jobu");
                respuesta = 1;
            }else if (numP == 4) {
                this.textViewPregunta.setText("Antes de convertirse en visión,¿Como se llama la inteligencia artificial de Iron Man?");
                this.btnRe1.setText("HOMERO");
                this.btnRe2.setText("JARVIS");
                this.btnRe3.setText("ALFREDO");
                this.btnRe4.setText("MARVIN");
                respuesta = 2;
            } else if (numP == 5) {
                this.textViewPregunta.setText("¿En que año se estreno la primera pelicula de Iron Man?");
                this.btnRe1.setText("2015");
                this.btnRe2.setText("2007");
                this.btnRe3.setText("2008");
                this.btnRe4.setText("2010");
                respuesta =3;
            }
        }else if(niv == 4){
            if (numP == 1) {
                this.textViewPregunta.setText("¿Quien es el director del Gran Combo de Puerto Rico?");
                this.btnRe1.setText("Angelo Torres");
                this.btnRe2.setText("Celso Clemente");
                this.btnRe3.setText("Rafael Ithier");
                this.btnRe4.setText("Joe Gonzales");
                respuesta = 3;
            } else if (numP == 2) {
                this.textViewPregunta.setText("¿Como era el nombre de pila de Hector Lavoe?");
                this.btnRe1.setText("Hector Juan Perez Martinez");
                this.btnRe2.setText("Hugo Hector Perez");
                this.btnRe3.setText("Hector Martinez Perez");
                this.btnRe4.setText("Hector Rafael Perez Martinez");
                respuesta =1;
            } else if (numP == 3) {
                this.textViewPregunta.setText("¿Cual fue el director de la Fania Records?");
                this.btnRe1.setText("Rafael Ithier");
                this.btnRe2.setText("José Jomar");
                this.btnRe3.setText("Paco Pépe");
                this.btnRe4.setText("Jhonny Pacheco");
                respuesta = 4;
            }else if (numP == 4) {
                this.textViewPregunta.setText("¿En qué país nació Celia Cruz?");
                this.btnRe1.setText("Cuba");
                this.btnRe2.setText("Honduras");
                this.btnRe3.setText("Colombia");
                this.btnRe4.setText("Puerto Rico");
                respuesta = 1;
            } else if (numP == 5) {
                this.textViewPregunta.setText("¿Que era Roberto Roena?");
                this.btnRe1.setText("Bongocero");
                this.btnRe2.setText("Cantante");
                this.btnRe3.setText("Pianista");
                this.btnRe4.setText("Baterista");
                respuesta =1;
            }
        }
    }
}