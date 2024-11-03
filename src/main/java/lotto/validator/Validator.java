package lotto.validator;

public class Validator {

    public static void validateLottoAmountIsPositiveAndDivisibleByThousand(int lottoAmount){

        if (lottoAmount <= 0 || lottoAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 1000원 단위로 입력해 주세요.");
        }

    }
}
