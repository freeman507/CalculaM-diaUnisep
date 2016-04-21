package com.freeman.android.calculamediaunisep;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MonetaryMask implements TextWatcher {

    private boolean isUpdating;
    private EditText editText;
    private DecimalFormat nf = new DecimalFormat("##,##0.00");

    public MonetaryMask(EditText et) {
        editText = et;
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int after) {
        // Evita que o método seja executado varias vezes.
        // Se tirar ele entre em loop
        if (isUpdating) {
            isUpdating = false;
            return;
        }

        isUpdating = true;
        String str = s.toString();
        // Verifica se já existe a máscara no texto.
        boolean hasMask = (str.indexOf(".") > -1 || str.indexOf(",") > -1);
        // Verificamos se existe máscara
        if (hasMask) {
            // Retiramos a máscara.
            str = str.replaceAll("[,]", "").replaceAll("[.]", "");
        }

        try {
            // Transformamos o número que está escrito no EditText em
            // monetário.
            str = nf.format(Double.parseDouble(str) / 100);
            editText.setText(str);
            editText.setSelection(editText.getText().length());
        } catch (NumberFormatException e) {
            s = "";
        }
    }

    @Override
    public void beforeTextChanged(CharSequence cs, int start, int count, int after) {
        // Não iremos utilizar...
    }

    @Override
    public void afterTextChanged(Editable e) {
        // Não iremos utilizar...
    }

}
