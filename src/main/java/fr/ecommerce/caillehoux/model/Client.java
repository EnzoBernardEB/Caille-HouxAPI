package fr.ecommerce.caillehoux.model;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    public Client() {
        super();
    }

    public Client(Long id, String username, String password) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public String toString() {
        return "Client [id=" + this.id + ", username=" + this.username + ", password=" + this.password + "]";
    }

}
