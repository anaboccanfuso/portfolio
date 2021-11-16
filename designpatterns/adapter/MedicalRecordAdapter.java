package adapter;

import java.util.*;

public class MedicalRecordAdapter implements MedicalRecord {
    private HealthRecord record;


    public MedicalRecordAdapter(HealthRecord record) {
        this.record = record;
    }

    public String getFirstName() {
        String name = record.getName();
        String[] split = name.split(" ");
        return split[0];
    }

    public String getLastName() {
        String name = record.getName();
        String[] split = name.split(" ");
        return split[1];
    }

    public Date getBirthday() {
        return record.getBirthdate();
    }

    public Gender getGender() {
        String gender = record.getGender().toUpperCase();
        return Gender.valueOf(gender);
    }

    public void addVisit(Date date, boolean well, String description) {
        record.addHistory(date, well, description);
    }

    public ArrayList<Visit> getVisitHistory() {
        ArrayList<String> history = record.getHistory();
        ArrayList<Visit> visits = new ArrayList<Visit>();
        for (String visit : history) {
            String[] list = visit.split(" ");
            list[2]
            visits.add(new Visit(makeDate(), well, description))
        }
        return null;
    }

    public String toString() {
        return "***** " + getFirstName() + " " + getLastName() + " *****\nBirthday: "
            + getBirthday() + "\nGender: " + getGender() + "\nMedical Visit History:\n"
            + getVisitHistory();
    }

}
