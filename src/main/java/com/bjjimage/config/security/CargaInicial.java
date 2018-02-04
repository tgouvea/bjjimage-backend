/*
*
* Aula com Nataniel Paiva
*
* Esse projeto poderá ser distribuído da forma que você achar melhor
* O importante é que você aprenda de verdade!
*
 */
package com.bjjimage.config.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.bjjimage.domain.Perfil;
import com.bjjimage.domain.Usuario;
import com.bjjimage.repository.PerfilRepository;
import com.bjjimage.repository.UsuarioRepository;

@Component
public class CargaInicial  implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    UsuarioRepository usuarioRepository;
    
    @Autowired
    PerfilRepository perfilRepository;
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        List<Perfil> perfis = perfilRepository.findAll();
        
        if(perfis.isEmpty()){
            perfilRepository.save(new Perfil("ROLE_ADMIN"));
            
            Perfil perfil = perfilRepository.findByPerfil("ROLE_ADMIN");
            
            List<Perfil> perfisUsuario = new ArrayList<>();
            
            perfisUsuario.add(perfil);
            
            usuarioRepository.save(new Usuario("tiago", perfisUsuario, "tiagoaraujodegouvea@gmail.com", "123"));
        }
    }
    
}
