package paesjuliana.com.br.siap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import paesjuliana.com.br.siap.entity.Funcionario;

public class TelaAutentica extends AppCompatActivity {

    private String resposta;
    private EditText edtSenha, edtPergunta;
    private TextView txtSenha, txtPergunta;
    private Button btnAutentica;
    private Funcionario funcionario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autentica);

        Intent intent = getIntent();

        Bundle info = intent.getExtras();

        funcionario = (Funcionario) info.getSerializable("Funcionario");

        System.out.println(funcionario.getCSENHA());

        edtSenha = (EditText) findViewById(R.id.editTextSenha);
        txtSenha = (TextView) findViewById(R.id.textViewSenha);
        btnAutentica = (Button) findViewById(R.id.btnAutentica);


    }

    public String md5 (String senha){
        String sen = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        sen = hash.toString(16);
        return sen;
    }

    public void irParaTelaPrincipal(View view) {

        edtSenha = (EditText)findViewById(R.id.editTextSenha);

        String senhaBanco = md5(edtSenha.getText().toString());


        if (senhaBanco.equals(funcionario.getCSENHA())) {

            startActivity(new Intent(getBaseContext(), TelaPrincipal.class));

        } else {
            Toast toast = Toast.makeText(this, "Senha Incorreta", Toast.LENGTH_SHORT);
            toast.show();

        }

    }

}
