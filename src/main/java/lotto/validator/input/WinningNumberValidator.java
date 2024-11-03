package lotto.validator.input;

import lotto.validator.Validator;

// 당첨 번호 검증 클래스
public class WinningNumberValidator implements Validator {
    private final String winningNumbers;

    public WinningNumberValidator(String winningNumbers){
        this.winningNumbers = winningNumbers;
    }

    @Override
    public void validate() {
        isValidatedForm();

        for(String winningNumber: winningNumbers.split(",")){
            isValueInRange(winningNumber);
        }
    }

    private void isValidatedForm(){
        isConsistOfNumberAndComma();
        isStartOrEndWithComma();
        isContainsContinuousComma();
    }

    private void isConsistOfNumberAndComma(){
        if(!winningNumbers.matches("[0-9|,]+")){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자와 쉼표만 입력 할 수 있습니다. (공백 없이 쉼표로만 숫자 구분)");
        }
    }

    private void isStartOrEndWithComma(){
        if(winningNumbers.startsWith(",") || winningNumbers.endsWith(",")){
            throw new IllegalArgumentException("[ERROR] 쉼표로 시작하거나 끝날 수 없습니다.");
        }
    }

    private void isContainsContinuousComma(){
        if(winningNumbers.contains(",,")){
            throw new IllegalArgumentException("[ERROR] 쉼표 사이에는 숫자를 입력해 주세요.");
        }
    }

    private void isValueInRange(String winningNumber){
        try{
            int number = Integer.parseInt(winningNumber);

        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정수 범위를 벗어 날 수 없습니다.");
        }
    }
}