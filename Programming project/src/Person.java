public abstract class  Person{
    //Attributes
    private String name;
    private int ID;
    private String address;
    private String phone;
    private String email;
    static int num = 0;


    //Setters
    public void setName(String name){
        this.name=name;
    }
    public void setID(int ID){
        this.ID=ID;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public void setEmail(String email){
        this.email=email;
    }


    //Getters
    public String getName(){
        return name;
    }

    public int getID() {
        return ID;
    }
    public String getAddress(){
        return address;
    }
    public String getPhone(){
        return phone;
    }
    public String getEmail(){
        return email;
    }
    
    //toString override
    @Override
    public String toString() {
        return "ID: " + ID + ", Name: " + name;
    }

    //equals override
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return ID == person.ID;
    }

    //hashCode override (always override hashCode when overriding equals)
    @Override
    public int hashCode() {
        return Integer.hashCode(ID);
    }
}
