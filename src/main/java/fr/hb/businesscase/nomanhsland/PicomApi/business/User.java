package fr.hb.businesscase.nomanhsland.PicomApi.business;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Inheritance
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email", nullable = false, length = 180)
    @Email(message = "Merci de saisir un email au bon format")
    @NotBlank(message = "Merci de renseigner votre email")
    private String email;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "Merci de renseigner votre mot de passe")
    @Size(min = 8, message = "Merci de saisir un mot de passe contenant au moins 8 caractères")
    private String password;

    @Column(name = "lastname", nullable = false)
    @NotBlank(message = "Merci de préciser votre nom")
    private String lastname;

    @Column(name = "firstname", nullable = false)
    @NotBlank(message = "Merci de renseigner votre prénom")
    private String firstname;

    public User() {
    }

    public User(String email, String password, String lastname, String firstname) {
        this.email = email;
        this.password = password;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}