package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.RandomNumbersGenerator;

public class LottoGame {
    public static final String ERROR_PURCHASE_INPUT_NOT_NUMBER = "[ERROR] 구입금액 입력이 숫자가 아닙니다.";
    public static final String ERROR_PURCHASE_INPUT_NOT_POSITIVE = "[ERROR] 구입금액은 음수가 될수 없습니다.";
    public static final String ERROR_PURCHASE_INPUT_WRONG_UNIT = "[ERROR] 구입금액은 1000원 단위로 입력되어야 합니다.";
    private final List<Lotto> lottos;
    private final RandomNumbersGenerator numbersGenerator;
    private int purchase;

    public LottoGame() {
        this.lottos = new ArrayList<>();
        this.numbersGenerator = new RandomNumbersGenerator();
    }

    public void purchaseLottos(int purchase) {
        this.purchase = purchase;
        lottosFactory(numbersGenerator);
    }

    public void validatePurchaseInput(String input) throws IllegalArgumentException {
        int amount;
        amount = tryParse(input);
        isNegativeNumber(amount);
        isDividedClearly(amount);
    }

    private static void isDividedClearly(int amount) throws IllegalArgumentException {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_PURCHASE_INPUT_WRONG_UNIT);
        }
    }

    private static void isNegativeNumber(int amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException(ERROR_PURCHASE_INPUT_NOT_POSITIVE);
        }
    }

    private static int tryParse(String input) throws IllegalArgumentException {
        int amount;
        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PURCHASE_INPUT_NOT_NUMBER);
        }
        return amount;
    }

    private void lottosFactory(RandomNumbersGenerator numbersGenerator) {
        for (int i = 0; i < this.purchase; i++) {
            this.lottos.add(new Lotto(numbersGenerator));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
