package br.com.hotel.alura.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.com.hotel.alura.modelo.Usuario;
import views.Login;
import views.MenuUsuario;

public class UsuariosController implements ActionListener{

	private Login telaDeLogin;
	
	public UsuariosController(Login telaDeLogin) {
		this.telaDeLogin = telaDeLogin;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String nome = telaDeLogin.getNome();
		String senha = telaDeLogin.getSenha();
		
		if(Usuario.validarUsuario(nome,senha)) {
			MenuUsuario menu = new MenuUsuario();
			menu.setVisible(true);
			telaDeLogin.dispose();
		} else {
			JOptionPane.showMessageDialog(telaDeLogin, "Usuário ou senha inválidos!");
		}
	}
	

}
