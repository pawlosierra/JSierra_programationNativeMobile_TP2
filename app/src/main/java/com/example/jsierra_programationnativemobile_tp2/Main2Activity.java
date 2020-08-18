package com.example.jsierra_programationnativemobile_tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.ResultSet;


public class Main2Activity extends AppCompatActivity {

    Button boutonZero;
    Button boutonUn;
    Button boutonDeux;
    Button boutonTrois;
    Button boutonQuatre;
    Button boutonCinq;
    Button boutonSix;
    Button boutonSept;
    Button boutonHuit;
    Button boutonNeuf;
    Button boutonSomme;
    Button boutonSoustraction;
    Button boutonDivision;
    Button boutonMultiplication;
    Button boutonSupprimer;
    Button boutonEgalent;
    Button boutonPoint;
    TextView Resultat;

    private String operateur;
    private double chiffre1;
    private boolean clicOperateur;
    private boolean update;

    //La première chose à faire est d'importer les éléments visuels que nous utiliserons ; dans ce cas, nous n'avons que la "TextView" et le "Button".
    //Ensuite, dans la classe MainActivity, nous déclarons le même nombre d'éléments qui ont été faits dans la partie conception,
    //c'est-à-dire 18 éléments de type "Bouton", 1 élément de type "TextView" et les variables nécessaires pour stocker temporairement
    //les données dans les variables.
    //
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Lorsque la méthode (onCreate(Bundle savedInstanceState)) est appelée, Android tente de
        //récupérer l'état précédent de l'activité dans un Bundle (Si elle existe).
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // //On assigne chaque bouton à une variable.
        boutonZero = (Button) findViewById(R.id.Zero);
        boutonUn = (Button) findViewById(R.id.Un);
        boutonDeux = (Button) findViewById(R.id.Deux);
        boutonTrois = (Button) findViewById(R.id.Trois);
        boutonQuatre = (Button) findViewById(R.id.Quatre);
        boutonCinq = (Button) findViewById(R.id.Cinq);
        boutonSix = (Button) findViewById(R.id.Six);
        boutonSept = (Button) findViewById(R.id.Sept);
        boutonHuit = (Button) findViewById(R.id.Huit);
        boutonNeuf = (Button) findViewById(R.id.Neuf);

        boutonSomme = (Button) findViewById(R.id.Somme);
        boutonSoustraction = (Button) findViewById(R.id.Soustraction);
        boutonDivision = (Button) findViewById(R.id.Division);
        boutonMultiplication = (Button) findViewById(R.id.Multiplication);
        boutonSupprimer = (Button) findViewById(R.id.Supprimer);
        boutonEgalent = (Button) findViewById(R.id.Egalent);
        boutonPoint = (Button) findViewById(R.id.Point);

        Resultat = (TextView) findViewById(R.id.Display);

