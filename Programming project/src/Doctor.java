import java.util.ArrayList;

import java.time.LocalDateTime;
public class Doctor extends Person {
    //Attributes
    private String specialization;
    private String experience;
    private ArrayList<LocalDateTime> availableTimeSlots = new ArrayList<>();


    //Constructor
    Doctor(String name , String address , String phone , String email ,  String specialization , String experience , ArrayList<LocalDateTime> availableTimeSlots ){
        setName(name);
        setID(++num);  //lazem ne2ollo el ID beta3o
        setAddress(address);
        setPhone(phone);
        setEmail(email);
        this.experience=experience;
        this.specialization=specialization;
        this.availableTimeSlots=availableTimeSlots;
    }


    //Setters
    public void setExperience(String experience){
        this.experience=experience;
    }
    public void setSpecialization(String specialization){
        this.specialization=specialization;
    }
    public void setAvailableTimeSlots(ArrayList<LocalDateTime> availableTimeSlots){
        this.availableTimeSlots=availableTimeSlots;
    }
    //override
    public void display(){
        System.out.println("--Doctor details--");
        System.out.println("Name:" + getName());
        System.out.println("Specialization" + specialization);
        System.out.println("Experience" + experience);
        System.out.println("ID" + getID());
    }
        
    //Getters
    public String getExperience(){
        return experience;
    }
    public String getSpecialization(){
        return specialization;
    }
    public ArrayList<LocalDateTime> getAvailableTimeSlots(){
        return availableTimeSlots;
    }
}
