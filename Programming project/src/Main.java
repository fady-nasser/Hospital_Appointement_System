import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static HospitalSystems hospitalSystems = new HospitalSystems();
    private static ArrayList<Doctor> doctorList = new ArrayList<>();
    private static ArrayList<Patient> patientList = new ArrayList<>();
    private static ArrayList<Appointment> appointmentList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════╗");
        System.out.println("║  HOSPITAL APPOINTMENT MANAGEMENT SYSTEM   ║");
        System.out.println("╚═══════════════════════════════════════════╝");
        
        boolean running = true;
        while (running) {
            running = showMainMenu();
        }
        
        scanner.close();
        System.out.println("\nThank you for using the Hospital Appointment System!");
    }

    private static boolean showMainMenu() {
        System.out.println("\n" + "=".repeat(45));
        System.out.println("MAIN MENU");
        System.out.println("=".repeat(45));
        System.out.println("1. Doctor Management");
        System.out.println("2. Patient Management");
        System.out.println("3. Appointment Management");
        System.out.println("4. View Reports");
        System.out.println("5. Exit");
        System.out.println("=".repeat(45));
        System.out.print("Enter your choice: ");
        
        int choice = getIntInput();
        System.out.println();
        
        switch (choice) {
            case 1:
                doctorManagementMenu();
                break;
            case 2:
                patientManagementMenu();
                break;
            case 3:
                appointmentManagementMenu();
                break;
            case 4:
                viewReportsMenu();
                break;
            case 5:
                return false;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        return true;
    }

    // ==================== DOCTOR MANAGEMENT ====================
    private static void doctorManagementMenu() {
        System.out.println("--- DOCTOR MANAGEMENT ---");
        System.out.println("1. Add Doctor");
        System.out.println("2. Edit Doctor");
        System.out.println("3. View All Doctors");
        System.out.println("4. Back to Main Menu");
        System.out.print("Enter your choice: ");
        
        int choice = getIntInput();
        System.out.println();
        
        switch (choice) {
            case 1:
                addDoctor();
                break;
            case 2:
                editDoctor();
                break;
            case 3:
                viewAllDoctors();
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void addDoctor() {
        System.out.println("--- ADD NEW DOCTOR ---");
        
        System.out.print("Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Address: ");
        String address = scanner.nextLine();
        
        System.out.print("Phone Number: ");
        String phone = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Specialization: ");
        String specialization = scanner.nextLine();
        
        System.out.print("Experience (e.g., '5 years'): ");
        String experience = scanner.nextLine();
        
        ArrayList<LocalDateTime> availableTimeSlots = new ArrayList<>();
        System.out.print("Number of available time slots: ");
        int numSlots = getIntInput();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        for (int i = 0; i < numSlots; i++) {
            System.out.print("Time slot " + (i + 1) + " (format: yyyy-MM-dd HH:mm): ");
            String slotStr = scanner.nextLine();
            try {
                LocalDateTime slot = LocalDateTime.parse(slotStr, formatter);
                availableTimeSlots.add(slot);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Slot skipped.");
                i--;
            }
        }

        Doctor doctor = new Doctor(name, address, phone, email, specialization, experience, availableTimeSlots);
        doctorList.add(doctor);
        hospitalSystems.addDoctor(doctor);
        System.out.println("✓ Doctor added successfully! ID: " + doctor.getID());
    }

    private static void editDoctor() {
        if (doctorList.isEmpty()) {
            System.out.println("No doctors in the system.");
            return;
        }
        
        viewAllDoctors();
        System.out.print("\nEnter Doctor ID to edit: ");
        int id = getIntInput();
        
        Doctor doctor = findDoctorById(id);
        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }
        
        System.out.println("\n--- EDIT DOCTOR (ID: " + id + ") ---");
        System.out.println("Leave blank to keep current value");
        
        System.out.print("Name [" + doctor.getName() + "]: ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) doctor.setName(name);
        
        System.out.print("Address [" + doctor.getAddress() + "]: ");
        String address = scanner.nextLine();
        if (!address.isEmpty()) doctor.setAddress(address);
        
        System.out.print("Phone [" + doctor.getPhone() + "]: ");
        String phone = scanner.nextLine();
        if (!phone.isEmpty()) doctor.setPhone(phone);
        
        System.out.print("Email [" + doctor.getEmail() + "]: ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) doctor.setEmail(email);
        
        System.out.print("Specialization [" + doctor.getSpecialization() + "]: ");
        String specialization = scanner.nextLine();
        if (!specialization.isEmpty()) doctor.setSpecialization(specialization);
        
        System.out.print("Experience [" + doctor.getExperience() + "]: ");
        String experience = scanner.nextLine();
        if (!experience.isEmpty()) doctor.setExperience(experience);
        
        hospitalSystems.editDoctor(doctor);
    }

    private static void viewAllDoctors() {
        if (doctorList.isEmpty()) {
            System.out.println("No doctors in the system.");
            return;
        }
        
        System.out.println("\n--- ALL DOCTORS ---");
        for (Doctor doc : doctorList) {
            System.out.println("─".repeat(45));
            System.out.println("ID: " + doc.getID());
            System.out.println("Name: " + doc.getName());
            System.out.println("Specialization: " + doc.getSpecialization());
            System.out.println("Experience: " + doc.getExperience());
            System.out.println("Phone: " + doc.getPhone());
            System.out.println("Email: " + doc.getEmail());
            System.out.println("Available Slots: " + doc.getAvailableTimeSlots().size());
        }
        System.out.println("─".repeat(45));
    }

    // ==================== PATIENT MANAGEMENT ====================
    private static void patientManagementMenu() {
        System.out.println("--- PATIENT MANAGEMENT ---");
        System.out.println("1. Add Patient");
        System.out.println("2. Edit Patient");
        System.out.println("3. View All Patients");
        System.out.println("4. Back to Main Menu");
        System.out.print("Enter your choice: ");
        
        int choice = getIntInput();
        System.out.println();
        
        switch (choice) {
            case 1:
                addPatient();
                break;
            case 2:
                editPatient();
                break;
            case 3:
                viewAllPatients();
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void addPatient() {
        System.out.println("--- ADD NEW PATIENT ---");
        
        System.out.print("Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Address: ");
        String address = scanner.nextLine();
        
        System.out.print("Phone Number: ");
        String phone = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Medical History ID: ");
        int medicalHistoryId = getIntInput();
        
        System.out.print("Age: ");
        int age = getIntInput();
        
        Patient patient = new Patient(name, address, phone, email, medicalHistoryId, age);
        patientList.add(patient);
        hospitalSystems.addPatient(patient);
        System.out.println("✓ Patient added successfully! ID: " + patient.getID());
    }

    private static void editPatient() {
        if (patientList.isEmpty()) {
            System.out.println("No patients in the system.");
            return;
        }
        
        viewAllPatients();
        System.out.print("\nEnter Patient ID to edit: ");
        int id = getIntInput();
        
        Patient patient = findPatientById(id);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        
        System.out.println("\n--- EDIT PATIENT (ID: " + id + ") ---");
        System.out.println("Leave blank to keep current value");
        
        System.out.print("Name [" + patient.getName() + "]: ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) patient.setName(name);
        
        System.out.print("Address [" + patient.getAddress() + "]: ");
        String address = scanner.nextLine();
        if (!address.isEmpty()) patient.setAddress(address);
        
        System.out.print("Phone [" + patient.getPhone() + "]: ");
        String phone = scanner.nextLine();
        if (!phone.isEmpty()) patient.setPhone(phone);
        
        System.out.print("Email [" + patient.getEmail() + "]: ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) patient.setEmail(email);
        
        System.out.print("Age [" + patient.getAge() + "]: ");
        String ageStr = scanner.nextLine();
        if (!ageStr.isEmpty()) {
            try {
                patient.setAge(Integer.parseInt(ageStr));
            } catch (NumberFormatException e) {
                System.out.println("Invalid age format. Keeping current value.");
            }
        }
        
        hospitalSystems.editPatient(patient);
    }

    private static void viewAllPatients() {
        if (patientList.isEmpty()) {
            System.out.println("No patients in the system.");
            return;
        }
        
        System.out.println("\n--- ALL PATIENTS ---");
        for (Patient pat : patientList) {
            System.out.println("─".repeat(45));
            System.out.println("ID: " + pat.getID());
            System.out.println("Name: " + pat.getName());
            System.out.println("Age: " + pat.getAge());
            System.out.println("Phone: " + pat.getPhone());
            System.out.println("Email: " + pat.getEmail());
            System.out.println("Medical History ID: " + pat.getMedicalHistoryId());
        }
        System.out.println("─".repeat(45));
    }

    // ==================== APPOINTMENT MANAGEMENT ====================
    private static void appointmentManagementMenu() {
        System.out.println("--- APPOINTMENT MANAGEMENT ---");
        System.out.println("1. Add Available Slot");
        System.out.println("2. Book Appointment");
        System.out.println("3. Cancel Appointment");
        System.out.println("4. View All Appointments");
        System.out.println("5. Back to Main Menu");
        System.out.print("Enter your choice: ");
        
        int choice = getIntInput();
        System.out.println();
        
        switch (choice) {
            case 1:
                addAvailableSlot();
                break;
            case 2:
                bookAppointment();
                break;
            case 3:
                cancelAppointment();
                break;
            case 4:
                viewAllAppointments();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void addAvailableSlot() {
        if (doctorList.isEmpty()) {
            System.out.println("No doctors in the system. Please add a doctor first.");
            return;
        }
        
        System.out.println("--- ADD AVAILABLE SLOT ---");
        viewAllDoctors();
        
        System.out.print("\nEnter Doctor ID: ");
        int doctorId = getIntInput();
        
        Doctor doctor = findDoctorById(doctorId);
        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }
        
        System.out.print("Date and Time (format: yyyy-MM-dd HH:mm): ");
        String dateTimeStr = scanner.nextLine();
        
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);
            
            hospitalSystems.addAvailableSlot(dateTime, doctor);
            
            // Also create and track the appointment
            int newId = appointmentList.size() + 1;
            Appointment slot = new Appointment(newId, doctor, null, dateTime, false, "Available Slot");
            appointmentList.add(slot);
            
            System.out.println("✓ Available slot added successfully!");
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date/time format.");
        }
    }

    private static void bookAppointment() {
        if (appointmentList.isEmpty()) {
            System.out.println("No available slots. Please add slots first.");
            return;
        }
        
        if (patientList.isEmpty()) {
            System.out.println("No patients in the system. Please add a patient first.");
            return;
        }
        
        System.out.println("--- BOOK APPOINTMENT ---");
        
        // Show available slots
        System.out.println("\nAvailable Slots:");
        boolean hasAvailable = false;
        for (Appointment app : appointmentList) {
            if (!app.isStatus()) {
                System.out.println("Slot ID: " + app.getAppointmentID() + 
                                 " | Dr. " + app.getDoctor().getName() + 
                                 " | " + app.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                hasAvailable = true;
            }
        }
        
        if (!hasAvailable) {
            System.out.println("No available slots at the moment.");
            return;
        }
        
        System.out.print("\nEnter Slot ID to book: ");
        int slotId = getIntInput();
        
        Appointment appointment = findAppointmentById(slotId);
        if (appointment == null) {
            System.out.println("Appointment not found.");
            return;
        }
        
        if (appointment.isStatus()) {
            System.out.println("This slot is already booked.");
            return;
        }
        
        viewAllPatients();
        System.out.print("\nEnter Patient ID: ");
        int patientId = getIntInput();
        
        Patient patient = findPatientById(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        
        System.out.print("Notes (optional): ");
        String notes = scanner.nextLine();
        
        appointment.setPatient(patient);
        appointment.setStatus(true);
        if (!notes.isEmpty()) {
            appointment.setNotes(notes);
        }
        
        hospitalSystems.bookAppointment(appointment);
        System.out.println("✓ Appointment booked successfully!");
    }

    private static void cancelAppointment() {
        if (appointmentList.isEmpty()) {
            System.out.println("No appointments in the system.");
            return;
        }
        
        System.out.println("--- CANCEL APPOINTMENT ---");
        
        // Show booked appointments
        System.out.println("\nBooked Appointments:");
        boolean hasBooked = false;
        for (Appointment app : appointmentList) {
            if (app.isStatus() && app.getPatient() != null) {
                System.out.println("Appointment ID: " + app.getAppointmentID() + 
                                 " | Dr. " + app.getDoctor().getName() + 
                                 " | Patient: " + app.getPatient().getName() +
                                 " | " + app.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                hasBooked = true;
            }
        }
        
        if (!hasBooked) {
            System.out.println("No booked appointments to cancel.");
            return;
        }
        
        System.out.print("\nEnter Appointment ID to cancel: ");
        int appointmentId = getIntInput();
        
        Appointment appointment = findAppointmentById(appointmentId);
        if (appointment == null) {
            System.out.println("Appointment not found.");
            return;
        }
        
        if (!appointment.isStatus()) {
            System.out.println("This appointment is not booked.");
            return;
        }
        
        hospitalSystems.cancelAppointment(appointment);
        System.out.println("✓ Appointment canceled successfully!");
    }

    private static void viewAllAppointments() {
        if (appointmentList.isEmpty()) {
            System.out.println("No appointments in the system.");
            return;
        }
        
        System.out.println("\n--- ALL APPOINTMENTS ---");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        
        for (Appointment app : appointmentList) {
            System.out.println("─".repeat(45));
            System.out.println("Appointment ID: " + app.getAppointmentID());
            System.out.println("Doctor: " + app.getDoctor().getName());
            System.out.println("Patient: " + (app.getPatient() != null ? app.getPatient().getName() : "None"));
            System.out.println("Date/Time: " + app.getDateTime().format(formatter));
            System.out.println("Status: " + (app.isStatus() ? "BOOKED" : "AVAILABLE"));
            System.out.println("Notes: " + app.getNotes());
        }
        System.out.println("─".repeat(45));
    }

    // ==================== REPORTS ====================
    private static void viewReportsMenu() {
        System.out.println("--- VIEW REPORTS ---");
        System.out.println("1. Booked Appointments by Doctor");
        System.out.println("2. Available Appointments by Doctor");
        System.out.println("3. Doctors by Experience");
        System.out.println("4. Doctors by Specialization");
        System.out.println("5. Back to Main Menu");
        System.out.print("Enter your choice: ");
        
        int choice = getIntInput();
        System.out.println();
        
        switch (choice) {
            case 1:
                System.out.println(hospitalSystems.getBookedAppointmentsByDoctor());
                break;
            case 2:
                System.out.println(hospitalSystems.getAvailableAppointmentsByDoctor());
                break;
            case 3:
                System.out.println(hospitalSystems.getByExperience());
                break;
            case 4:
                System.out.println(hospitalSystems.getBySpecialization());
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // ==================== HELPER METHODS ====================
    private static Doctor findDoctorById(int id) {
        for (Doctor doc : doctorList) {
            if (doc.getID() == id) {
                return doc;
            }
        }
        return null;
    }

    private static Patient findPatientById(int id) {
        for (Patient pat : patientList) {
            if (pat.getID() == id) {
                return pat;
            }
        }
        return null;
    }

    private static Appointment findAppointmentById(int id) {
        for (Appointment app : appointmentList) {
            if (app.getAppointmentID() == id) {
                return app;
            }
        }
        return null;
    }

    private static int getIntInput() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}
