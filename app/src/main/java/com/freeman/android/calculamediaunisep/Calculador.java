package com.freeman.android.calculamediaunisep;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.nfc.FormatException;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;


import java.util.IllegalFormatConversionException;

/**
 * Created by freeman on 19/04/2016.
 */
public class Calculador {

    private String notaG1;
    private String notaG2;
    private String notaSegChamG1;
    private String notaSegChamG2;
    private String notaSubsG1;
    private String notaSubsG2;

    private double g1;
    private double g2;
    private double segG1;
    private double segG2;
    private double subsG1;
    private double subsG2;

    private Activity activity;

    public Calculador() {
    }

    public Calculador(Activity activity,String notaG1, String notaG2, String notaSegChamG1, String notaSegChamG2, String notaSubsG1, String notaSubsG2) {
        this.activity = activity;
        this.notaG1 = notaG1;
        this.notaG2 = notaG2;
        this.notaSegChamG1 = notaSegChamG1;
        this.notaSegChamG2 = notaSegChamG2;
        this.notaSubsG1 = notaSubsG1;
        this.notaSubsG2 = notaSubsG2;
        this.g1 = 0;
        this.g2 = 0;
        this.segG1 = 0;
        this.segG2 = 0;
        this.subsG1 = 0;
        this.subsG2 = 0;
    }

    public Calculador(String notaG1, String notaG2, String notaSegChamG1, String notaSegChamG2, String notaSubsG1, String notaSubsG2, double g1, double g2, double segG1, double segG2, double subsG1, double subsG2) {
        this.notaG1 = notaG1;
        this.notaG2 = notaG2;
        this.notaSegChamG1 = notaSegChamG1;
        this.notaSegChamG2 = notaSegChamG2;
        this.notaSubsG1 = notaSubsG1;
        this.notaSubsG2 = notaSubsG2;
        this.g1 = g1;
        this.g2 = g2;
        this.segG1 = segG1;
        this.segG2 = segG2;
        this.subsG1 = subsG1;
        this.subsG2 = subsG2;
    }

    public String getNotaG1() {
        return notaG1;
    }

    public void setNotaG1(String notaG1) {
        this.notaG1 = notaG1;
    }

    public String getNotaG2() {
        return notaG2;
    }

    public void setNotaG2(String notaG2) {
        this.notaG2 = notaG2;
    }

    public String getNotaSegChamG1() {
        return notaSegChamG1;
    }

    public void setNotaSegChamG1(String notaSegChamG1) {
        this.notaSegChamG1 = notaSegChamG1;
    }

    public String getNotaSegChamG2() {
        return notaSegChamG2;
    }

    public void setNotaSegChamG2(String notaSegChamG2) {
        this.notaSegChamG2 = notaSegChamG2;
    }

    public String getNotaSubsG1() {
        return notaSubsG1;
    }

    public void setNotaSubsG1(String notaSubsG1) {
        this.notaSubsG1 = notaSubsG1;
    }

    public String getNotaSubsG2() {
        return notaSubsG2;
    }

    public void setNotaSubsG2(String notaSubsG2) {
        this.notaSubsG2 = notaSubsG2;
    }

    public double getG1() {
        return g1;
    }

    public void setG1(double g1) {
        this.g1 = g1;
    }

    public double getG2() {
        return g2;
    }

    public void setG2(double g2) {
        this.g2 = g2;
    }

    public double getSegG1() {
        return segG1;
    }

    public void setSegG1(double segG1) {
        this.segG1 = segG1;
    }

    public double getSegG2() {
        return segG2;
    }

    public void setSegG2(double segG2) {
        this.segG2 = segG2;
    }

    public double getSubsG1() {
        return subsG1;
    }

    public void setSubsG1(double subsG1) {
        this.subsG1 = subsG1;
    }

    public double getSubsG2() {
        return subsG2;
    }

    public void setSubsG2(double subsG2) {
        this.subsG2 = subsG2;
    }

    public void doStuff() {
        if(vereficaNotas()) {
            resolveCaso(vereficaCaso());
        }
    }

