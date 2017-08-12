package paesjuliana.com.br.siap;

import java.text.DateFormat;
import java.util.Calendar;
import java.text.SimpleDateFormat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import paesjuliana.com.br.siap.entity.Funcionario;


public class MainActivity extends AppCompatActivity {

    Funcionario a = new Funcionario();

    DateFormat dateFormat = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy");
    Calendar dataTime = Calendar.getInstance();
    private TextView txtRelogio;
    private EditText txtCodigo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtRelogio = (TextView) findViewById(R.id.textRelogio);
        a.setMatricula("002202");

        updateTextLabel();
    }

    private void updateTextLabel(){

        txtRelogio.setText(dateFormat.format(dataTime.getTime()));
    }


    public void irParaTelaSenha(View view) {

        txtCodigo = (EditText)findViewById(R.id.editTextCodigo);

        if (txtCodigo.getText().toString().equals(a.getMatricula())) {

            startActivity(new Intent(getBaseContext(), TelaAutentica.class));

        } else {
            Toast toast = Toast.makeText(this, "Funcionário não registrado", Toast.LENGTH_SHORT);
            toast.show();

        }

    }

}

