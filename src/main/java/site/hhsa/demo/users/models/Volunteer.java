package site.hhsa.demo.users.models;

import javax.persistence.*;

@Entity
@Table(name = "volunteers")
public class Volunteer {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phn_number", nullable = false)
    private String phnNumber;

    @Column(name = "zipcode", nullable = false)
    private String zipcode;

    @Column(name = "date_created", nullable = false)
    private String dateCreated;

    @Column(name = "is_suspended", nullable = false)
    private boolean isSuspended;

    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin;

    public Volunteer (){}

    public Volunteer(long id, String email, String username, String password, String phnNumber, String zipcode, String dateCreated, boolean isSuspended, boolean isAdmin) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.phnNumber = phnNumber;
        this.zipcode = zipcode;
        this.dateCreated = dateCreated;
        this.isSuspended = isSuspended;
        this.isAdmin = isAdmin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phnNumber;
    }

    public void setPhoneNo(String phnNumber) {
        this.phnNumber = phnNumber;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isSuspended() {
        return isSuspended;
    }

    public void setSuspended(boolean suspended) {
        isSuspended = suspended;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