    public void resolveCaso(int caso) {
        double result;
        switch (caso) {
            case 0:
                errorWindow("Erro","Não é possivel ter estas combinações de notas.");
                break;
            case 1:
                result = (21 - this.g1) / 2;
                launchActivityResult(result);
                break;
            case 2:
                result = (21 - this.segG1) /2;
                launchActivityResult(result);
                break;
            case 3:
                result = (this.subsG1 + (2*this.g2)) / 3;
                launchActivityResult3(result);
                break;
            case 4:
                result = (this.subsG1 + (2*this.segG2)) / 3;
                launchActivityResult3(result);
                break;
            case 5:
                result = (this.subsG1 + (2*this.segG2)) / 3;
                launchActivityResult3(result);
                break;
            case 6:
                result = (this.g1 + (2*this.g2)) / 3;
                launchActivityResult2(result,this.g1,this.g2);
                break;
            case 7:
                result = (this.g1 + (2*this.segG2)) / 3;
                launchActivityResult2(result,this.g1,this.segG2);
                break;
            case 8:
                result = (this.g1 + (2*this.segG2)) / 3;
                launchActivityResult2(result,this.g1,this.segG2);
                break;
            case 9:
                result = (this.g1 + (2*this.subsG2)) / 3;
                launchActivityResult3(result);
                break;
            case 10:
                result = (this.g1 + (2*this.subsG2)) / 3;
                launchActivityResult3(result);
                break;
            case 11:
                result = (this.g1 + (2*this.subsG2)) / 3;
                launchActivityResult3(result);
                break;
            case 12:
                result = (this.g1 + (2*this.subsG2)) / 3;
                launchActivityResult3(result);
                break;
            case 13:
                result = (this.segG1 + (2*this.subsG2)) / 3;
                launchActivityResult3(result);
                break;
            case 14:
                result = (this.segG1 + (2*this.g2)) / 3;
                launchActivityResult2(result,this.segG1,this.g2);
                break;
            case 15:
                result = (this.subsG1 + (2*this.g2)) / 3;
                launchActivityResult3(result);
                break;
            case 16:
                result = (this.subsG1 + (2*this.g2)) / 3;
                launchActivityResult3(result);
                break;
            case 17:
                result = (this.segG1 + (2*this.segG2)) / 3;
                launchActivityResult2(result,this.segG1,this.segG2);
                break;
            case 18:
                result = (this.subsG1 + (2*this.segG2)) / 3;
                launchActivityResult3(result);
                break;
            case 19:
                result = (this.segG1 + (2*this.subsG2)) / 3;
                launchActivityResult3(result);
                break;
            case 20:
                result = (this.segG1 + (2*this.subsG2)) / 3;
                launchActivityResult3(result);
                break;
            case 21:
                result = (21 - this.segG1) / 2;
                launchActivityResult(result);
                break;
            case 22:
                result = (this.segG1 + (2*this.segG2)) / 3;
                launchActivityResult2(result,this.segG1,this.segG2);
                break;
            case 23:
                result = (this.subsG1 + (2*this.segG2)) / 3;
                launchActivityResult3(result);
                break;
            case 24:
                result = (this.segG1 + (2*this.subsG2)) / 3;
                launchActivityResult3(result);
                break;
            case 25:
                result = (this.subsG1 + (2*this.segG2)) / 3;
                launchActivityResult3(result);
                break;
            case 26:
                result = (this.subsG1 + (2*this.g2)) / 3;
                launchActivityResult3(result);
                break;
            case 27:
                result = (this.segG1 + (2*this.segG2)) / 3;
                launchActivityResult2(result, this.segG1, this.segG2);
                break;
            case 28:
                result = (this.segG1 + (2*this.g2)) / 3;
                launchActivityResult2(result, this.segG1, this.g2);
                break;
        }
    }

