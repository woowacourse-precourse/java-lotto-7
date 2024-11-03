package lotto.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public static boolean isNullOrBlank(String input){
        return input == null || input.isBlank();
    }
    public static boolean isThousandUnit(int input){
        if(input % 1000 == 0){
            return true;
        }return false;
    }
    public static boolean isValidFormatForMoney(String input){
        return input.matches("^\\d{4,}$");
    }

    public static boolean isValidFormatForLottoNumber(String input){
        return input.matches("^[0-9,]+$");
    }
    public static boolean isCountSix(String[] input){
        if(input.length != 6){
            return false;
        }
        return true;
    }

    public static boolean isUniqueNumbers(String[] numbers){
        Set<String> uniqueNumbers = new HashSet<>(Arrays.asList(numbers));
        if(uniqueNumbers.size() != numbers.length){
            return false;
        }return true;
    }

    public static boolean isInRange(String[] numbers){
        for(String number : numbers){

            int num = Integer.parseInt(number);

            if(num < 0 || num > 45 ){
                return false;
            }
        }return true;
    }


    public static boolean isInRange(String number) {
        int num = Integer.parseInt(number);

        return num >= 0 && num <= 45;
    }
    public static boolean isNumeric(String number){
        return number.matches("\\d+");
    }

    public static boolean isUnique(String number, List<Integer> lottoNumbers){
        int bonusNumber = Integer.parseInt(number);
        for(int lottoNumber : lottoNumbers){
            if(lottoNumber == bonusNumber){
                return false;
            }
        }return true;
    }
}
