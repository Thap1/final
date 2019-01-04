
package utils;

/**
 * @author User Constants
 */
public interface Constants {
    /**
     * @author User InternCandidate
     */
    interface InternCandidate {
        public static final String SHOW_INTE = "SELECT * FROM nhansu.candidate where candidateType = '2';";
        public static final String INSERT_INTE = "INSERT INTO `nhansu`.`candidate` (`candidateID`, `firstName`, `lastName`, `birthDate`, `address`, `phone`, `email`, `candidateType`, `majors`, `semester`, `universityName`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    }

    /**
     * @author User ExperienceCandidate
     */
    interface ExperienceCandidate {
        public static final String INSERT_EXP = "INSERT INTO `nhansu`.`candidate` (`candidateID`, `firstName`, `lastName`, `birthDate`, `address`, `phone`, `email`, `candidateType`, `expInYear`, `proSkill`) VALUES (?, ?, ?,?,?,?,?,?,?,?)";
        public static final String SHOW_EXP = "SELECT * FROM nhansu.candidate where candidateType = '0';";
    }

    /**
     * @author User FresherCandidate
     */
    interface FresherCandidate {
        public static final String SHOW_FRE = "SELECT * FROM nhansu.candidate where candidateType = '1';";
        public static final String INSERT_FRE = "INSERT INTO `nhansu`.`candidate` (`candidateID`, `firstName`, `lastName`, `birthDate`, `address`, `phone`, `email`, `candidateType`, `graduationDate`, `graduationRank`, `education`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    }

    interface Recruitment {
        public static final String SELECT_RE = "SELECT * FROM nhansu.recruitment;";
        public static final String SELECT_RE_ID = "select * from Recruitment where RecruitmentCode = ?;";
        public static final String UP_RE_CODE = "update Recruitment set Amount = ? where RecruitmentCode = ?;";
    }

    interface Candidate {
        public static final String SHOW_ALL_CAN = "select * from Candidate";
        public static final String SHOW_CAN_ID = "select CandidateType from Candidate where CandidateID = ?";
    }
}