    public int vereficaCaso() {
        int caso;
        if(!this.notaG1.equals("") && this.notaG2.equals("") && this.notaSegChamG1.equals("") &&
                this.notaSegChamG2.equals("") && this.notaSubsG1.equals("") && this.notaSubsG2.equals("")) {
            caso = 1;
        }
        else if(!this.notaG1.equals("") && this.notaG2.equals("") && !this.notaSegChamG1.equals("") &&
                this.notaSegChamG2.equals("") && this.notaSubsG1.equals("") && this.notaSubsG2.equals("")) {
            caso = 2;
        }
        else if(!this.notaG1.equals("") && !this.notaG2.equals("") && !this.notaSegChamG1.equals("") &&
                this.notaSegChamG2.equals("") && !this.notaSubsG1.equals("") && this.notaSubsG2.equals("")) {
            caso = 3;
        }
        else if(!this.notaG1.equals("") && this.notaG2.equals("") && !this.notaSegChamG1.equals("") &&
                !this.notaSegChamG2.equals("") && !this.notaSubsG1.equals("") && this.notaSubsG2.equals("")) {
            caso = 4;
        }
        else if(!this.notaG1.equals("") && !this.notaG2.equals("") && !this.notaSegChamG1.equals("") &&
                !this.notaSegChamG2.equals("") && !this.notaSubsG1.equals("") && this.notaSubsG2.equals("")) {
            caso = 5;
        }
        else if(!this.notaG1.equals("") && !this.notaG2.equals("") && this.notaSegChamG1.equals("") &&
                this.notaSegChamG2.equals("") && this.notaSubsG1.equals("") && this.notaSubsG2.equals("")) {
            caso = 6;
        }
        else if(!this.notaG1.equals("") && this.notaG2.equals("") && this.notaSegChamG1.equals("") &&
                !this.notaSegChamG2.equals("") && this.notaSubsG1.equals("") && this.notaSubsG2.equals("")) {
            caso = 7;
        }
        else if(!this.notaG1.equals("") && !this.notaG2.equals("") && this.notaSegChamG1.equals("") &&
                !this.notaSegChamG2.equals("") && this.notaSubsG1.equals("") && this.notaSubsG2.equals("")) {
            caso = 8;
        }
        else if(!this.notaG1.equals("") && this.notaG2.equals("") && this.notaSegChamG1.equals("") &&
                this.notaSegChamG2.equals("") && this.notaSubsG1.equals("") && !this.notaSubsG2.equals("")) {
            caso = 9;
        }
        else if(!this.notaG1.equals("") && !this.notaG2.equals("") && this.notaSegChamG1.equals("") &&
                this.notaSegChamG2.equals("") && this.notaSubsG1.equals("") && !this.notaSubsG2.equals("")) {
            caso = 10;
        }
        else if(!this.notaG1.equals("") && this.notaG2.equals("") && this.notaSegChamG1.equals("") &&
                !this.notaSegChamG2.equals("") && this.notaSubsG1.equals("") && !this.notaSubsG2.equals("")) {
            caso = 11;
        }
        else if(!this.notaG1.equals("") && !this.notaG2.equals("") && this.notaSegChamG1.equals("") &&
                !this.notaSegChamG2.equals("") && this.notaSubsG1.equals("") && !this.notaSubsG2.equals("")) {
            caso = 12;
        }
        else if(!this.notaG1.equals("") && !this.notaG2.equals("") && !this.notaSegChamG1.equals("") &&
                !this.notaSegChamG2.equals("") && this.notaSubsG1.equals("") && !this.notaSubsG2.equals("")) {
            caso = 13;
        }
        else if(this.notaG1.equals("") && !this.notaG2.equals("") && !this.notaSegChamG1.equals("") &&
                this.notaSegChamG2.equals("") && this.notaSubsG1.equals("") && this.notaSubsG2.equals("")) {
            caso = 14;
        }
        else if(this.notaG1.equals("") && !this.notaG2.equals("") && this.notaSegChamG1.equals("") &&
                this.notaSegChamG2.equals("") && !this.notaSubsG1.equals("") && this.notaSubsG2.equals("")) {
            caso = 15;
        }
        else if(this.notaG1.equals("") && !this.notaG2.equals("") && !this.notaSegChamG1.equals("") &&
                this.notaSegChamG2.equals("") && !this.notaSubsG1.equals("") && this.notaSubsG2.equals("")) {
            caso = 16;
        }
        else if(this.notaG1.equals("") && !this.notaG2.equals("") && !this.notaSegChamG1.equals("") &&
                !this.notaSegChamG2.equals("") && this.notaSubsG1.equals("") && this.notaSubsG2.equals("")) {
            caso = 17;
        }
        else if(this.notaG1.equals("") && !this.notaG2.equals("") && !this.notaSegChamG1.equals("") &&
                !this.notaSegChamG2.equals("") && !this.notaSubsG1.equals("") && this.notaSubsG2.equals("")) {
            caso = 18;
        }
        else if(this.notaG1.equals("") && !this.notaG2.equals("") && !this.notaSegChamG1.equals("") &&
                !this.notaSegChamG2.equals("") && this.notaSubsG1.equals("") && !this.notaSubsG2.equals("")) {
            caso = 19;
        }
        else if(this.notaG1.equals("") && !this.notaG2.equals("") && !this.notaSegChamG1.equals("") &&
                this.notaSegChamG2.equals("") && this.notaSubsG1.equals("") && !this.notaSubsG2.equals("")) {
            caso = 20;
        }
        else if(this.notaG1.equals("") && this.notaG2.equals("") && !this.notaSegChamG1.equals("") &&
                this.notaSegChamG2.equals("") && this.notaSubsG1.equals("") && this.notaSubsG2.equals("")) {
            caso = 21;
        }
        else if(this.notaG1.equals("") && this.notaG2.equals("") && !this.notaSegChamG1.equals("") &&
                !this.notaSegChamG2.equals("") && this.notaSubsG1.equals("") && this.notaSubsG2.equals("")) {
            caso = 22;
        }
        else if(this.notaG1.equals("") && this.notaG2.equals("") && !this.notaSegChamG1.equals("") &&
                !this.notaSegChamG2.equals("") && !this.notaSubsG1.equals("") && this.notaSubsG2.equals("")) {
            caso = 23;
        }
        else if(this.notaG1.equals("") && this.notaG2.equals("") && !this.notaSegChamG1.equals("") &&
                !this.notaSegChamG2.equals("") && this.notaSubsG1.equals("") && !this.notaSubsG2.equals("")) {
            caso = 24;
        }
        else if(this.notaG1.equals("") && this.notaG2.equals("") && this.notaSegChamG1.equals("") &&
                !this.notaSegChamG2.equals("") && !this.notaSubsG1.equals("") && this.notaSubsG2.equals("")) {
            caso = 25;
        }
        else if(!this.notaG1.equals("") && !this.notaG2.equals("") && this.notaSegChamG1.equals("") &&
                this.notaSegChamG2.equals("") && !this.notaSubsG1.equals("") && this.notaSubsG2.equals("")) {
            caso = 26;
        }
        else if(!this.notaG1.equals("") && !this.notaG2.equals("") && !this.notaSegChamG1.equals("") &&
                !this.notaSegChamG2.equals("") && this.notaSubsG1.equals("") && this.notaSubsG2.equals("")) {
            caso = 27;
        }
        else if(!this.notaG1.equals("") && !this.notaG2.equals("") && !this.notaSegChamG1.equals("") &&
                this.notaSegChamG2.equals("") && this.notaSubsG1.equals("") && this.notaSubsG2.equals("")) {
            caso = 28;
        }
        else caso = 0;
        return caso;
    }

