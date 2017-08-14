package paesjuliana.com.br.siap;

import java.text.DateFormat;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import paesjuliana.com.br.siap.entity.Funcionario;
import paesjuliana.com.br.siap.services.FuncionarioService;


public class MainActivity extends AppCompatActivity {

    private FuncionarioService service = new FuncionarioService();

    DateFormat dateFormat = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy");

    Calendar dataTime = Calendar.getInstance();
    private TextView txtRelogio;
    private EditText txtMatricula;
    private String matricula = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtRelogio = (TextView) findViewById(R.id.textRelogio);

        updateTextLabel();
    }

    private void updateTextLabel(){

        txtRelogio.setText(dateFormat.format(dataTime.getTime()));
    }


    public void irParaTelaAutentica(View view) {

        matricula = ((EditText) findViewById(R.id.editTextMatricula)).getText().toString();

        new irParaTelaAutenticaTask().execute();

        System.out.println("Executa depois da thread");

    }


    private class irParaTelaAutenticaTask extends AsyncTask<String, Funcionario , Funcionario> {
        private ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(MainActivity.this);
            dialog.show();
        }
        @Override
        protected void onPostExecute(Funcionario funcionario) {
            dialog.dismiss();
            try {
                if (funcionario != null) {
                    Intent intencao = new Intent(MainActivity.this,TelaAutentica.class);
                    Bundle info = new Bundle();
                    info.putSerializable("Funcionario",funcionario);
                    intencao.putExtras(info);

                    startActivity(intencao);

                } else {
                    Toast toast = Toast.makeText(MainActivity.this, "Funcionário não registrado", Toast.LENGTH_SHORT);
                    toast.show();
                }
            } catch(RuntimeException re) {
                re.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        @Override
        protected Funcionario doInBackground(String... params) {
            try {
                return service.getFuncionarioPorMatricula(matricula);

            } catch(RuntimeException re) {
                System.out.printf("Teste de erro RuntimeException" + re);

            }catch (Exception e){
                System.out.println("teste de erro Exception" + e);
            }

            return null;
        }
    }



}

