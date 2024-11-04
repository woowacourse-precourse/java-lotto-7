package lotto.service.input.validator;

import java.math.BigInteger;

public class MoneyInputValidatorService extends CommonValidatorService implements InputValidatorService {

    @Override
    public void validate(String input) {
        super.validate(input);
        noneNumericCharsExist(input);
        tooMuchMoneyToBuy(input);
        inputZero(input);
        changeExist(input);
    }

    private void noneNumericCharsExist (String input) {
        if(!input.matches("^[0-9]+")){
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 문자가 섞여 있습니다.");
        }
    }

    private void tooMuchMoneyToBuy(String input) {
        BigInteger inputMoney = new BigInteger(input);
        if(inputMoney.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0){
            throw new IllegalArgumentException("[ERROR] 범위를 넘어가는 숫자가 입력되었습니다.");
        }
    }

    private void inputZero(String input) {
        if(input.equals("0")){
            throw new IllegalArgumentException("[ERROR] 0을 입력 하셨습니다.");
        }
    }

    private void changeExist(String input) {
        if(Long.parseLong(input) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 나누어 떨어지는 값을 입력해야 합니다.");
        }
    }
}