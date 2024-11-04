package lotto.utils;

import java.util.ArrayList;
import java.util.List;

public class Transformer {

    static public String joinToString(List<Integer> numberList, String delimiter){


        List<String> stringNumbers = new ArrayList<>();

        for(int number : numberList){
            stringNumbers.add(Integer.toString(number));
        }

        return String.join(delimiter,stringNumbers);
    }

    static public int parsePositiveInt(String rawNumber){

        Validator.validatePositiveNumericString(rawNumber);

        return Integer.parseInt(rawNumber);
    }

    static public String toStringWithRound(double decimal, int roundPosition){
        String format = "%,.0f";
        int defaultDecimalPosition = 0;
        int decimalPosition = --roundPosition;
        if(decimalPosition != defaultDecimalPosition){
            format = format.replaceFirst(Integer.toString(defaultDecimalPosition),Integer.toString(decimalPosition));
        }
        return String.format(format,decimal);
    }

    static public List<Integer> transformToIntegerList(String[] rawNumberList){
        List<Integer> numberList = new ArrayList<>();

        for(String rawNumber : rawNumberList){
            int number = parsePositiveInt(rawNumber);
            numberList.add(number);
        }

        return numberList;
    }
}
