package entitycollections;

import java.util.ArrayList;
import java.util.List;

import entity.Cliente;
import entity.Produto;

public class ProdutoColl {
    List<Produto> produtos;

    public ProdutoColl(){
        this.produtos = new ArrayList<Produto>();
    }
}
