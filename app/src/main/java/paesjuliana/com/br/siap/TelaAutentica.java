package paesjuliana.com.br.siap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class TelaAutentica extends AppCompatActivity {

    private String resposta;
    private EditText edtSenha, edtPergunta;
    private TextView txtSenha, txtPergunta;
    private Button btnAutentica;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autentica);
        edtSenha = (EditText) findViewById(R.id.editTextSenha);
        txtSenha = (TextView) findViewById(R.id.textViewSenha);
        btnAutentica = (Button) findViewById(R.id.btnAutentica);

        txtPergunta = (TextView) findViewById(R.id.textViewPergunta);
        edtPergunta = (EditText) findViewById(R.id.editTextPergunta);

        edtSenha.setVisibility(View.INVISIBLE);
        txtSenha.setVisibility(View.INVISIBLE);
        btnAutentica.setVisibility(View.INVISIBLE);

        Random random = new Random();
        int nAleatorio = random.nextInt(4);

        if (nAleatorio <= 0){
            txtPergunta.setText("Digite o seus 4 últimos dígitos do cpf");


        } if (nAleatorio == 1){
            txtPergunta.setText("Digite o ano do seu nascimento ex: 1984");


        } if (nAleatorio == 2) {
            txtPergunta.setText("Digite o dia nascimento ex: 22");

        } if (nAleatorio == 3) {
            txtPergunta.setText("Digite o mes nascimento ex: 01");

        }
    }

    public void irParaTelaPrincipal(View view) {

        edtSenha = (EditText)findViewById(R.id.editTextSenha);

        if (edtSenha.getText().toString().equals("002202")) {

            startActivity(new Intent(getBaseContext(), TelaPrincipal.class));

        } else {
            Toast toast = Toast.makeText(this, "Senha Incorreta", Toast.LENGTH_SHORT);
            toast.show();

        }

    }

}
