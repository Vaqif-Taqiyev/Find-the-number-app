package com.vaqif_taqiyev.casinogame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Result extends Fragment {
    private ImageView bad_svg;
    private TextView result_text;
    private Button restart_btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_result, container, false);

        bad_svg = rootView.findViewById(R.id.bad_svg);
        result_text = rootView.findViewById(R.id.result_text);
        restart_btn = rootView.findViewById(R.id.restart_btn);

        ResultArgs resultArgs = ResultArgs.fromBundle(getArguments());
        ResultArgs resultArgs1 = ResultArgs.fromBundle(getArguments());
        boolean result_true = resultArgs.getResultOfGame();
        boolean result_false = resultArgs1.getResultOfGameFalse();
        if (result_true){
            result_text.setText("You Win");
            bad_svg.setImageResource(R.drawable.ic_mood);
        }
        if(result_false){
            result_text.setText("You Lose");
            bad_svg.setImageResource(R.drawable.ic_bad);
        }


        restart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                Navigation.findNavController(view).navigate(R.id.result_game);



            }
        });
        return rootView;
    }
}