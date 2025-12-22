public class Patient extends Person{
    //Attributes
    private int medicalHistoryId;
    private int age;


    //Constructor
    Patient(String name , String address , String phone , String email , int medicalHistoryId , int age){
        setName(name);
        setID(++num);   //lazem ne2ollo el ID beta3o
        setAddress(address);
        setPhone(phone);
        setEmail(email);
        this.medicalHistoryId=medicalHistoryId;
        this.age=age;
    }


    //Setters
    public void setMedicalHistoryId(int medicalHistoryId){
        this.medicalHistoryId=medicalHistoryId;
    }
    public void setAge(int age){
        this.age=age;
    }
  //override
    public void display(){
        System.out.println("--Patient details--");
        System.out.println("Name:" + getName());
        System.out.println("Age" + age);
        System.out.println("ID" + getID());
    }


    //Getters
    public int getMedicalHistoryId(){
        return medicalHistoryId;
    }
    public int getAge(){
        return age;
    }
}
