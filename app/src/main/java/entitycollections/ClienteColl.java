package entitycollections;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import entity.Cliente;

public class ClienteColl {

    List<Cliente> clientes;

    public ClienteColl(){
        this.clientes = new ArrayList<Cliente>();
    }

    public List<Cliente> getClientes() {
        return this.clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
