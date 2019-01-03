package entity;

public class Candidate {
    int candidateID;
    String firstName;
    String lastName;
    int birthDate ;
    String address;
    int phone;
    String email;
    int candidateType;
    public int getCandidateID() {
        return candidateID;
    }
    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getCandidateType() {
        return candidateType;
    }
    public void setCandidateType(int candidateType) {
        this.candidateType = candidateType;
    }
    /**
     * @param candidateID
     * @param firstName
     * @param lastName
     * @param birthDate
     * @param address
     * @param phone
     * @param email
     * @param candidateType
     */
    public Candidate(int candidateID, String firstName, String lastName, int birthDate, String address, int phone,
            String email, int candidateType) {
        super();
        this.candidateID = candidateID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
    }
    /**
     * 
     */
    public Candidate() {
        super();
        // TODO Auto-generated constructor stub
    }
}
