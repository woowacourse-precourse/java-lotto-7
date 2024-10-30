package lotto.common.utils;

import static lotto.common.ExceptionConstants.IS_NULL;
import static lotto.common.ExceptionConstants.NOT_INTEGER;
import static lotto.common.ExceptionConstants.OVER_NUMBER_SIZE;


public class ValidationUtils {

    public static int strToInt(String str){
        if(str.isEmpty()) throw new IllegalArgumentException(IS_NULL.getMessage());
        if( !str.matches("\\d+") ) throw new IllegalArgumentException(NOT_INTEGER.getMessage());
        return Integer.parseInt(str);

    }

    public static String[] spliteStr(String readData){  
        //String Check
        String[] str = readData.split(",");

        for (int i = 0; i < str.length; i++) {
            if (str[i].length() > 6)  throw new IllegalArgumentException(OVER_NUMBER_SIZE.getMessage());
            if (str[i].isEmpty())     throw new IllegalArgumentException(IS_NULL.getMessage());
        }

        return str;
    }

}
