package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String REQUEST_PURCHASE_MOUNT = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUM = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUM = "\n보너스 번호를 입력해 주세요.";
    private static final String INPUT_NUMBER_OUT_OF_BOUND = "[ERROR] 1에서 45까지의 숫자만 입력해 주세요.";
    private static final String ARRAY_OUT_OF_BOUND = "[ERROR] 로또번호는 6개 입력해 주세요.";
    private int paidMoney;

    public int purchaseLotto() {
        System.out.println(REQUEST_PURCHASE_MOUNT);
        paidMoney = Integer.parseInt(Console.readLine());
        if (paidMoney % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        return paidMoney;
    }

    public List<Integer> inputWinningNumber() {
        System.out.println(REQUEST_WINNING_NUM);
        List<Integer> winningNumbers = Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        validateInputWinningNumber(winningNumbers);
        return winningNumbers;
    }

    private static void validateInputWinningNumber(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ARRAY_OUT_OF_BOUND);
        }

        for (Integer winningNumber : winningNumbers) {
            if (winningNumber < 1 || winningNumber > 45) {
                throw new IllegalArgumentException(INPUT_NUMBER_OUT_OF_BOUND);
            }
        }
    }

    public int inputBonusNumber() {
        System.out.println(REQUEST_BONUS_NUM);
        int bonusNumber = Integer.parseInt(Console.readLine());

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(INPUT_NUMBER_OUT_OF_BOUND);
        }

        return bonusNumber;
    }

}
