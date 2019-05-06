package com.example.demo.models;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User  {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String password;
    private String password2;
    private boolean active;
    private String name;
    private String surname;


    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
    @Email(message = "Email is not correct")
    @NotBlank(message = "Email cannot be empty")
    private String email;
    private String activationCode;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        password = password;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        userName = userName;
    }

    public User() {
    }
    public String toString()
    {
        return  "User{"+
                "id="+ id +
                ",UserName='"+ username +'\''+
                ", Password='" + password + '\'' +
                ", active=" + active +
                ", roles=" + roles +
                '}';
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        password2 = password2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


//    public List<Orders> completedOrders() {
//        List<Orders> orderedPizzas = new ArrayList<>();
//        for (Orders pizza : getOrders()) {
//            if (pizza.isSolt()) {
//                orderedPizzas.add(pizza);
//            }
//        }
//        return orderedPizzas;
//    }public List<Orders> uncompletedOrders() {
//        List<Orders> orderedPizzas = new ArrayList<>();
//        for (Orders pizza : getOrders()) {
//            if (!pizza.isSolt()) {
//                orderedPizzas.add(pizza);
//            }
//        }
//        return orderedPizzas;
//    }

//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getName() {
//        return name;
//    }
//


}
