package controllers;
import models.Operador;
import play.mvc.Controller;

public class Cadastro extends Controller {

    public static void cadastroPagina(){
        render();

    }
    
    public static void salvar(Operador operador){
        operador.save();
        flash.success("Operador cadastrado com sucesso");
        Cadastro.cadastroPagina();
    }

}