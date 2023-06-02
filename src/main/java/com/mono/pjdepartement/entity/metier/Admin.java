package com.mono.pjdepartement.entity.metier;

import jakarta.persistence.*;

@Entity(name = "Admin")
@Table(name = "Admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdmin;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String roles;

    public Admin() {
        super();
    }

    public Admin(Long idAdmin, String email, String password, String roles) {
        this.idAdmin = idAdmin;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public void setIdAdmin(Long idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Long getIdAdmin() {
        return idAdmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "idAdmin=" + idAdmin +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
