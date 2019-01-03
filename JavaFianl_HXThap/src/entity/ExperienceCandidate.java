/**
 * 
 */
package entity;

/**
 * @author User
 *
 */
public class ExperienceCandidate extends Candidate {
    int expInYear;
    String proSkill;




    /**
     * 
     */
    public ExperienceCandidate() {
        super();
        // TODO Auto-generated constructor stub
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
     * @param expInYear
     * @param proSkill
     */
    public ExperienceCandidate(int candidateID, String firstName, String lastName, int birthDate, String address,
            int phone, String email, int candidateType, int expInYear, String proSkill) {
        super(candidateID, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return "ExperienceCandidate [candidateID=" + candidateID + ", firstName=" + firstName + ", lastName=" + lastName
                + ", birthDate=" + birthDate + ", address=" + address + ", phone=" + phone + ", email=" + email
                + ", candidateType=" + candidateType + ", expInYear=" + expInYear + ", proSkill=" + proSkill + "]";
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
}
