package br.univille.dsi2022.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.dsi2022.entity.MembroDaFamilia;
import br.univille.dsi2022.security.JWTUtil;

@RestController 
@RequestMapping("/api/v1/auth")
public class AuthenticationControllerAPI {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody  MembroDaFamilia membroDaFamilia){
        var userDetails = 
        userDetailsService.loadUserByUsername(membroDaFamilia.getUsuario());
        if(userDetails.getPassword().equals(membroDaFamilia.getSenha())){
            Map<String,Object> claims = new HashMap<>();
            var token  = jwtUtil.createToken(claims, userDetails.getUsername());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
    
}
