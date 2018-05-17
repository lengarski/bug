package bug;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

/**
 * Created by glengarski
 * Date: 4/23/2018 Time: 10:23
 *
 * @author glengarski
 */
public class DocDao
{
    public void test(){
        final MapSqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("ALERT_ID", null)
//                .addValue("ALERT_DT", caseAlert.getAlertDt())
//                .addValue("TYPE_ALERT", caseAlert.getTypeAlert())
//                .addValue("FREE_TEXT", caseAlert.getFreeTxt())
//                .addValue("CASE_EXIT", caseAlert.getCaseExit() ? "O" : "N")
//                .addValue("CREATEUR", user.getUsername())
//                .addValue("ASSN_CASE_MNGR", caseAlert.getAssnCaseMngr() ? "O" : "N")
//                .addValue("REFPERSO", refperso)
//                .addValue("PROCESS_ALERT", caseAlert.getProcAlert() ? "O" : "N")
//                .addValue("REFDOSS", caseRef)
                ;

    }

}
