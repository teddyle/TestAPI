package com.gestionnaire.gestionnaire.service;

import com.gestionnaire.gestionnaire.model.Patient;
import com.gestionnaire.gestionnaire.model.Pro;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface PatientService {

    public abstract List<Patient> findAll();
    public abstract Patient findById(int id);
    public abstract Set<Pro> getPros(int id);
    public abstract Patient save(Patient patient);
    public abstract List<Patient> sortByNom(String nom);
    public abstract List<Patient> sortByPrenom(String prenom);
    public abstract Patient update(Patient patient);
    public abstract void deleteById(int id);
    public abstract List<Patient> search(String nom, String prenom, LocalDate date);
}
