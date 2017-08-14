package paesjuliana.com.br.siap.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import paesjuliana.com.br.siap.entity.Funcionario;

public class FuncionarioService {

    private String caminho = "http://10.10.2.2:8009/rest/AUTENTICA?cmatricula";

    public Funcionario getFuncionarioPorMatricula(String matricula) {
        Funcionario funcionario = null;

        HttpURLConnection urlConnection = null;

        try {
            URL url = new URL(caminho+"="+matricula);
            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Scanner s = new Scanner(in);
            String conteudo = s.useDelimiter("\\A").nextLine();

            Gson gson = new Gson();
            funcionario = gson.fromJson(conteudo, Funcionario.class);


        }catch(ConnectException ce){
            return null;

        }catch (Exception e){
            throw new RuntimeException(e);

        }finally {
            urlConnection.disconnect();
        }

        return funcionario;
    }

}