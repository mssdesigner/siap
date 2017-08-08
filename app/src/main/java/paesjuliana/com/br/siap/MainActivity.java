package paesjuliana.com.br.siap;

import java.text.DateFormat;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DateFormat dateFormat = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy");
    Calendar dataTime = Calendar.getInstance();
    private TextView txt;
    private EditText txtCodigo;
    private EditText txtSenha;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.textRelogio);

        updateTextLabel();
    }

    private void updateTextLabel(){

        txt.setText(dateFormat.format(dataTime.getTime()));
    }

    public void mostrarMensagem(View view){
        Toast toast = Toast.makeText(this, "Bem Vindo", Toast.LENGTH_LONG);
        toast.show();
    }

    public void irParaTelaInicial(View view) {

        txtCodigo = (EditText)findViewById(R.id.editTextCodigo);
        txtSenha = (EditText)findViewById(R.id.editTextSenha);

        if (txtCodigo.getText().toString().equals("123") && txtSenha.getText().toString().equals("123")) {

            Intent intencao = new Intent(this, TelaPrincipal.class);
            startActivity(intencao);

        } else {
            Toast toast = Toast.makeText(this, "Senha Incorreta", Toast.LENGTH_LONG);
            toast.show();

        }

    }

}

