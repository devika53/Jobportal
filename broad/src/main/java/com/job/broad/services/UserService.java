package com.job.broad.services;

import com.job.broad.dto.UserDto;
import com.job.broad.entity.User;
import com.job.broad.repository.RoleRepository;
import com.job.broad.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
@Service
@Transactional
@Slf4j
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;

    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            log.info("User not found");
            throw new UsernameNotFoundException("User not found");
        } else {
            log.info("User found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getRolename()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    //user entity saving
    public User saveUser(UserDto userDto) {

        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        roleRepository.findById(userDto.getRole().getId())      //finding by id the role and adding the that to user
                .map(roles -> {
                    if (roles != null) {
                        user.setRole(roles);
                        return user;
                    } else return "Role not found in database";
                });
        userRepository.save(user);

        return user;
    }

    public UserDto getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        UserDto userDto = new UserDto();  //created object for UserRequestDto dto
        userDto.setId(user.get().getId());
        userDto.setName(user.get().getName());
        userDto.setUsername(user.get().getUsername());
        userDto.setPassword(user.get().getPassword());


        return userDto;

    }
}
