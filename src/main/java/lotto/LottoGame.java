package lotto;

import java.util.Arrays;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_COST = 1000;

    private final MyLotto myLotto;

    public LottoGame(String money) {
        validateMoney(money);
        int lottoCount = Integer.parseInt(money) / LOTTO_COST;
        this.myLotto = new MyLotto(lottoCount);
    }

    public void matchNumbers(String string) {
        String[] winningNumberString = string.split(",");
        validateWinningNumber(winningNumberString);

        List<Integer> winningNumbers = Arrays.stream(winningNumberString)
                .map(Integer::parseInt)
                .toList();
    }

    public void printMyLotto() {
        myLotto.print();
    }

    private void validateMoney(String money) {
        if (!isInteger(money)) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
        }
        if (Integer.parseInt(money) % LOTTO_COST != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 " + LOTTO_COST + " 단위여야 합니다.");
        }
    }

    private void validateWinningNumber(String[] winningNumberString) {
        boolean hasInvalidNumber = Arrays.stream(winningNumberString)
                .anyMatch(num -> !isInteger(num));

        if(hasInvalidNumber) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }
    }

    private boolean isInteger(String money) {
        try {
            Integer.parseInt(money);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
