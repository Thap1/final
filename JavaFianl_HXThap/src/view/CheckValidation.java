/**
 * 
 */
package view;

import java.util.Arrays;
import java.util.Calendar;
import java.util.regex.Pattern;

/**
 * @author User
 *
 */
public class CheckValidation {
    public static boolean checkBirthDate(int birthDate) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if ((birthDate == (int) birthDate) && birthDate >= 1900 && birthDate <= currentYear) {
            return true;
        }
        return false;
    }

    public static boolean checkPhoneNumber(int phone) {
        if (phone > 999999) {
            return true;
        }
        return false;
    }

    public static boolean checkEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public static boolean checkExpInYear(int expInYear) {
        if (expInYear >= 0 && expInYear <= 100) {
            return true;
        }
        return false;
    }

    public static boolean checkGraduationRank(String graduationRank) {
        String[] perfectGraduationRank = new String[] { "Excellent", "Good", "Fair", "Poor" };
        boolean isCheck = Arrays.asList(perfectGraduationRank).contains(graduationRank);
        return isCheck;
    }
}
