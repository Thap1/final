/**
 * 
 */
package view;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import bll.ExperienceBLL;
import bll.FresherBLL;
import bll.InternBLL;
import dal.CandidateDAL;
import dal.RecruitmentDAL;
import entity.Candidate;
import entity.ExperienceCandidate;
import entity.FresherCandidate;
import entity.InternCandidate;
import entity.Recruitment;



/**
 * @author User
 *
 */
public class Main {
    static Logger log = Logger.getLogger(Main.class);
    static int choose = 0;
    static boolean conti = false;
    private static Scanner sc1;
    private static Scanner yn;
    private static Scanner sc12;
    private static Scanner sc13;
    private static Scanner yn2;
    private static Scanner yn3;
    private static Scanner sc;
	private static Scanner sc2;
    
    public static void main(String[] args) {
        
        log.info("Example info message ..");
       
        System.out.println("Hệ Thống ... ");
        System.out.println("=============");
        showMenu();
    }

    /**
     * Create by: HoangThap - CMC
     * Create date: Jan 3, 2019
     * Modifier: HoangThap
     * Modified date: Jan 3, 2019
     * Description: ....
     * Version 1.0
     */
    private static void showMenu() {
        sc = new Scanner(System.in);
        int chon = 0;
        do {
            System.out.println("Menu: ");
            System.out.println("1.Experience");
            System.out.println("2.Fresher");
            System.out.println("3.Intern");
            System.out.println("4.Show All Recruitment");
            System.out.println("5.Submit The Candidate To Recruitment");
            System.out.println("6.Exit!");
            System.out.println("-----------");
            do {
                System.out.println("Chọn chức năng : ");
                chon = sc.nextInt();
            } while (chon < 1 || chon > 6);
            switch (chon) {
            case 1:
                experience();
                break;
            case 2:
                fresher();
                break;
            case 3:
                intern();
                break;
            case 4:
            	showAllRecruitment();
                break;
            case 5:
                submitCandidateToRecruitment();
                break;
            case 6:
                System.out.println("Đã Thoát !!!!!!");
                System.exit(0);
                break;

            }
        } while (chon != 6);
    }

    private static void showAllRecruitment() {
    	RecruitmentDAL recruitmentDAL = new RecruitmentDAL();
        List<Recruitment> listRecruitments = recruitmentDAL.getAllRecruitment();
        System.out.println("All recruitment");
        for (Recruitment recruitment : listRecruitments) {
                System.out.println(recruitment.toString());
        }
        System.out.println("------------------------");
        showMenu();
	}

	private static void submitCandidateToRecruitment() {
		RecruitmentDAL recruitmentDAL = new RecruitmentDAL();
        CandidateDAL candidateDAL = new CandidateDAL();

        sc2 = new Scanner(System.in);
        System.out.println("Enter id candidate you want to apply:");
        int id = Integer.parseInt(sc2.nextLine());
        System.out.println("Enter id recruitment you want  to apply:");
        int recruitmentCode = Integer.parseInt(sc2.nextLine());
        Candidate candidate = candidateDAL.findCandidateByID(id);
        Recruitment recruitment = recruitmentDAL.findRecruitmentByID(recruitmentCode);
        recruitmentDAL.submitCandidateToRecruitment(candidate, recruitment);
        System.out.println("------------------");
        showMenu();
	}

