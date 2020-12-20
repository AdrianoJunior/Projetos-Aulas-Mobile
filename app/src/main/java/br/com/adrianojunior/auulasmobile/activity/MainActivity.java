package br.com.adrianojunior.auulasmobile.activity;

import android.os.Bundle;

import br.com.adrianojunior.auulasmobile.R;
import br.com.adrianojunior.auulasmobile.fragments.CalculadoraFrag;
import br.com.adrianojunior.auulasmobile.fragments.DatabaseFrag;
import br.com.adrianojunior.auulasmobile.fragments.MapsFragment;

public class MainActivity extends BaseAcitivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        setupNavDrawer();

        if (savedInstanceState == null) {

            replaceFragment(new MapsFragment());
            getSupportActionBar().setTitle("Google Maps");

        }

    }
}