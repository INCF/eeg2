package cz.zcu.kiv.eegdatabase.logic.controller.person;

/**
 * @author Jindra
 */
public class AddPersonCommand {

    private String givenname;
    private String surname;
    private String gender;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;
    private String note;
    private int[] eyesDefects;
    private int[] hearingDefects;

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int[] getEyesDefects() {
        return eyesDefects;
    }

    public void setEyesDefects(int[] eyesDefects) {
        this.eyesDefects = eyesDefects;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGivenname() {
        return givenname;
    }

    public void setGivenname(String givenname) {
        this.givenname = givenname;
    }

    public int[] getHearingDefects() {
        return hearingDefects;
    }

    public void setHearingDefects(int[] hearingDefects) {
        this.hearingDefects = hearingDefects;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}