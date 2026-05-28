# 🏥 Hospital Appointment Management System

![Java](https://img.shields.io/badge/Java-24-orange?style=flat-square&logo=openjdk)
![OOP](https://img.shields.io/badge/Paradigm-OOP-teal?style=flat-square)
![Status](https://img.shields.io/badge/Status-Complete-brightgreen?style=flat-square)
![Version](https://img.shields.io/badge/Version-1.0.0-blue?style=flat-square)

A console-based **Hospital Appointment Management System** built with Java, demonstrating core Object-Oriented Programming principles including inheritance, encapsulation, abstraction, and polymorphism.

---

## 📋 About

This project is a fully-functional console application that allows a hospital to manage doctors, patients, and appointments. Users can add and edit records, schedule time slots, book appointments, cancel them, and generate reports — all through an interactive menu-driven interface.

---

## 🗂️ Project Structure

```
Programming project/
└── src/
    ├── Person.java           # Abstract base class
    ├── Doctor.java           # Extends Person (specialization, experience, slots)
    ├── Patient.java          # Extends Person (age, medical history)
    ├── Appointment.java      # Links Doctor + Patient + DateTime + status
    ├── HospitalSystems.java  # Business logic layer (manages all lists)
    └── Main.java             # Entry point + console UI
```

---

## 🧠 Class Architecture

```
Person (abstract)
├── Doctor     → specialization, experience, availableTimeSlots
└── Patient    → medicalHistoryId, age

Appointment   → Doctor + Patient + LocalDateTime + status + notes
HospitalSystems → ArrayList<Doctor>, ArrayList<Patient>, ArrayList<Appointment>
Main          → Scanner-based menu UI + helper methods
```

---

## ✨ Features

| Feature | Description |
|---|---|
| 👨‍⚕️ Doctor Management | Add / edit doctors with name, specialization, experience, and time slots |
| 🧑‍🤝‍🧑 Patient Management | Register / edit patients with personal info and medical history ID |
| 📅 Slot Scheduling | Add available time slots for any doctor |
| ✅ Appointment Booking | Book any available slot for a patient, with optional notes |
| ❌ Cancellation | Cancel a booked appointment — slot returns to available pool |
| 📊 Reports | View booked/available appointments, doctors by specialization or experience |

---

## 🖥️ Menu Structure

```
MAIN MENU
├── 1. Doctor Management
│   ├── Add Doctor
│   ├── Edit Doctor
│   └── View All Doctors
├── 2. Patient Management
│   ├── Add Patient
│   ├── Edit Patient
│   └── View All Patients
├── 3. Appointment Management
│   ├── Add Available Slot
│   ├── Book Appointment
│   ├── Cancel Appointment
│   └── View All Appointments
├── 4. View Reports
│   ├── Booked Appointments by Doctor
│   ├── Available Appointments by Doctor
│   ├── Doctors by Experience
│   └── Doctors by Specialization
└── 5. Exit
```

---

## 🚀 How to Run

> Requires **JDK 24** or higher.

```bash
# Clone the repository
git clone https://github.com/your-username/hospital-system.git

# Navigate to the source folder
cd "Programming project/src"

# Compile all Java files
javac *.java

# Run the application
java Main
```

---

## 📅 Date Format

All date and time inputs must follow this format:

```
yyyy-MM-dd HH:mm

Example: 2025-06-15 09:30
```

---

## 🧱 OOP Concepts Applied

- **Encapsulation** — All fields are private; accessed via public getters and setters.
- **Inheritance** — `Doctor` and `Patient` both extend the abstract `Person` class, sharing common fields (name, ID, address, phone, email).
- **Abstraction** — `Person` is declared `abstract` and cannot be instantiated directly.
- **Polymorphism** — `toString()` is overridden in `Doctor` and `Patient` to display class-specific information.

---

## 📌 Notes

- Doctor and Patient IDs are auto-generated using a shared static counter in `Person`.
- The `HospitalSystems` class acts as the service/business layer, while `Main` handles all user interaction.
- Appointment status: `false` = Available, `true` = Booked.

---

## 👥 Contributors

- Made with ❤️ as a Java programming project.

---

*© 2025 Hospital Appointment Management System — Java 24*
