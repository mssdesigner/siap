package paesjuliana.com.br.siap;

import java.text.DateFormat;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.StringTokenizer;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import paesjuliana.com.br.siap.entity.Funcionario;
import paesjuliana.com.br.siap.services.FuncionarioService;


public class MainActivity extends AppCompatActivity {

    private FuncionarioService service = new FuncionarioService();

    DateFormat dateFormat = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy");

    Calendar dataTime = Calendar.getInstance();
    private TextView txtRelogio, txtEmei;
    private EditText txtMatricula;
    private String matricula = "";
    private String imei = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        imei = telephonyManager.getImei();



        txtRelogio = (TextView) findViewById(R.id.textRelogio);
        txtEmei = (TextView) findViewById(R.id.textImei);
        txtEmei.setText("Imei do Aparelho\n" + imei);


        updateTextLabel();
    }

    private void updateTextLabel(){

        txtRelogio.setText(dateFormat.format(dataTime.getTime()));
    }


    public void irParaTelaAutentica(View view) {

        matricula = ((EditText) findViewById(R.id.editTextMatricula)).getText().toString();

        new irParaTelaAutenticaTask().execute();

    }


    private class irParaTelaAutenticaTask extends AsyncTask<String, Funcionario , Funcionario> {
        private ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setTitle("Aguarde...");
            dialog.setMessage("Obtendo dados...");
            dialog.show();
        }
        @Override
        protected void onPostExecute(final Funcionario funcionario) {
            dialog.dismiss();
            try {

                if (funcionario != null && funcionario.getCMATFUN().equals(matricula)) {

                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                    View mView = getLayoutInflater().inflate(R.layout.dialog_autentica, null);

                    mBuilder.setView(mView);
                    TextView saudacao = (TextView) mView.findViewById(R.id.textViewSaudacao);
                    saudacao.setText(funcionario.getCNOME().trim());

                    final EditText resposta = (EditText) mView.findViewById(R.id.editTextResposta);

                    TextView pergunta = (TextView) mView.findViewById(R.id.textViewPergunta);

                    Button ok = (Button) mView.findViewById(R.id.btnOk);
                    Button cancelar = (Button) mView.findViewById(R.id.btnCancelar);

                    cancelar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(MainActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });

                    Random random = new Random();
                    int nAleatorio = random.nextInt(4);

                    if (nAleatorio <= 0){
                        pergunta.setText("Digite os seus 4 primeiros dígitos do cpf");

                        ok.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (resposta.getText().toString().equals(funcionario.getCCPF())) {

                                    Intent intencao = new Intent(MainActivity.this, TelaAutentica.class);
                                    Bundle info = new Bundle();
                                    info.putSerializable("Funcionario", funcionario);
                                    intencao.putExtras(info);

                                    startActivity(intencao);
                                } else {
                                    Toast toast = Toast.makeText(MainActivity.this, "Resposta Errada", Toast.LENGTH_SHORT);
                                    toast.show();
                                }
                            }
                        });

                    } if (nAleatorio == 1){
                        pergunta.setText("Digite o ano do seu nascimento\nex: 1984");

                        ok.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (resposta.getText().toString().equals(funcionario.getCANO())) {

                                    Intent intencao = new Intent(MainActivity.this, TelaAutentica.class);
                                    Bundle info = new Bundle();
                                    info.putSerializable("Funcionario", funcionario);
                                    intencao.putExtras(info);

                                    startActivity(intencao);
                                } else {
                                    Toast toast = Toast.makeText(MainActivity.this, "Resposta Errada", Toast.LENGTH_SHORT);
                                    toast.show();
                                }
                            }
                        });

                    } if (nAleatorio == 2) {
                        pergunta.setText("Digite o dia do seu nascimento\nex: 22");

                        ok.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (resposta.getText().toString().equals(funcionario.getCDIA())) {

                                    Intent intencao = new Intent(MainActivity.this, TelaAutentica.class);
                                    Bundle info = new Bundle();
                                    info.putSerializable("Funcionario", funcionario);
                                    intencao.putExtras(info);

                                    startActivity(intencao);
                                } else {
                                    Toast toast = Toast.makeText(MainActivity.this, "Resposta Errada", Toast.LENGTH_SHORT);
                                    toast.show();
                                }
                            }
                        });

                    } if (nAleatorio == 3) {
                        pergunta.setText("Digite o mes do seu nascimento\nex: 01");

                        ok.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (resposta.getText().toString().equals(funcionario.getCMES())) {

                                    Intent intencao = new Intent(MainActivity.this, TelaAutentica.class);
                                    Bundle info = new Bundle();
                                    info.putSerializable("Funcionario", funcionario);
                                    intencao.putExtras(info);

                                    startActivity(intencao);
                                } else {
                                    Toast toast = Toast.makeText(MainActivity.this, "Resposta Errada", Toast.LENGTH_SHORT);
                                    toast.show();
                                }
                            }
                        });

                    }

                    AlertDialog d = mBuilder.create();
                    d.show();

                } else {
                    Toast toast = Toast.makeText(MainActivity.this, "Funcionário não Encontrado", Toast.LENGTH_SHORT);
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

