package com.studio.aprendaingles.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.studio.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NumerosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NumerosFragment extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ImageButton imageButtonUm, imageButtonDois, imageButtonTres, imageButtonQuatro,
            imageButtonCinco, imageButtonSeis;

    private MediaPlayer mediaPlayer;

    public NumerosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NumerosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NumerosFragment newInstance(String param1, String param2) {
        NumerosFragment fragment = new NumerosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_numeros, container, false);
        configurarClick(view);
        return view;
    }

    private void configurarClick(View view) {
        imageButtonUm = view.findViewById(R.id.imageButton_um);
        imageButtonDois = view.findViewById(R.id.imageButton_dois);
        imageButtonTres = view.findViewById(R.id.imageButton_tres);
        imageButtonQuatro = view.findViewById(R.id.imageButton_quatro);
        imageButtonCinco = view.findViewById(R.id.imageButton_cinco);
        imageButtonSeis = view.findViewById(R.id.imageButton_seis);

        imageButtonUm.setOnClickListener(this);
        imageButtonDois.setOnClickListener(this);
        imageButtonTres.setOnClickListener(this);
        imageButtonQuatro.setOnClickListener(this);
        imageButtonCinco.setOnClickListener(this);
        imageButtonSeis.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageButton_um:
                executarAudio(R.raw.one);
                break;
            case R.id.imageButton_dois:
                executarAudio(R.raw.two);
                break;
            case R.id.imageButton_tres:
                executarAudio(R.raw.three);
                break;
            case R.id.imageButton_quatro:
                executarAudio(R.raw.four);
                break;
            case R.id.imageButton_cinco:
                executarAudio(R.raw.five);
                break;
            case R.id.imageButton_seis:
                executarAudio(R.raw.six);
                break;
        }
    }

    private void executarAudio(int idAudio){
        mediaPlayer = MediaPlayer.create(getActivity(), idAudio);
        if (mediaPlayer != null){
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}