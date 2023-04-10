package com.job.broad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;
@Entity
@Table(name = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String rolename;

//    @OneToMany(mappedBy="role", fetch = FetchType.LAZY)
//    private Set<User> users;

}
