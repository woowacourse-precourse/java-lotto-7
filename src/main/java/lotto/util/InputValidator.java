package lotto.util;

public class InputValidator {

    public static void validateInput(String input){
        //null이 들어오는 경우
        if(input==null){
            throw new IllegalArgumentException("입력으로 null값이 들어올 수 없습니다.");
        }

        if(input.isBlank()){
            throw new IllegalArgumentException("입력으로 빈 문자열 및 빈 공백이 들어올 수 없습니다.");
        }
    }
}
