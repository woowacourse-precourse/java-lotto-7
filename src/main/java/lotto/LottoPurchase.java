package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static lotto.ErrorMessages.*;

public class LottoPurchase {
    private int purchaseAmount;
    private int purchaseCount;
    private WinningLotto winningLotto;

    public void inputAmount() {
        System.out.println("구입금액을 입력해주세요");
        String userInputAmount = Console.readLine();
        inputAmount(userInputAmount);
    }

    public void inputAmount(String userInputAmount) {
        if (!userInputAmount.matches("\\d+")) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        }
        int inputAmount = Integer.parseInt(userInputAmount);

        validateInputAmount(inputAmount);
        purchaseAmount = inputAmount;
        purchaseCount = inputAmount / 1000;
    }

    private void validateInputAmount(int inputAmount) {
        if (inputAmount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_NOT_1000_MULTIPLE);
        }
        if (inputAmount < 1000) {
            throw new IllegalArgumentException(ERROR_MIN_PURCHASE_AMOUNT);
        }

    }

    public void inputLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInputLottoNumber = Console.readLine();
        System.out.println("보너스 번호를 입력해 주세요.");
        String userInputBonusNumber = Console.readLine();
        inputLottoNumber(userInputLottoNumber, userInputBonusNumber);

    }

    public void inputLottoNumber(String userInputLottoNumber, String userInputBonusNumber) {
        if (!userInputLottoNumber.matches("^\\d+(?:,\\d+)*$")) {
            throw new IllegalArgumentException(ERROR_INVALID_LOTTO_FORMAT);
        }
        if (!userInputBonusNumber.matches("\\d+")) {
            throw new IllegalArgumentException(ERROR_INVALID_BONUS_NUMBER);
        }
        winningLotto = new WinningLotto(splitLottoNumber(userInputLottoNumber), Integer.parseInt(userInputBonusNumber));
    }

    private List<Integer> splitLottoNumber(String userInputLottoNumber) {
        return Arrays.stream(userInputLottoNumber.split(",")).map(Integer::parseInt).toList();
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }
}
