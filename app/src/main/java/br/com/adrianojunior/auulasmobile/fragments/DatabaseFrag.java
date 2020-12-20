package br.com.adrianojunior.auulasmobile.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

import br.com.adrianojunior.auulasmobile.R;
import br.com.adrianojunior.auulasmobile.database.DatabaseHandler;

public class DatabaseFrag extends BaseFragment implements AdapterView.OnItemSelectedListener {


    public DatabaseFrag() {
    }

    private Spinner spinner;
    private Button btnAdd;
    private EditText itemTxt;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_database, container, false);
        spinner = view.findViewById(R.id.spinner);
        btnAdd = view.findViewById(R.id.btn_add);
        itemTxt = view.findViewById(R.id.item_text);
        spinner.setOnItemSelectedListener(this);

        loadSpinnerData();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = itemTxt.getText().toString();
                if (item.trim().length() > 0) {
                    DatabaseHandler db = new DatabaseHandler(getContext());
                    db.insertLabel(item);
                    // Deixando o texto do campo de entrada em branco
                    itemTxt.setText("");
                    // Carregando spinner com dados recém-adicionados
                    loadSpinnerData();
                } else {
                    toast("Please enter item name");
                }
            }
        });
        return view;
    }

    private void loadSpinnerData() {
        DatabaseHandler db = new DatabaseHandler(getContext());
        List<String> labels = db.getAllLabels();
        // Criando o adapter para o spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, labels);// Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // anexando adapter ao spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // Selecionando um item no spinner
        String label = adapterView.getItemAtPosition(i).toString();
        // Mostrando o item selecionado do spinner
        toast("You selected: " + label);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}