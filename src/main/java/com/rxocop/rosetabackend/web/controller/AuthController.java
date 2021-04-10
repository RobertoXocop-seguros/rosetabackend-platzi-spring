package com.rxocop.rosetabackend.web.controller;

import com.rxocop.rosetabackend.domain.dto.AutenticationRequest;
import com.rxocop.rosetabackend.domain.dto.AutenticationResponse;
import com.rxocop.rosetabackend.domain.service.PlatziUserDetailService;
import com.rxocop.rosetabackend.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private PlatziUserDetailService platziUserDetailService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<AutenticationResponse> createToken(@RequestBody AutenticationRequest autenticationRequest){
        try
        {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(autenticationRequest.getUsername(),autenticationRequest.getPassword()));
            UserDetails userDetails= platziUserDetailService.loadUserByUsername(autenticationRequest.getUsername());
            String jwt = jwtUtil.generateToken(userDetails);
            return new ResponseEntity<>(new AutenticationResponse(jwt), HttpStatus.OK);
        }catch (BadCredentialsException e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }



    }
}
