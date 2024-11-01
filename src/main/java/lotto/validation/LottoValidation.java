package lotto.validation;

public class LottoValidation {
    public void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력 금액에 공백을 입력하면 안됩니다.");
        }
    }

    public void validateParsing(String input){
        try{
            Integer.parseInt(input);
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException("[ERROR] Integer로 변환이 불가능합니다.");
        }
    }
}
