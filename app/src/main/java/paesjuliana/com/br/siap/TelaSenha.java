package paesjuliana.com.br.siap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TelaSenha extends AppCompatActivity {

    private EditText txtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senha);

    }

    public void irParaTelaPrincipal(View view) {

        txtSenha = (EditText)findViewById(R.id.editTextSenha);

        if (txtSenha.getText().toString().equals("002202")) {

            startActivity(new Intent(getBaseContext(), TelaPrincipal.class));

        } else {
            Toast toast = Toast.makeText(this, "Senha Incorreta", Toast.LENGTH_SHORT);
            toast.show();

        }

    }

}