    public boolean vereficaNotas() {
        boolean isOk = true;
        if(!this.notaG1.equals("")) {
            this.notaG1 = this.notaG1.replace(",",".");
            try {
                this.g1 = Double.parseDouble(this.notaG1);
            }catch (IllegalFormatConversionException | NumberFormatException ex) {
                errorWindow("Nota G1","Certifique-se que a nota G1 foi digitada corretamente");
                isOk = false;
            }
            if(this.g1 > 10) {
                errorWindow("Nota G1","A nota da G1 deve ser menor que 10.");
                isOk = false;
            }
        }

        if(!this.notaG2.equals("")) {
            this.notaG2 = this.notaG2.replace(",",".");
            try {
                this.g2 = Double.parseDouble(this.notaG2);
            }catch (IllegalFormatConversionException | NumberFormatException ex) {
                errorWindow("Nota G2","Certifique-se que a nota G2 foi digitada corretamente");
                isOk = false;
            }
            if(this.g2 > 10) {
                errorWindow("Nota G2","A nota da G2 deve ser menor que 10.");
                isOk = false;
            }
        }

        if(!this.notaSegChamG1.equals("")) {
            this.notaSegChamG1 = this.notaSegChamG1.replace(",",".");
            try {
                this.segG1 = Double.parseDouble(this.notaSegChamG1);
            }catch (IllegalFormatConversionException | NumberFormatException ex) {
                errorWindow("Segunda Chamada G1","Certifique-se que a nota da Segunda Chamada" +
                        "da G1 foi digitada corretamente");
                isOk = false;
            }
            if(this.segG1 > 10) {
                errorWindow("Segunda Chamada G1","A nota da Segunda Chamada G1 deve ser menor que 10.");
                isOk = false;
            }
        }

        if(!this.notaSegChamG2.equals("")) {
            this.notaSegChamG2 = this.notaSegChamG2.replace(",",".");
            try {
                this.segG2 = Double.parseDouble(this.notaSegChamG2);
            }catch (IllegalFormatConversionException | NumberFormatException ex) {
                errorWindow("Segunda Chamada G2","Certifique-se que a nota da Segunda Chamada" +
                        "da G2 foi digitada corretamente");
                isOk = false;
            }
            if(this.segG2 > 10) {
                errorWindow("Segunda Chamada G2","A nota da Segunda Chamada G2 deve ser menor que 10.");
                isOk = false;
            }
        }

        if(!this.notaSubsG1.equals("")) {
            this.notaSubsG1 = this.notaSubsG1.replace(",",".");
            try {
                this.subsG1 = Double.parseDouble(this.notaSubsG1);
            }catch (IllegalFormatConversionException | NumberFormatException ex) {
                errorWindow("Substutiva G1","Certifique-se que a nota da Substutiva" +
                        "da G1 foi digitada corretamente");
                isOk = false;
            }
            if(this.subsG1 > 10) {
                errorWindow("Substutiva G1","A nota da Substutiva G1 deve ser menor que 10.");
                isOk = false;
            }
        }

        if(!this.notaSubsG2.equals("")) {
            this.notaSubsG2 = this.notaSubsG2.replace(",",".");
            try {
                this.subsG2 = Double.parseDouble(this.notaSubsG2);
            }catch (IllegalFormatConversionException | NumberFormatException ex) {
                errorWindow("Substutiva G2","Certifique-se que a nota da Substutiva" +
                        "da G2 foi digitada corretamente");
                isOk = false;
            }
            if(this.subsG2 > 10) {
                errorWindow("Substutiva G2","A nota da Substutiva G2 deve ser menor que 10.");
                isOk = false;
            }
        }
        return isOk;
    }

