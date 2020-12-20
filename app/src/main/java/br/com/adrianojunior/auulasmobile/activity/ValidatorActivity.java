package br.com.adrianojunior.auulasmobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

import br.com.adrianojunior.auulasmobile.R;

public class ValidatorActivity extends BaseAcitivity {
    private TextView usuario;
    private TextView senha;

    // novo Handler para acionar um Runnable e abrir a MainActivity após a validação,
    // aguardando 3 segundos antes
    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validator);
        setUpToolbar();
        getSupportActionBar().setTitle("Validar login");

        Intent intent = getIntent();
        // Recupera o bundle com os dados dessa acitivty
        Bundle bundle = intent.getExtras();
        usuario = findViewById(R.id.textViewUser);
        senha = findViewById(R.id.textViewPass);
        String user = bundle.getString("usuario");
        usuario.setText(user);
        String pass = bundle.getString("senha");
        senha.setText(pass);
    }

    public void verify(View view) {
        TextView verify = findViewById(R.id.textViewVerify);
        verify.setText("não autorizado");
        if (usuario.getText().toString().equals("aluno"))
            if (senha.getText().toString().equals("aluno"))
                verify.setText("autorizado");
        handler.postDelayed(new Runnable() {
            public void run() {
                toast("Bem-vindo " + usuario.getText().toString());
                /**
                 * Finaliza a execução da {@link LoginActivity},
                 * utilizando o setResult para ativar o método startActivityForResult
                 */
                setResult(RESULT_OK);

                sendToMain();
            }
        }, 3000);


    }
}