        //Il est nécessaire d'attribuer à chaque bouton un événement d'écoute.
        //Dans chaque événement des numéros 0 à 9, une fonction ChiffreClick sera appelée.
        boutonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chiffreClick("0");
            }
        });

        boutonUn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chiffreClick("1");
            }
        });

        boutonDeux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chiffreClick("2");
            }
        });

        boutonTrois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chiffreClick("3");
            }
        });

        boutonQuatre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chiffreClick("4");
            }
        });

        boutonCinq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chiffreClick("5");
            }
        });

        boutonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chiffreClick("6");
            }
        });

        boutonSept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chiffreClick("7");
            }
        });

        boutonHuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chiffreClick("8");
            }
        });

        boutonNeuf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chiffreClick("9");
            }
        });
        //Lorsque cet événement est déclenché, la fonction plusClick sera appelée.
        boutonSomme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusClick();
            }
        });
        //Lorsque cet événement est déclenché, la fonction moinsClick sera appelée.
        boutonSoustraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moinsClick();
            }
        });
        //Lorsque cet événement est déclenché, la fonction divClick sera appelée.
        boutonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                divClick();
            }
        });
        //Lorsque cet événement est déclenché, la fonction mulClick sera appelée.
        boutonMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mulClick();
            }
        });
        //Lorsque cet événement est déclenché, la fonction resetClick sera appelée.
        boutonSupprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetClick();
            }
        });
        //Lorsque cet événement est déclenché, la fonction egalsClick sera appelée.
        boutonEgalent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                egalClick();
            }
        });

        boutonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chiffreClick(".");
            }
        });

    }

    //nous avons créé la fonction qui nous permettra d'afficher et de mémoriser chacun des
    //chiffres que l'on appuie sur le clavier.
    public void chiffreClick (String str){
            if (update) {
                update = false;
            } else {
                if (!Resultat.getText().equals("0"))
                    str = Resultat.getText() + str;
            }
            Resultat.setText(str);
    }
    //la fonction plusCLick est appelée chaque fois que l'utilisateur appuie sur la touche "+".
    // Cette fonction s'appellera une autre fonction appelée Calcul. Ce dernier effectuera
    // l'opération de sommation.
    public void plusClick(){
        if(clicOperateur){
            calcul();
            Resultat.setText(String.valueOf(chiffre1));
        }else {
            chiffre1 = Double.valueOf(Resultat.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "+";
        update = true;
    }
    //la fonction moinsCLick est appelée chaque fois que l'utilisateur appuie sur la touche "-".
    // Cette fonction s'appellera une autre fonction appelée Calcul. Ce dernier effectuera
    // l'opération de soustraction.
    public void moinsClick(){
        if(clicOperateur){
            calcul();
            Resultat.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(Resultat.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "-";
        update = true;
    }
    //la fonction mulCLick est appelée chaque fois que l'utilisateur appuie sur la touche "*".
    // Cette fonction s'appellera une autre fonction appelée Calcul. Ce dernier effectuera
    // l'opération de multiplication.
    public void mulClick(){
        if(clicOperateur){
            calcul();
            Resultat.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(Resultat.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "*";
        update = true;
    }
    //la fonction divCLick est appelée chaque fois que l'utilisateur appuie sur la touche "/".
    // Cette fonction s'appellera une autre fonction appelée Calcul. Ce dernier effectuera
    // l'opération de division.
    public void divClick(){
        if(clicOperateur){
            calcul();
            Resultat.setText(String.valueOf(chiffre1));
        }else {
            chiffre1 = Double.valueOf(Resultat.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "/";
        update = true;
    }
    //la fonction egalCLick est appelée chaque fois que l'utilisateur appuie sur la touche "=".
    // Cette fonction s'appellera une autre fonction appelée Calcul. Ce dernier effectuera
    //  d'afficher le total de l'opération que l'utilisateur a tapée.

    public void egalClick(){
        calcul();
        update = true;
        clicOperateur = false;
    }
    //la fonction nous permettra de supprimer le contenu des variables qui stockent le total de
    // l'opération. Et de cette façon, vous pouvez relancer le calcul.

    public void resetClick(){
        clicOperateur = false;
        update = true;
        chiffre1 = 0;
        operateur = "";
        Resultat.setText("");
    }

    //la fonction de calcul effectuera l'opération arithmétique. En fonction de l'opérateur
    // arithmétique, il effectuera une certaine opération entre deux nombres doubles.
    // Grâce à cette fonction, le résultat partiel de l'opération peut être imprimé à l'écran
    // chaque fois que l'utilisateur appuie sur un type de touche tel que "+", "-", "*" et "/".
    private void calcul(){
        if(operateur.equals("+")){
            chiffre1 = chiffre1 + Double.valueOf(Resultat.getText().toString()).doubleValue();
            Resultat.setText(String.valueOf(chiffre1));
        }

        if(operateur.equals("-")){
            chiffre1 = chiffre1 - Double.valueOf(Resultat.getText().toString()).doubleValue();
            Resultat.setText(String.valueOf(chiffre1));
        }

        if(operateur.equals("*")){
            chiffre1 = chiffre1 * Double.valueOf(Resultat.getText().toString()).doubleValue();
            Resultat.setText(String.valueOf(chiffre1));
        }

        //Il est important de noter que la division par zéro est une erreur, donc une exception
        // doit être générée lorsque cela se produit.
        if(operateur.equals("/")){
            try{
                chiffre1 = chiffre1 / Double.valueOf(Resultat.getText().toString()).doubleValue();
                Resultat.setText(String.valueOf(chiffre1));
            }catch (ArithmeticException e){
                Resultat.setText("0");
            }
        }
    }
}



//Pour faire la logique de cette application utiliser comme base le code que nous venons de voir.
// Références : https://a-renouard.developpez.com/tutoriel/android/calculatrice/
