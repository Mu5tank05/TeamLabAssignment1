/**
 *
 */
package lab1ass;

/**
 * @author Kkeogh
 */
public abstract class Animal {

    private static int nextValidRegistrationID = 1;
    // General Animal Attributes
    int registrationID;
    String breed;
    String name;
    String dob;
    String gender;
    String regdue;
    // TODO Breed specific attributes
    private String[] allowedAnimals = {"Dog", "Cat", "Rabbit"};

    /**
     * @param _breed  breed of the animal
     * @param _name   name of the animal
     * @param _dob    dob of the animal DD MMM YYYY
     * @param _gender gender of the animal
     * @param _regdue date that reg is due DD MMM YYYY
     */
    Animal(String _breed, String _name, String _gender, String _dob, String _regdue) {
        this.breed = _breed;
        this.name = _name;
        this.gender = _gender;
        this.dob = _dob;
        this.regdue = _regdue;
        this.setRegistrationID();
    }

    private void setRegistrationID() { // allocate next available ID
        this.registrationID = nextValidRegistrationID++;
    }

    public String toString() {
        return "Pet [breed=" + breed
                + ", name=" + name
                + ", dob=" + dob
                + ", gender=" + gender
                + ", regdue=" + regdue
                + ", registrationID=" + registrationID
                + "]";
    }

}
