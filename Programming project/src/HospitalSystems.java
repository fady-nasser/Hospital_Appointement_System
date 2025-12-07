import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;

public class HospitalSystems {

    //  Attributes
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;
    private ArrayList<Appointment> appointments;

    //  Constructor
    public HospitalSystems() {
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }

    // Doctor Methods

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Doctor added: " + doctor.getName());
    }

    public void editDoctor(Doctor updatedDoctor) {
        boolean found = false;
        for (int i = 0; i < doctors.size(); i++) {
            Doctor existingDoc = doctors.get(i);
            if (existingDoc.getID()==updatedDoctor.getID()) {
                doctors.set(i, updatedDoctor);
                System.out.println("Doctor details updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Error: Doctor not found with ID: " + updatedDoctor.getID());
        }
    }

    // Patient Methods

    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient added: " + patient.getName());
    }

    public void editPatient(Patient updatedPatient) {
        boolean found = false;
        for (int i = 0; i < patients.size(); i++) {
            Patient currentPatient = patients.get(i);
            if (currentPatient.getID()==updatedPatient.getID()) {
                patients.set(i, updatedPatient);
                System.out.println("Patient details updated successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Error: Patient not found with ID: " + updatedPatient.getID());
        }
    }

    // Appointment Methods
    public void addAvailableSlot(LocalDate date, LocalTime time, Doctor doctor) {
        int newId = appointments.size() + 1;
        Appointment slot = new Appointment(newId, doctor, null, date, time, false, "Available Slot");
        appointments.add(slot);

        System.out.println("Slot added for Dr. " + doctor.getName() + " on " + date);
    }

    public void bookAppointment(Appointment appointment) {

        if (appointments.contains(appointment)) {
            appointment.setStatus(true);
            System.out.println("Appointment booked successfully.");
        } else {
            System.out.println("Error: Appointment not found in system.");
        }
    }

    public void cancelAppointment(Appointment appointment) {
        if (appointments.contains(appointment)) {
            appointment.setPatient(null);
            appointment.setStatus(false);
            System.out.println("Appointment canceled and became available.");
        } else {
            System.out.println("Error: Appointment not found.");
        }
    }

    // Reporting Methods 

    public String getBookedAppointmentsByDoctor() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Booked Appointments Report ===\n");
        for (Appointment app : appointments) {
            if (app.isStatus() == true) {
                sb.append("Dr. ").append(app.getDoctor().getName())
                        .append(" | Patient: ").append(app.getPatient().getName())
                        .append(" | Date: ").append(app.getDate())
                        .append("\n");
            }
        }
        return sb.toString();
    }

    public String getAvailableAppointmentsByDoctor() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Available Slots Report ===\n");
        for (Appointment app : appointments) {
            if (app.isStatus() == false) {
                sb.append("Dr. ").append(app.getDoctor().getName())
                        .append(" | Date: ").append(app.getDate())
                        .append(" | Time: ").append(app.getTime())
                        .append("\n");
            }
        }
        return sb.toString();
    }

    public String getByExperience() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Doctors by Experience ===\n");
        for (Doctor doc : doctors) {
            sb.append("Dr. ").append(doc.getName())
                    .append(" - Experience: ").append(doc.getExperience()).append("\n");
        }
        return sb.toString();
    }

    public String getBySpecialization() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Doctors by Specialization ===\n");
        for (Doctor doc : doctors) {
            sb.append("Dr. ").append(doc.getName())
                    .append(" - Specialization: ").append(doc.getSpecialization()).append("\n");
        }
        return sb.toString();
    }
}
