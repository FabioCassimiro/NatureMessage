package br.com.unip.sicc.natureMessage.control;

import br.com.unip.sicc.natureMessage.exception.InsufficientCharactersException;

public class ConfigCadastro {


    public void ConfigCadastroValida(String noLogin, String noSenha) throws InsufficientCharactersException {

        if (noLogin.length() < 8) {

            throw new InsufficientCharactersException("O login deve ter pelo menos 8(oito) caracteres!");

        }
        if (noSenha.length() < 8) {

            throw new InsufficientCharactersException("A senha deve ter pelo menos 8(oito) caracteres!");
        }
    }



}
