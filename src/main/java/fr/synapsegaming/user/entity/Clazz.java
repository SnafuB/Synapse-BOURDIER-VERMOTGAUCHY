package fr.synapsegaming.user.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * <b>Clazz</b> stands for the different classes that can be played for a race
 * 
 * @author Meidi
 * 
 */
@Entity
@Table(name = "classes")
public class Clazz {

    /**
     * Technical unique identifier for a Class
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_class")
    @Min(value = 1, message = "Champ obligatoire")
    private long id;

    /**
     * Stands for the name of the Class
     */
    @Column(name = "name")
    private String name;

    /**
     * Path to the img
     */
    @Column(name = "img")
    private String img;

    /**
     * Match races for a class
     */
    @OneToMany(mappedBy = "clazz")
    private List<RaceClass> raceClasses;

    /**
     * The list of specs which can be played by the Class
     */
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_class")
    @Valid
    private Set<Specialization> specs;

    /**
     * Users playing this class
     */
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_class")
    private Set<User> users;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Specialization> getSpecs() {
        return specs;
    }

    public void setSpecs(Set<Specialization> specs) {
        this.specs = specs;
    }

    public List<RaceClass> getRaceClasses() {
        return raceClasses;
    }

    public void setRaceClasses(List<RaceClass> raceClasses) {
        this.raceClasses = raceClasses;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
