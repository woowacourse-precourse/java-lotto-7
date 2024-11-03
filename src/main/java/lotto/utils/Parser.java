package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Parser {

    private final static String INTEGER_CONVERT_ERROR_MESSAGE = "[ERROR] 입력값을 정수로 변환할 수 없습니다.";
    private final static String LIST_CONVERT_ERROR_MESSAGE = "[ERROR] 입력값을 정수의 리스트 형태로 변환할 수 없습니다.";
    private static final String COMMA_STRING = ",";


    public static List<Integer> convertStringToList(String string){
        List<Integer> numbers;

        try{
            numbers = Arrays.stream(string.split(COMMA_STRING))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }catch (IllegalArgumentException e){
            System.out.println(LIST_CONVERT_ERROR_MESSAGE);
            throw new IllegalArgumentException(LIST_CONVERT_ERROR_MESSAGE);
        }
        return numbers;
    }

    public static Integer convertStringToInteger(String string){
        Integer number;

        try{
            number = Integer.parseInt(string);
        }catch (IllegalArgumentException e){
            System.out.println(INTEGER_CONVERT_ERROR_MESSAGE);
            throw new IllegalArgumentException(INTEGER_CONVERT_ERROR_MESSAGE);
        }
        return number;
    }
}
