package com.example.guuh.testepdf.Adapter;

import android.Manifest;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guuh.testepdf.Model.Cliente;
import com.example.guuh.testepdf.R;

import java.util.List;


public class AdapterCliente extends BaseAdapter {
    private final List<Cliente> clientes;
    private final Activity activity;
    private String[] permissoes = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };



    public AdapterCliente(List<Cliente> clientes, Activity minhaActivity){
        this.clientes = clientes;
        this.activity = minhaActivity;
    }

    @Override
    public int getCount() {
        return clientes.size();
    }

    @Override
    public Object getItem(int i) {
        return clientes.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewLista = activity.getLayoutInflater().inflate(R.layout.listviewcliente, viewGroup, false);
        Cliente cliente = clientes.get(i);
        ImageView img = (ImageView)viewLista.findViewById(R.id.imgTeste);
        TextView id = (TextView)viewLista.findViewById(R.id.txtId);
        TextView nome = (TextView)viewLista.findViewById(R.id.txtNome);
        TextView endereco = (TextView)viewLista.findViewById(R.id.txtEndereco);
        TextView cidade = (TextView)viewLista.findViewById(R.id.txtCidade);

        if (cliente.getAvatar() != null)
            img.setImageBitmap(cliente.getAvatar());
        id.setText(String.valueOf(cliente.getId()));
        nome.setText(cliente.getNome());
        endereco.setText(cliente.getEndereco());
        cidade.setText(cliente.getCidade());
        return viewLista;
    }
}
