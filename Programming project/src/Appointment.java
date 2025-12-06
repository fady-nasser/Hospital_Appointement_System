import java.time.LocalDate;
import java.time.LocalTime; 

public class Appointment {

    // 1. Attributes
    private int appointmentID;
    private Doctor doctor;
    private Patient patient;
    private LocalDate date;  
    private LocalTime time;  
    private boolean status;
    private String notes;

    // 2. Constructors

    // Default Constructor
    public Appointment() {
    }

    // Parameterized Constructor
    public Appointment(int appointmentID, Doctor doctor, Patient patient, LocalDate date, LocalTime time, boolean status, String notes) {
        this.appointmentID = appointmentID;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.time = time;
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

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
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

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() { 
        return time;
    }

    public boolean isStatus() {
        return status;
    }

    public String getNotes() {
        return notes;
    }
}