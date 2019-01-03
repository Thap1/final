/**
 * 
 */
package entity;

/**
 * @author User
 *
 */
public class Recruitment {
    private int recruimentCode;
    private String position;
    private String recruitmentPackage;
    private int amount;
    @Override
    public String toString() {
        return "Recruitment [recruimentCode=" + recruimentCode + ", position=" + position + ", recruitmentPackage="
                + recruitmentPackage + ", amount=" + amount + "]";
    }
    public int getRecruimentCode() {
        return recruimentCode;
    }
    public void setRecruimentCode(int recruimentCode) {
        this.recruimentCode = recruimentCode;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getRecruitmentPackage() {
        return recruitmentPackage;
    }
    public void setRecruitmentPackage(String recruitmentPackage) {
        this.recruitmentPackage = recruitmentPackage;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    /**
     * 
     */
    public Recruitment() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @param recruimentCode
     * @param position
     * @param recruitmentPackage
     * @param amount
     */
    public Recruitment(int recruimentCode, String position, String recruitmentPackage, int amount) {
        super();
        this.recruimentCode = recruimentCode;
        this.position = position;
        this.recruitmentPackage = recruitmentPackage;
        this.amount = amount;
    }

}
