package lotto.validator.entity;

import lotto.validator.Validator;

// 보너스 번호 검증 클래스
public class BonusNumberValidator implements Validator {
    private final String bonusNumber;

    public BonusNumberValidator(String bonusNumber){
        this.bonusNumber = bonusNumber;
    }

    @Override
    public void validate() {
        isValidatedForm();
        isInRange();
    }

    private void isValidatedForm(){
        if(bonusNumber == null || !bonusNumber.matches("[0-9]+")){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력 할 수 있습니다.");
        }
    }

    private void isInRange(){
        try{
            int number = Integer.parseInt(bonusNumber);

            if(number < 1 || number > 45){
                throw new Exception();
            }
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45 사이의 숫자이어야 합니다.");
        }
    }
}