package br.com.gabricio.cadastro.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.gabricio.cadastro.models.Usuario;
import br.com.gabricio.cadastro.repository.RepositorioUsuario;

@Service
public class ServicoUsuario {
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public Usuario encontrarPorEmail(String email) {
		return repositorioUsuario.findByEmail(email);
	}
	
	public void salvar(Usuario usuarios) {
		usuarios.setSenha(passwordEncoder.encode(usuarios.getSenha()));
		repositorioUsuario.save(usuarios);
	}

}
