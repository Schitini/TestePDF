package com.example.guuh.testepdf.Model;

import android.graphics.Bitmap;

import com.example.guuh.testepdf.Auxilio;

public class Cliente {
    private byte[] imagem;
    private Bitmap avatar;
    private Integer id;
    private String nome, endereco, cidade;



    public Cliente ( Integer id, String nome, String endereco, String cidade){
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
    }



    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
        if (this.imagem != null)
            this.avatar = Auxilio.getImagemBytes(this.imagem);
    }

    public Bitmap getAvatar() {
        return avatar;
    }

    public void setAvatar(Bitmap avatar) {
        this.avatar = avatar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
