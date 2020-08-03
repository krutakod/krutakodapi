package krutakod.company.krutakodserver.rest;

import krutakod.company.krutakodserver.security.jwt.JwtTokenProvider;
import krutakod.company.krutakodserver.service.UserService;
import krutakod.company.krutakodserver.dto.AuthenticationRequestDto;
import krutakod.company.krutakodserver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value = "/api/v1/auth/")
public class AuthenticationRestControllerV1 {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    @Autowired
    public AuthenticationRestControllerV1(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto) {
        try {
            String username = requestDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
            User user = userService.findByUsername(username);

            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }

            String token = jwtTokenProvider.createToken(username, user.getRoles());

            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }



    @PostMapping("reg")
    public ResponseEntity reg(@RequestBody User user){

        if(user.getEmail()==null&&user.getPassword()==null&&user.getUsername()==null){
            throw new BadCredentialsException("username = null or password = null or email = null");
        }

        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());

        User userAuth = userService.register(user);
        Map<Object, Object> response = new HashMap<>();
        response.put("username", user.getUsername());
       // authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
       // User userAuth = userService.findByUsername(user.getUsername());
        String token = jwtTokenProvider.createToken(userAuth.getUsername(), userAuth.getRoles());
        response.put("token", token);
        response.put("registered",true);

        return ResponseEntity.ok(response);

    }
}
