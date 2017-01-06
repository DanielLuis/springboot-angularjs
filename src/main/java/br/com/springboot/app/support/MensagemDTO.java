package br.com.springboot.app.support;

import java.io.Serializable;
import java.util.Objects;

public class MensagemDTO implements Serializable{
	private static final long serialVersionUID = 7587947750567867752L;

	private TipoMensagemDTO tipo;

	private String campo;
	 
    private String mensagem;
 
    public MensagemDTO(TipoMensagemDTO tipo,String campo, String mensagem) {
    	this.tipo = tipo;
        this.campo = campo;
        this.mensagem = mensagem;
    }

    
    public static MensagemDTO sucesso(String campo, String mensagem) {
		return new MensagemDTO(TipoMensagemDTO.SUCESSO, campo, mensagem);
	}

    public static MensagemDTO erro(String campo, String mensagem) {
		return new MensagemDTO(TipoMensagemDTO.ERRO, campo, mensagem);
	}

    public static MensagemDTO alerta(String campo, String mensagem) {
		return new MensagemDTO(TipoMensagemDTO.ALERTA, campo, mensagem);
	}
    

	public TipoMensagemDTO getTipo() {
		return tipo;
	}


	public void setTipo(TipoMensagemDTO tipo) {
		this.tipo = tipo;
	}


	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
    
    @Override
    public int hashCode() {
        return Objects.hashCode(campo)+Objects.hashCode(mensagem);
    }

    @Override
    public String toString() {
        return "ErroDTO{" + "campo" + campo + ", mensagem='" + mensagem + "'}'";
    }

}
