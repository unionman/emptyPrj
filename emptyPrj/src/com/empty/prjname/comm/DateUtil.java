package com.empty.prjname.comm;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author unionman
 *
 */
public class DateUtil {

    
    /**
     * @return
     */
    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }
}