	/**
     * Create by: HoangThap - CMC
     * Create date: Jan 3, 2019
     * Modifier: HoangThap
     * Modified date: Jan 3, 2019
     * Description: ....
     * Version 1.0
     */
    private static void experience() {
        sc13 = new Scanner(System.in);
        do {
            System.out.println("1.Show ");
            System.out.println("2.Insert ");
            System.out.println("3.Exit");
            do {
                System.out.println("Ban Chon: ");
                choose = sc13.nextInt();
            } while (choose < 1 || choose > 3);
            List<ExperienceCandidate> listExp;
            ExperienceBLL expBLL = new ExperienceBLL();
            ExperienceCandidate exp = new ExperienceCandidate();
            switch (choose) {
            case 1:
                System.out.println("== List Experience ==");
                listExp = expBLL.getList("SELECT * FROM nhansu.candidate where candidateType = '0';");
                expBLL.show(listExp);
                break;
            case 2:
                System.out.println("== Insert Experience ==");
                System.out.println("-CandidateID: ");
                int candi = sc13.nextInt();
                Scanner sci1 = new Scanner(System.in);
                System.out.println("-FirstName: ");
                String firstNames = sci1.nextLine();
                System.out.println("-LastName: ");
                Scanner sci2 = new Scanner(System.in);
                String lastNames = sci2.nextLine();
                System.out.println("-BirthDate(1900..Current Year): ");
                int birthDate = sc13.nextInt();
                System.out.println("-Address: ");
                Scanner sci3 = new Scanner(System.in);
                String addres = sci3.nextLine();
                System.out.println("-Phone(Tối thiểu 7 chữ số nguyên dương): ");
                int phones = sc13.nextInt();
                System.out.println("-Email(đúng định dạng email.): ");
                Scanner sci4 = new Scanner(System.in);
                String emails = sci4.nextLine();
                System.out.println("-ExpInYear(Số nguyên (0..100)): ");
                int expInYear = sc13.nextInt();
                System.out.println("-ProSkill: ");
                Scanner sci5 = new Scanner(System.in);
                String pro = sci5.nextLine();

                exp.setCandidateID(candi);
                exp.setFirstName(firstNames);
                exp.setLastName(lastNames);
                // BirthDate : 4 chữ số nguyên(1900..Current Year)
                if (CheckValidation.checkBirthDate(birthDate)) {
                    exp.setBirthDate(birthDate);
                } else {
                    System.out.println("Incorrect input for birthdate");
                    showMenu();
                }
                exp.setAddress(addres);
                // check Tối thiểu 7 chữ số nguyên dương
                if (CheckValidation.checkPhoneNumber(phones)) {
                    exp.setPhone(phones);
                } else {
                    System.out.println("Incorrect for input phone number");
                    showMenu();
                }
                // đúng định dạng email.
                if (CheckValidation.checkEmail(emails)) {
                    exp.setEmail(emails);
                } else {
                    System.out.println("Incorrect for input email");
                    showMenu();
                }
                exp.setCandidateType(0);
                // check ExpInYear : Số nguyên (0..100)
                if (CheckValidation.checkExpInYear(expInYear)) {
                     exp.setExpInYear(expInYear);
                } else {
                    System.out.println("Incorrect for input exp in year");
                    showMenu();
                }
                exp.setProSkill(pro);

                expBLL.insert(exp);
                break;
            case 3:
                System.out.println("Đã Thoát!!!!!!!!");
                System.exit(0);
                break;
            }
            System.out.println("Bạn muốn tiếp tục không (Y/N): ");
            // them do-while (yes/no)
            yn2 = new Scanner(System.in);
            String check = yn2.nextLine();
            if ("y".equals(check)) {
                conti = false;
            } else {
                conti = true;
            }
        } while (!conti);
    }

    /**
     * Create by: HoangThap - CMC
     * Create date: Jan 3, 2019
     * Modifier: HoangThap
     * Modified date: Jan 3, 2019
     * Description: ....
     * Version 1.0
     */
    private static void fresher() {
        sc12 = new Scanner(System.in);
        do {
            System.out.println("1.Show ");
            System.out.println("2.Insert ");
            System.out.println("3.Exit");
            do {
                System.out.println("Ban Chon: ");
                choose = sc12.nextInt();
            } while (choose < 1 || choose > 3);
            List<FresherCandidate> listIntern;
            FresherBLL fresherBLL = new FresherBLL();
            FresherCandidate fres = new FresherCandidate();
            
            switch (choose) {
            case 1:
                System.out.println("== List Fresher ==");
                listIntern = fresherBLL.getList("SELECT * FROM nhansu.candidate where candidateType = '1';");
                fresherBLL.show(listIntern);
                break;
            case 2:
                System.out.println("== Insert Fresher ==");
                System.out.println("-CandidateID: ");
                int candi = sc12.nextInt();
                Scanner sci1 = new Scanner(System.in);
                System.out.println("-FirstName: ");
                String firstNames = sci1.nextLine();
                System.out.println("-LastName: ");
                Scanner sci2 = new Scanner(System.in);
                String lastNames = sci2.nextLine();
                System.out.println("-BirthDate(1900..Current Year): ");
                int birthDate = sc12.nextInt();
                System.out.println("-Address: ");
                Scanner sci3 = new Scanner(System.in);
                String addres = sci3.nextLine();
                System.out.println("-Phone(Tối thiểu 7 chữ số nguyên dương): ");
                int phones = sc12.nextInt();
                System.out.println("-Email(đúng định dạng email.): ");
                Scanner sci4 = new Scanner(System.in);
                String emails = sci4.nextLine();
                System.out.println("-GraduationDate: ");
                Scanner sci6 = new Scanner(System.in);
                String graDate = sci6.nextLine();
                System.out.println("-GraduationRank((Excellence, Good, Fair, Poor)): ");
                Scanner sci7 = new Scanner(System.in);
                String graRank = sci7.next();
                System.out.println("-Education: ");
                Scanner sci8 = new Scanner(System.in);
                String edu = sci8.next();

                fres.setCandidateID(candi);
                fres.setFirstName(firstNames);
                fres.setLastName(lastNames);
                // BirthDate : 4 chữ số nguyên(1900..Current Year)
                if (CheckValidation.checkBirthDate(birthDate)) {
                    fres.setBirthDate(birthDate);
                } else {
                    System.out.println("Incorrect input for birthdate");
                    showMenu();
                }
                fres.setAddress(addres);
                // check Tối thiểu 7 chữ số nguyên dương
                if (CheckValidation.checkPhoneNumber(phones)) {
                    fres.setPhone(phones);
                } else {
                    System.out.println("Incorrect for input phone number");
                    showMenu();
                }
                // đúng định dạng email.
                if (CheckValidation.checkEmail(emails)) {
                    fres.setEmail(emails);
                } else {
                    System.out.println("Incorrect for input email");
                    showMenu();
                }
                fres.setCandidateType(1);
                fres.setGraduationDate(graDate);
                //Graduation_rank: 4 giá trị (Excellence, Good, Fair, Poor)
                if (CheckValidation.checkGraduationRank(graRank)) {
                    fres.setGraduationRank(graRank);
                } else {
                    System.out.println("Incorrect for input email");
                    showMenu();
                }
                fres.setEducation(edu);

                fresherBLL.insert(fres);
                break;
            case 3:
                System.out.println("Đã Thoát!!!!!!!!");
                System.exit(0);
                break;
            }
            System.out.println("Bạn muốn tiếp tục không (Y/N): ");

            yn3 = new Scanner(System.in);
            String check = yn3.nextLine();
            if ("y".equals(check)) {
                conti = false;
            } else {
                conti = true;
            }
        } while (!conti);
    }

