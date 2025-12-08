// import java.time.LocalDate;
// import java.time.LocalTime; 
import java.time.LocalDateTime;

public class Appointment {

    // 1. Attributes
    private int appointmentID;
    private Doctor doctor;
    private Patient patient;
    // private LocalDate date;  
    // private LocalTime time;  
    private LocalDateTime dateTime;
    private boolean status;
    private String notes;

    // 2. Constructors

    // Default Constructor
    public Appointment() {
    }

    // Parameterized Constructor
    public Appointment(int appointmentID, Doctor doctor, Patient patient, LocalDateTime dateTime, boolean status, String notes) {
        this.appointmentID = appointmentID;
        this.doctor = doctor;
        this.patient = patient;
        this.dateTime = dateTime;
        // this.date = date;
        // this.time = time;
        this.status = status;
        this.notes = notes;
    }

    // 3. Setters
    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    // public void setDate(LocalDate date) {
    //     this.date = date;
    // }

    // public void setTime(LocalTime time) {
    //     this.time = time;
    // }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    // 4. Getters
    public int getAppointmentID() {
        return appointmentID;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    // public LocalDate getDate() {
    //     return date;
    // }

    // public LocalTime getTime() { 
    //     return time;
    // }
    public LocalDateTime getDateTime() {
        return dateTime;
    }   

    public boolean isStatus() {
        return status;
    }

    public String getNotes() {
        return notes;
    }
}