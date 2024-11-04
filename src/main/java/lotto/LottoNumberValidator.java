package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberValidator {

    public LottoNumberValidator(String input){
        validateNull(input);
        validateSpace(input);
        validateWrongInput(input);
        validateDelimiterAtBack(input);
        String[] lottoNumber = input.split(",");
        validateDelimiterAtFrontOrRepeat(lottoNumber);

    }

    private void validateWrongInput(String input) {
        // 다른 구분자나 숫자가 포함되어 있는지 확인하기
        if(!input.matches("^[1-9,]*$")) {
            throw new IllegalArgumentException("[ERROR] 숫자와 구분자','외에 다른문자가 포함되어 있습니다.");
        }
    }

    private void validateDelimiterAtFrontOrRepeat(String[] lottoNumber) {
        // input의 delimiter 위치 확인(','가 맨앞에 오거나 겹치는 경우)
        for(String number : lottoNumber) {
            if(number.isEmpty()){
                throw new IllegalArgumentException("[ERROR] ','가 겹쳐있거나 문자열 맨앞에 위치해 있습니다.");
            }
        }
    }

    private void validateDelimiterAtBack(String input) {
        // input의 delimiter 위치 확인(','가 맨앞 맨뒤에 있는 경우)
        if(input.charAt(input.length() - 1) == ','){
            throw new IllegalArgumentException("[ERROR] ','가 문자열 맨뒤에 위치해 있습니다.");
        }
    }

    private void validateNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 값이 아닌 당첨 번호를 입력해 주세요.");
        }
    }

    private void validateSpace(String input) {
        if (input.equals(" ")) {
            throw new IllegalArgumentException("[ERROR] 스페이스 값이 아닌 당첨 번호를 입력해 주세요.");
        }
    }
}
