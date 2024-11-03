package global.utils;

import static lotto.constant.LottoStatic.ERROR_MSG_PREFIX;
import static lotto.constant.LottoStatic.PURCHASE_AMOUNT_UNIT;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static void validatePurchaseAmount(String inputPurchaseAmount) {
        BigInteger purchaseAmount;

        plusSignValidate(inputPurchaseAmount);
        blankValidate(inputPurchaseAmount);
        decimalValidate(inputPurchaseAmount);
        //TODO: 0이 앞에 붙어있는지 검사하는 내용 추가
        purchaseAmount = parsingValidate(inputPurchaseAmount);
        greaterThanZeroValidate(purchaseAmount);
        purchaseAmountUnitValidate(purchaseAmount);
    }

    public static void numbersDuplicateValidate(List<Integer> numbers) {
        //FIXME: 이름에 자료형을 쓰지 말 것(Set)
        Set<Integer> numberSet = new HashSet<>(numbers);    //set을 통하면 중복이 제거됨 -> 사이즈가 다르면 중복이 있다는 뜻

        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX + "중복된 값은 불가합니다.");
        }
    }

    public static void validateWeeklyNumbers(String inputWeeklyNumbers) {

        /*
        TODO: 입력된 당첨 번호에 대한 유효성 검사
        +) 쉼표로 나누기
        1. 쉼표로 나눈 결과가 총 6개인지 검사
        2. 나눈 내용에 공백이나 무입력이 있을 수 없다
        3. 나눈 내용이 소수일 수 없다
        4. 나눈 내용이 0보다 작거나 같을 수 없다
        5. 나눈 내용에 +기호가 붙어있을 수 없다
        6. 0이 앞에 붙어있을 수 없다
        7. 나눈 내용이 숫자로 변환 가능해야한다
        +) 변환
        8. 각 숫자가 중복되지 않는지 검사
        9. 각 숫자가 1부터 45 사이의 값인지 검사
         */

    }

    private static void plusSignValidate(String input) {
        if (input.contains("+")) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX + "+ 기호가 포함된 입력은 불가합니다." + input);
        }
    }

    private static void blankValidate(String input) {
        if (input.contains(" ") || input.isBlank()) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX + "공백이 포함된 입력은 불가합니다." + input);
        }
    }

    private static void decimalValidate(String input) {
        if (input.contains(".")) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX + "소수의 입력은 불가합니다." + input);
        }
    }

    //TODO: parsing과 Validate의 간극, 있어야 할 위치 고민
    private static BigInteger parsingValidate(String input) {
        BigInteger parsedValue;

        try {
            parsedValue = new BigInteger(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_MSG_PREFIX + "숫자가 아닌 값은 입력할 수 없습니다.");
        }

        return parsedValue;
    }

    private static void greaterThanZeroValidate(BigInteger value) {
        if (value.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX + "0 이하의 값은 입력할 수 없습니다.");
        }
    }

    private static void purchaseAmountUnitValidate(BigInteger purchaseAmount) {
        if (!purchaseAmount.remainder(BigInteger.valueOf(PURCHASE_AMOUNT_UNIT)).equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX
                    + "%d원 단위의 입력만 가능합니다.".formatted(PURCHASE_AMOUNT_UNIT));
        }
    }
}
