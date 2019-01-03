/**
 * 
 */
package entity;

/**
 * @author User
 *
 */
public class FresherCandidate extends Candidate {
    String graduationDate;
    String graduationRank;
    String education;

    @Override
    public String toString() {
        return "FresherCandidate [candidateID=" + candidateID + ", firstName=" + firstName + ", lastName=" + lastName
                + ", birthDate=" + birthDate + ", address=" + address + ", phone=" + phone + ", email=" + email
                + ", candidateType=" + candidateType + "graduationDate=" + graduationDate + ", graduationRank="
                + graduationRank + ", education=" + education + "]";
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
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
     * @param graduationDate
     * @param graduationRank
     * @param education
     */
    public FresherCandidate(int candidateID, String firstName, String lastName, int birthDate, String address, int phone,
            String email, int candidateType, String graduationDate, String graduationRank, String education) {
        super(candidateID, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    /**
     * 
     */
    public FresherCandidate() {
        super();
        // TODO Auto-generated constructor stub
    }
}