    public void errorWindow(String title, String message) {
        AlertDialog alerta;
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //define o titulo
        builder.setTitle(title);
        //define a mensagem
        builder.setMessage(message);
        //define um botão como positivo
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {}
        });
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
    }

    public void launchActivityResult(double result) {
        String message = "";
        if(result > 10) message ="Sua nota é muito baixa.\nFaça substutiva de G1";
        else message ="Você precisa de "+String.format("%.2f",result)+" na G2";
        Intent intent = new Intent(activity.getApplicationContext(), Result.class);
        Bundle params = new Bundle();
        params.putString("message",message);
        intent.putExtras(params);
        activity.startActivity(intent);
    }

    public void launchActivityResult2(double media, double nota1, double nota2) {
        String mediaTxt="",situation="",subs="";
        double n1, n2; //n1 = subs1 n2 = subs2
        if(media>=7) {
            mediaTxt = "Sua média: "+String.format("%.2f",media);
            situation = "Você está aprovado.";
        }
        else {
            n1 = (21 - (2*nota2));
            n2 = (21 - nota1) / 2;
            if(n1 > 10 && n2 > 10) {
                mediaTxt = "Sua média: "+String.format("%.2f",media);
                situation = "Você está reprovado.";
                subs = "Não existe a possibilidade de passar com substutiva.";
            }
            else if(n1 <= 10 && n2 >10) {
                mediaTxt = "Sua média: "+String.format("%.2f",media);
                situation = "Você pegou substutiva.";
                subs = "Sua opção:\nSubstituir a G1: "+String.format("%.2f",n1);
            }
            else if(n1 > 10 && n2 <=10) {
                mediaTxt = "Sua média: "+String.format("%.2f",media);
                situation = "Você pegou substutiva.";
                subs = "Sua opção\nSubstituir a G2: "+String.format("%.2f",n2);
            }
            else {
                mediaTxt = "Sua média: "+String.format("%.2f",media);
                situation = "Você pegou substutiva.";
                subs = "Sua opção:\nSubstituir a G1: "+String.format("%.2f",n1) + "" +
                        "\nou G2: "+String.format("%.2f",n2);
            }
        }

        Intent intent = new Intent(activity.getApplicationContext(), Result2.class);
        Bundle params = new Bundle();
        params.putString("media",mediaTxt);
        params.putString("situation", situation);
        params.putString("subs",subs);
        intent.putExtras(params);
        activity.startActivity(intent);
    }

    public void launchActivityResult3(double result) {
        String situation, media = "Sua média: "+ String.format("%.2f",result);
        if(result<7)
            situation = "Reprovado";
        else
            situation = "Aprovado";
        Intent intent = new Intent(activity.getApplicationContext(), Result3.class);
        Bundle params = new Bundle();
        params.putString("media",media);
        params.putString("situation",situation);
        intent.putExtras(params);
        activity.startActivity(intent);
    }
}
