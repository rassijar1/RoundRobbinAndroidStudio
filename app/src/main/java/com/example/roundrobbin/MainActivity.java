package com.example.roundrobbin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edt1,edt2,edt3,edt4,edt5,quantum;
    private TextView resultadoproceso, resultadotiempo;
    private Button borrar;
    int i, auxq, cont =0, aux, contq =0;
    float tpespera =0, tprespuesta =0;
    int trafaga[]= new int[5];
    int tespera[]= new int[5];
    int trespuesta[]= new int[5];
    int auxtr[]= new int[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1=findViewById(R.id.edt1);
        edt2=findViewById(R.id.edt2);
        edt3=findViewById(R.id.edt3);
        edt4=findViewById(R.id.edt4);
        edt5=findViewById(R.id.edt5);
        quantum=findViewById(R.id.quantum);
        resultadoproceso=findViewById(R.id.resultadoproceso);
        resultadotiempo=findViewById(R.id.resultadotiempo);
        borrar=findViewById(R.id.borrar);
    }





    public void CalcularProceso(View view){
        int n1,n2,n3,n4,n5,quant;
        String valor1=edt1.getText().toString();
        String valor2=edt2.getText().toString();
        String valor3=edt3.getText().toString();
        String valor4=edt4.getText().toString();
        String valor5=edt5.getText().toString();
        String valor6=quantum.getText().toString();

        if(valor1.length() ==0) {
            edt1.setError("\"Por favor rellenar este campo\"");
        }


        if(valor2.length() ==0 ) {
            edt2.setError("\"Por favor rellenar este campo\"");

        }

        if(valor3.length() ==0 ) {
            edt3.setError("\"Por favor rellenar este campo\"");
        }
        if(valor4.length() ==0) {
            edt4.setError("\"Por favor rellenar este campo\"");
        }


        if(valor5.length() ==0 ) {
            edt5.setError("\"Por favor rellenar este campo\"");
        }

        if(valor6.length() ==0 ) {
            quantum.setError("\"Por favor rellenar este campo\"");
        }

        if(valor1.length()!=0 && valor2.length()!=0 && valor3.length()!=0 && valor4.length()!=0 && valor5.length()!=0 && valor6.length()!=0 ) {
            n1=Integer.parseInt(valor1);
            n2=Integer.parseInt(valor2);
            n3=Integer.parseInt(valor3);
            n4=Integer.parseInt(valor4);
            n5=Integer.parseInt(valor5);
            quant=Integer.parseInt(valor6);

            if(n1<1 || n1>10) {
                n1 = 0;
                edt1.setText(null);
                Toast.makeText(this, "Error, los procesos deben estar entre 1 y 10", Toast.LENGTH_LONG).show();
            }
            if(n2<1 || n2>10){
                n2=0;
                edt2.setText(null);
                Toast.makeText( this , "Error, los procesos deben estar entre 1 y 10", Toast.LENGTH_LONG).show();
            }
            if(n3<1 || n3>10){
                n3 = 0;
                edt3.setText(null);
                Toast.makeText(this, "Error, los procesos deben estar entre 1 y 10", Toast.LENGTH_LONG).show();
            }
            if(n4<1 || n4>10){
                n4 = 0;
                edt4.setText(null);
                Toast.makeText(this, "Error, los procesos deben estar entre 1 y 10", Toast.LENGTH_LONG).show();
            }
            if(n5<1 || n5>10){
                n5 = 0;
                edt5.setText(null);
                Toast.makeText(this, "Error, los procesos deben estar entre 1 y 10", Toast.LENGTH_LONG).show();
            }
            if(quant<1 || quant>5){
                quant = 0;
                quantum.setText(null);
                Toast.makeText(this, "Error, el quantum debe estar entre 1 y 5", Toast.LENGTH_LONG).show();
            }
            if (n1>=1 && n1<=10 && n2>=1 && n2<=10 && n3>=1 && n3<=10 && n4>=1 && n4<=10 && n5>=1 && n5<=10 && quant>=1 && quant<=5){
                Toast.makeText( this , "\"Datos ingresados correctamente...\"", Toast.LENGTH_SHORT).show();
                for (i=0;i<5;i++)
                {
                    borrar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            trespuesta[0]=0;
                            trespuesta[1]=0;
                            trespuesta[2]=0;
                            trespuesta[3]=0;
                            trespuesta[4]=0;
                            contq =0;
                            resultadoproceso.setText(null);
                            resultadotiempo.setText(null);
                            edt1.setText(null);
                            edt2.setText(null);
                            edt3.setText(null);
                            edt4.setText(null);
                            edt5.setText(null);
                            quantum.setText(null);
                        }
                    });
                    trafaga[0]=n1;
                    trafaga[1]=n2;
                    trafaga[2]=n3;
                    trafaga[3]=n4;
                    trafaga[4]=n5;
                    auxtr[i] = trafaga[i];
                }
                auxq = quant;
                contq =0;
                while(true)
                {
                    for (i=0, cont =0; i<5; i++)
                    {
                        aux = auxq;
                        if(auxtr[i] == 0)
                        {
                            cont++;
                            continue;
                        }
                        if(auxtr[i]> auxq)
                            auxtr[i]-= auxq;
                        else
                        if(auxtr[i]>=0)
                        {
                            aux = auxtr[i];
                            auxtr[i] = 0;
                        }
                        contq += aux;
                        trespuesta[i] = contq;
                    }
                    if(cont == 5) {
                        break;
                    }
                }
                tpespera =0;
                tprespuesta =0;
                for(i=0;i<5;i++)
                { String resu="";
                    tespera[i]= trespuesta[i]- trafaga[i];
                    tpespera = tpespera + tespera[i];
                    tprespuesta = tprespuesta + trespuesta[i];
                    resu=("\nProceso\t T.ráfaga\tT.respuesta\tT.espera\n"+
                            // "\n  "+(i+1)+"\t       "+bt[i]+"\t\t "+tat[i]+"\t\t        "+wt[i]
                            "\n  "+(1)+"\t              "+ trafaga[0]+"\t              \t"+ trespuesta[0]+"\t             \t"+ tespera[0]+
                            "\n  "+(2)+"\t              "+ trafaga[1]+"\t              \t"+ trespuesta[1]+"\t             \t"+ tespera[1]+
                            "\n  "+(3)+"\t              "+ trafaga[2]+"\t              \t"+ trespuesta[2]+"\t             \t"+ tespera[2]+
                            "\n  "+(4)+"\t              "+ trafaga[3]+"\t              \t"+ trespuesta[3]+"\t             \t"+ tespera[3]+
                            "\n  "+(5)+"\t              "+ trafaga[4]+"\t              \t"+ trespuesta[4]+"\t             \t"+ tespera[4]
                    );


                    System.out.print("\n  "+(i+1)+"\t  "+ trafaga[i]+"\t\t   "+ trespuesta[i]+"\t\t   "+ tespera[i]);
                    resultadoproceso.setText(resu);
                }

                tpespera = tpespera /5;
                tprespuesta = tprespuesta /5;
                resultadotiempo.setText("\nTiempo promedio = "+ tpespera + "\n Tiempo promedio de respuesta = "+ tprespuesta);
            }
        }
    }
}