/**
 *
 */
package lab2ass;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Person
 *
 * @author RAWR-XD
 * @version 1.0
 */
public class Person implements Serializable {
    private static int nextValidPersonID = 0;
    ArrayList<Person> personList = new ArrayList<>();
    ArrayList<Animal> personPetList = new ArrayList<>();
    ArrayList<Course> CourseList = new ArrayList<>();
    Animal pet; // associate a pet that is an Animal object with the Person
    Animal petInList;
    private int personID;
    private String name;  // name of person
    private String address; // address of person
    private String postcode; // postcode of person's address
    private String city; // city of person's address
    private Course currentCourse;

    // constructor - create Person given name, address and a Pet object

    /**
     * @param name    name of person
     * @param address address of person
     * @param city    city of person's address
     * @param pet     pet of the person
     */
    public Person(String name, String address, String city, Animal pet) {
        this.setPersonID();
        this.name = name;
        this.address = address;
        this.city = city;
        this.pet = pet;
    }

    // constructor - create Person given address, name and postcode

    /**
     * @param _name     name of person
     * @param _address  address of person
     * @param _city     city of person's address
     * @param _postcode postcode of the person
     */
    public Person(String _address, String _name, String _postcode, String _city) {
        this.setPersonID();
        this.setAddress(_address);
        this.setName(_name);
        this.setPostcode(_postcode);
        this.setCity(_city);
    }

    public Person() {
        // This is used for pMain
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param _name the name to set
     */
    public void setName(String _name) {
        this.name = _name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param _address the address to set
     */
    public void setAddress(String _address) {
        this.address = _address;
    }

    /**
     * @param _postcode the postcode to set
     */
    private void setPostcode(String _postcode) {
        this.postcode = _postcode;

    }

    /**
     * @param _city the city to set
     */
    public void setCity(String _city) {
        this.city = _city;
    }

    /**
     * @param _pet the pet animal to associate
     */
    public void addAPet(Animal _pet) {
        personPetList.add(_pet);
    }

    public boolean hasPet() {
        return !personPetList.isEmpty();
    }

    public void enrollInCourse(Course _currentCourse) {

        this.CourseList.add(_currentCourse);
    }

    public void addPerson(Person personAddToList) {
        personList.add(personAddToList); // adding the person to the person list


    }

    private void setPersonID() { // allocate next available ID
        this.personID = nextValidPersonID++;

    }

    @Override
    public String toString() {
        return "Person," + name + "," + address + "," + postcode + "," + city;
    }
}
