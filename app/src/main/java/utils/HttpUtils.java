package utils;

import android.util.JsonReader;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import entity.Cliente;
import entity.Resposta;
import entitycollections.ClienteColl;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtils {


    public static Object get(final String path, final Object tipo) throws ExecutionException, InterruptedException {

        ExecutorService exe = Executors.newSingleThreadExecutor();
        final String caminho = path;

        Callable<Object> call = new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                Object retorno = null;

                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url(path).build();
                    Response response = client.newCall(request).execute();
                    if(response.isSuccessful()){
                        Reader json = response.body().charStream();
                        Gson gson = new GsonBuilder().create();
                        retorno = gson.fromJson(json,tipo.getClass());
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return retorno;
            }
        };
        Future<Object> conteudo = exe.submit(call);
        return conteudo.get();
    }

    public static List<Cliente> getListaClientes(final String path) throws ExecutionException, InterruptedException {

        ExecutorService exe = Executors.newSingleThreadExecutor();
        final String caminho = path;

        Callable<List<Cliente>> call = new Callable<List<Cliente>>() {
            @Override
            public List<Cliente> call() throws Exception {
                List<Cliente> retorno = null;

                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url(path).build();
                    Response response = client.newCall(request).execute();
                    if(response.isSuccessful()){
                        Reader json = response.body().charStream();
                        Gson gson = new GsonBuilder().create();

                        Type coll = new TypeToken<List<Cliente>>(){}.getType();
                        retorno = gson.fromJson(json,coll);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return retorno;
            }
        };
        Future<List<Cliente>> conteudo = exe.submit(call);
        return conteudo.get();
    }

}
