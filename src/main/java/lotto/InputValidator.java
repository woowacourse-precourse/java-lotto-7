package lotto;

public class InputValidator {

    public void validateBuyLotto(String amount) {
        int lottoAmount = parseInt(amount);

        if (isValidThousandUnit(lottoAmount)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 입력해주세요.");
        }
    }

    private boolean isValidThousandUnit(int amount) {
        return (amount < 1000) || (amount % 1000 != 0);
    }


    private int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 문자가 아닌 숫자를 입력해주세요.");
        }
    }

}