    /**
     * Create by: HoangThap - CMC
     * Create date: Jan 3, 2019
     * Modifier: HoangThap
     * Modified date: Jan 3, 2019
     * Description: ....
     * Version 1.0
     */
    private static void intern() {
        sc1 = new Scanner(System.in);
        do {
            System.out.println("1.Show ");
            System.out.println("2.Insert ");
            System.out.println("3.Exit");
            do {
                System.out.println("Ban Chon: ");
                choose = sc1.nextInt();
            } while (choose < 1 || choose > 3);
            List<InternCandidate> listIntern;
            InternBLL internBLL = new InternBLL();
            InternCandidate intern = new InternCandidate();
           // Scanner scanner = new Scanner(System.in);
            switch (choose) {
            case 1:
                System.out.println("== List Intern ==");
                listIntern = internBLL.getList("SELECT * FROM nhansu.candidate where candidateType = '2';");
                internBLL.show(listIntern);
                break;
            case 2:
                System.out.println("== Insert Intern ==");
                System.out.println("-CandidateID: ");
                int candi = sc1.nextInt();
                Scanner sci1 = new Scanner(System.in);
                System.out.println("-FirstName: ");
                String firstNames = sci1.nextLine();
                System.out.println("-LastName: ");
                Scanner sci2 = new Scanner(System.in);
                String lastNames = sci2.nextLine();
                System.out.println("-BirthDate(1900..Current Year): ");
                int birthDate = sc1.nextInt();
                System.out.println("-Address: ");
                Scanner sci3 = new Scanner(System.in);
                String addres = sci3.nextLine();
                System.out.println("-Phone(Tối thiểu 7 chữ số nguyên dương): ");
                int phones = sc1.nextInt();
                System.out.println("-Email(đúng định dạng email.): ");
                Scanner sci4 = new Scanner(System.in);
                String emails = sci4.nextLine();

                System.out.println("-Majors: ");
                Scanner sci5 = new Scanner(System.in);
                String majors = sci5.next();
                System.out.println("-Semester: ");
                Scanner sci6 = new Scanner(System.in);
                String semeter = sci6.next();
                System.out.println("-UniversityName: ");
                Scanner sci7 = new Scanner(System.in);
                String uni = sci7.next();

                intern.setCandidateID(candi);
                intern.setFirstName(firstNames);
                intern.setLastName(lastNames);
                // check 4 chữ số nguyên(1900..Current Year)
                if (CheckValidation.checkBirthDate(birthDate)) {
                    intern.setBirthDate(birthDate);
                } else {
                    System.out.println("Incorrect input for birthdate");
                    showMenu();
                }
                intern.setAddress(addres);
                // check Tối thiểu 7 chữ số nguyên dương
                if (CheckValidation.checkPhoneNumber(phones)) {
                    intern.setPhone(phones);
                } else {
                    System.out.println("Incorrect for input phone number");
                    showMenu();
                }
                // đúng định dạng email.
                if (CheckValidation.checkEmail(emails)) {
                    intern.setEmail(emails);
                } else {
                    System.out.println("Incorrect for input email");
                    showMenu();
                }
                intern.setCandidateType(2);
                intern.setMajors(majors);
                intern.setSemester(semeter);
                intern.setUniversityName(uni);
                internBLL.insert(intern);
                break;
            case 3:
                System.out.println("Đã Thoát!!!!!!!!");
                System.exit(0);
                break;
            }
            System.out.println("Bạn muốn tiếp tục không (Y/N): ");

            yn = new Scanner(System.in);
            String check = yn.nextLine();
            if ("y".equals(check)) {
                conti = false;
            } else {
                conti = true;
            }
        } while (!conti);
    }
}
