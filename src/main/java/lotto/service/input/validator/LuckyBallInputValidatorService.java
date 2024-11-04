package lotto.service.input.validator;

import java.math.BigInteger;
import java.util.List;

public class LuckyBallInputValidatorService extends CommonValidatorService implements InputValidatorService {

    private final List<String> ballEntry;

    public LuckyBallInputValidatorService(List<String> ballEntry) {
        this.ballEntry = ballEntry;
    }

    @Override
    public void validate(String input) {
        super.validate(input);
        noneNumericCharsExist(input);
        intOverFlow(input);
        isHigherThanBoundary(input);
        isLowerThanBoundary(input);
        sameNumberExistInEntry(input);
    }

    private void noneNumericCharsExist(String input) {
        if (!input.matches("^[0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 문자가 섞여 있습니다.");
        }
    }

    private void intOverFlow(String input) {
        BigInteger inputMoney = new BigInteger(input);
        if (inputMoney.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            throw new IllegalArgumentException("[ERROR] 정수 범위를 넘어가는 숫자가 입력되었습니다.");
        }
    }

    private void isHigherThanBoundary(String input) {
        if (Integer.parseInt(input) > ValidateStatus.MAXIMUM_NUMBER.get()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자를 입력해주십시오.");
        }
    }

    private void isLowerThanBoundary(String input) {
        if (Integer.parseInt(input) < ValidateStatus.MINIMAL_NUMBER.get()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자를 입력해주십시오.");
        }
    }

    private void sameNumberExistInEntry(String input) {
        if (ballEntry.contains(input))  {
            throw new IllegalArgumentException("[ERROR] 한 게임에서 동일한 번호는 입력할 수 없습니다.");
        }
    }
}