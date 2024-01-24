package it.addon.bigdata.demospring.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="T_Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private Integer id;

    @Column(name = "login")
    @JsonProperty("name")
    private String username;

    @Column(name = "loginV2")
    private String usernameV2;

    private String password;

    private Integer connectionNumber;

    public String getUsername() {
        if(!this.usernameV2.isEmpty()) {
            return this.usernameV2;
        }
        return this.username;
    }
}
