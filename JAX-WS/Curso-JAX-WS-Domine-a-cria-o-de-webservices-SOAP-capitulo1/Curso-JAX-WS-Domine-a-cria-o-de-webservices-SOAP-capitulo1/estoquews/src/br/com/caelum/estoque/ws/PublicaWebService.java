package br.com.caelum.estoque.ws;

import javax.xml.ws.Endpoint;

public class PublicaWebService {

    public static void main(String[] args) {

        EstoqueWS implementacaoWS = new EstoqueWS();
        String url = "http://localhost:8080/estoquews";

        System.out.println("EstoqueWS rodando: " + url);

        //associando URL com implementacao
        Endpoint.publish(url, implementacaoWS);
    }

}