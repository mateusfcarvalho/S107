package br.inatel.cdg.compras;

public class DescontoException extends Exception{

    // constrói um objeto DescontoException com a mensagem passada por parâmetro
    public DescontoException(String msg){
        super(msg);
    }

    // contrói um objeto DescontoException com mensagem e a causa dessa exceção, utilizado para encadear exceptions
    public DescontoException(String msg, Throwable cause){
        super(msg, cause);
    }
}
