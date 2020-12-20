package br.com.adrianojunior.auulasmobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.com.adrianojunior.auulasmobile.R;

public class LoginActivity extends BaseAcitivity {

    // Código utilizado no método startActivityForResult
    int REQUEST_EXIT = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUpToolbar();
        getSupportActionBar().setTitle("Login");
    }

    public void login(View view) {
        Bundle bundle = new Bundle();
        EditText usuario = findViewById(R.id.username);
        EditText senha = findViewById(R.id.password);

        // Salva os dados no bundle
        bundle.putString("usuario", usuario.getText().toString());
        bundle.putString("senha", senha.getText().toString());

        Intent intent = new Intent(this, ValidatorActivity.class);
        // Salva/envia o bundle na intent
        intent.putExtras(bundle);
        // Método utilizado para poder encerrar
        // a activity após a validação
        startActivityForResult(intent, REQUEST_EXIT);
    }

    /**
     * Trata o método startActivityForResult para finalizar
     * a activity caso seja usado setResult(RESULT_OK) na {@link ValidatorActivity}
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_EXIT) {
            if (resultCode == RESULT_OK) {
                this.finish();

            }
        }
    }
}