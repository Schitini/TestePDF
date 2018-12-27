package com.example.guuh.testepdf.View;

import android.Manifest;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.guuh.testepdf.Adapter.AdapterCliente;
import com.example.guuh.testepdf.Auxilio;
import com.example.guuh.testepdf.Model.Cliente;
import com.example.guuh.testepdf.Permissoes;
import com.example.guuh.testepdf.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] permissoes = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Permissoes.validarPermissoes(permissoes, this, 1);
        setContentView(R.layout.activity_main);


        ListView listaDeClientes = (ListView)findViewById(R.id.lstCliente);

        List<Cliente> clientes = preencheClientes();

        AdapterCliente adapter = new AdapterCliente(clientes,this);

        listaDeClientes.setAdapter(adapter);

        geraPDF(adapter);
    }

    private List<Cliente> preencheClientes(){
        return new ArrayList<>(Arrays.asList(
                new Cliente(1, "José da Silva", "Rua José Hernandes", "Taquarivaí"),
                new Cliente(2, "Silva José", "Rua José Hernandes", "Bernadino de Campos"),
                new Cliente(3, "Maria Silva", "Rua José Hernandes", "Pauliceia"),
                new Cliente(4, "Josenildo", "Rua José Hernandes", "Piraí"),
                new Cliente(5, "Josenildo", "Rua José Hernandes", "Piraí"),
                new Cliente(6, "Josenildo", "Rua José Hernandes", "Piraí"),
                new Cliente(7, "Josenildo", "Rua José Hernandes", "Piraí"),
                new Cliente(8, "Josenildo", "Rua José Hernandes", "Piraí"),
                new Cliente(9, "Josenildo", "Rua José Hernandes", "Piraí"),
                new Cliente(10, "Josenildo", "Rua José Hernandes", "Piraí"),
                new Cliente(11, "Josenildo", "Rua José Hernandes", "Piraí"),
                new Cliente(12, "Josenildo", "Rua José Hernandes", "Piraí"),
                new Cliente(13, "Josenildo", "Rua José Hernandes", "Piraí"),
                new Cliente(14, "Josenildo", "Rua José Hernandes", "Piraí"),
                new Cliente(15, "Josenildo", "Rua José Hernandes", "Piraí")

            )
        );
    }

    private void geraPDF(AdapterCliente ad){
        int i = 0;

        PdfDocument documento = new PdfDocument();

        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(595,842, 1).create();

        PdfDocument.Page page = documento.startPage(pageInfo);

        Canvas canvas = page.getCanvas();
        Paint paint = new Paint();

        while (i < ad.getCount()){
            Cliente cliente = (Cliente)ad.getItem(i);
            canvas.drawText(cliente.getId() + "Nome: " + cliente.getNome().toString() + " Endereço: " + cliente.getEndereco().toString() + " Cidade: " + cliente.getCidade(),0,((i+10)*10),paint);
            i++;
        }

        documento.finishPage(page);

        /*Adicionar mais folhas ao arquivo*/
        pageInfo = new PdfDocument.PageInfo.Builder(595,842,2).create();
        page = documento.startPage(pageInfo);
        canvas = page.getCanvas();
        paint = new Paint();
        i = 0;

        while (i<ad.getCount()){
            Cliente cliente = (Cliente)ad.getItem(i);
            canvas.drawText(cliente.getId() + "Nome: " + cliente.getNome().toString() + " Endereço: " + cliente.getEndereco().toString() + " Cidade: " + cliente.getCidade(), 0, ((i+10)*10),paint);
            i++;
        }
        documento.finishPage(page);

        /* Gera arquivo PDF*/

        File filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        try {
            documento.writeTo(new FileOutputStream(filePath+ "/SeuArquivo1.pdf"));
            Toast.makeText(this, "Arquivo PDF Gerado", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Erro ao gravar arquivo: " + e.toString(),
                    Toast.LENGTH_LONG).show();
        }
        documento.close();

        }


    }
