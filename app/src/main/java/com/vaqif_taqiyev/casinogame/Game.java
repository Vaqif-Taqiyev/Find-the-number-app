package com.vaqif_taqiyev.casinogame;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Game extends Fragment {
    private TextView kalan_txt,helpText;
    private EditText texminEditText;
    private Button send_btn;
    private int randomEded;
    private int saygac = 5;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_game, container, false);

        Random r = new Random();
        randomEded = r.nextInt(101);
        kalan_txt = rootView.findViewById(R.id.kalan_txt);
        texminEditText = rootView.findViewById(R.id.texminEditText);
        helpText = rootView.findViewById(R.id.helpText);
        send_btn = rootView.findViewById(R.id.send_btn);
        send_btn.setEnabled(false);
        texminEditText.addTextChangedListener(textWatcher);


        //RootView for nav component
        return rootView;
    }
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            String texmin_str = texminEditText.getText().toString();
            send_btn.setEnabled(true);
            //
                send_btn.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(View view) {

                            //Set enabled Button
                        //Saygacin azalmasi
                        saygac = saygac - 1;
                        int texmin = Integer.parseInt(texmin_str);

                        if (texmin == randomEded) {
                            GameDirections.GameResult gameResult = GameDirections.gameResult(true);

                            Navigation.findNavController(view).navigate(gameResult);
                            return;
                        }

                        if (randomEded > texmin) {
                            helpText.setText("Artır");
                            kalan_txt.setText("Kalan Hakk: " + saygac);
                        }

                        if (randomEded < texmin) {
                            helpText.setText("Azalt");

                            kalan_txt.setText("Kalan Hakk: " + saygac);
                        }

                        if (saygac == 0) {
                            GameDirections.GameResult result = GameDirections.gameResult(false);
                            Navigation.findNavController(view).navigate(result);

                        }

                        texminEditText.setText("");
                        send_btn.setEnabled(false);


                    }
                });

            }

        @Override
        public void afterTextChanged(Editable editable) {

        }


    };






}

