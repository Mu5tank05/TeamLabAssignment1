/**
 *
 */
package lab1ass;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;

/**
 * @author RAWR xD
 */
public class Person {
	public ArrayList<Person> personList = new ArrayList<>();
	 private static int nextValidPersonID = 0;
    int personID;
	String name;  // name of person
    String address; // address of person
    String postcode; // postcode of person's address
    String city; // city of person's address
    public Animal pet; // associate a pet that is an Animal object with the Person
    public Course currentCourse;

    // constructor - create Person given name, address and a Pet object

    /**
     * @param name
     * @param address
     * @param city
     * @param pet
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
     * @param _address
     * @param _name
     * @param _postcode
     * @param _city
     */
    public Person(String _address, String _name, String _postcode, String _city) {
    	this.setPersonID();
    	this.setAddress(_address);
        this.setName(_name);
        this.setPostcode(_postcode);
        this.setCity(_city);
    }

    public Person() {
		// TODO Auto-generated constructor stub
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
        this.pet = _pet;
    }

    public void enrollInCourse(Course _currentCourse) {
        this.currentCourse = _currentCourse;
    }
    
    public void addPerson(Person personAddToList)
    {
    	personList.add(personAddToList);
    	System.out.println(personList.size());
    	
    }
    private void setPersonID() { // allocate next available ID
        this.personID = nextValidPersonID++;
        System.out.println(this.personID);
    }

    public String toStringWhole() {
        return "Person [name=" + name + ", address=" + address + ", postcode=" + postcode + ",\n pet=" + pet + "\n course=" + currentCourse + "]";
    };

    @Override
    public String toString(){
        return "Person [name=" + name + ", address=" + address + ", postcode=" + postcode + "]";
    }

    //life would be easier if computers didn't think this was year of our lord 48K+R
    public double calcRates () {
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");

        Calendar regoDate = Calendar.getInstance();
        try {
            regoDate.setTime(format.parse(this.pet.regdue));
        } catch (ParseException e) {
        }
        long regoYear = regoDate.get(Calendar.YEAR);
        System.out.println("year:"+regoYear);
        double fee = 20.00;
        long currentYear = 2018;//FIXME:Calendar.getInstance.get(Calendar.YEAR);
        
        if (regoYear == currentYear) {
            return fee;
        }
        for (int i = 0; i < currentYear - regoYear; i++) {
            fee = fee - (fee*0.01);
        }
        return fee;
    }
}
