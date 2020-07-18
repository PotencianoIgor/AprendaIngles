package com.studio.aprendaingles.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.studio.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BichosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BichosFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ImageButton imageButtonCao, imageButtonGato, imageButtonLeao, imageButtonMacaco,
            imageButtonOvelha, imageButtonVaca;

    private MediaPlayer mediaPlayer;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BichosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BichosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BichosFragment newInstance(String param1, String param2) {
        BichosFragment fragment = new BichosFragment();
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
        View view = inflater.inflate(R.layout.fragment_bichos, container, false);
        configurarClick(view);
        return view;
    }

    private void configurarClick(View view) {
        imageButtonCao = view.findViewById(R.id.imageButton_cao);
        imageButtonGato = view.findViewById(R.id.imageButton_gato);
        imageButtonLeao = view.findViewById(R.id.imageButton_leao);
        imageButtonMacaco = view.findViewById(R.id.imageButton_macaco);
        imageButtonOvelha = view.findViewById(R.id.imageButton_ovelha);
        imageButtonVaca = view.findViewById(R.id.imageButton_vaca);

        imageButtonCao.setOnClickListener(this);
        imageButtonGato.setOnClickListener(this);
        imageButtonLeao.setOnClickListener(this);
        imageButtonMacaco.setOnClickListener(this);
        imageButtonOvelha.setOnClickListener(this);
        imageButtonVaca.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageButton_cao:
                executarAudio(R.raw.dog);
                Toast.makeText(getActivity(), "Dog", Toast.LENGTH_LONG).show();
                break;
            case R.id.imageButton_gato:
                executarAudio(R.raw.cat);
                Toast.makeText(getActivity(), "Cat", Toast.LENGTH_LONG).show();
                //Teste Nádia
                break;
            case R.id.imageButton_leao:
                executarAudio(R.raw.lion);
                Toast.makeText(getActivity(), "Lion", Toast.LENGTH_LONG).show();
                break;
            case R.id.imageButton_macaco:
                executarAudio(R.raw.monkey);
                Toast.makeText(getActivity(), "Monkey", Toast.LENGTH_LONG).show();
                break;
            case R.id.imageButton_ovelha:
                executarAudio(R.raw.sheep);
                Toast.makeText(getActivity(), "Sheep", Toast.LENGTH_LONG).show();
                break;
            case R.id.imageButton_vaca:
                executarAudio(R.raw.cow);
                Toast.makeText(getActivity(), "Cow", Toast.LENGTH_LONG).show();
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