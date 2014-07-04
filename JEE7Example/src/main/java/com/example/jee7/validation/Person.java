package com.example.jee7.validation;

import java.util.Date;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 *
 * @author David EXCOFFIER <david.excoffier@st.com>
 *
 * @Null
 * @NotNull
 * @AssertTrue
 * @AssertFalse
 * @DecimalMin
 * @DecimalMax
 * @Digits
 * @Size -> String/Arrays/Collection/Map
 * @Min -> Integer
 * @Max -> Integer
 * @Pattern
 * @Valid --> cascade
 * @Future
 * @Past
 */
public class Person {

    private String nom;

    private String prenom;

    private Date dateNaissance;

    @Valid      //--> cascade validation, if null no errror
    private Company companyA;

    @NotNull    //--> cascade validation, and error if null
    @Valid
    private Company companyB;

    public Person(String nom, String prenom, Date dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    @NotNull
    @Size(max = 50)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @NotNull
    @Size(max = 50)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Past
    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public static void main(String[] args) {

        Person p = new Person("TOTO", "TITI", new Date());
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(p);
        if (constraintViolations.size() > 0) {
            System.out.println("Impossible de valider les donnees du bean : ");
            for (ConstraintViolation<Person> contraintes : constraintViolations) {
                System.out.println(contraintes.getRootBeanClass().getSimpleName()
                        + "." + contraintes.getPropertyPath() + " " + contraintes.getMessage());
            }
        } else {
            System.out.println("Les donnees du bean sont valides");
        }
    }

}
