package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InputView {

    private static final int AMOUNT_UNIT = 1000;
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String ERROR_MESSAGE_AMOUNT = "[ERROR] 구입금액은 1000원 단위로 입력해 주세요.";
    private static final String ERROR_MESSAGE_LOTTO_NUMBER = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_BONUS_NUMBER = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자 중 하나를 입력해야 합니다.";


    public int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println(INPUT_AMOUNT_MESSAGE);
                return checkAmount(readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int checkAmount(String input) {
        int amount = 0;
        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_AMOUNT);
        }
        if (amount < AMOUNT_UNIT || amount % AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_AMOUNT);
        }
        return amount;
    }

    public Lotto inputWinningLottoNumbers() {
        while (true) {
            try {
                System.out.println(WINNING_LOTTO_NUMBERS_MESSAGE);
                return new Lotto(
                        Arrays.stream(readLine().split(",")).map(num -> checkWinningLottoNumbers(num.trim()))
                                .collect(Collectors.toList()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public int checkWinningLottoNumbers(String input) {
        int number = 0;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LOTTO_NUMBER);
        }
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LOTTO_NUMBER);
        }
        return number;
    }

    public int inputBonus(Lotto winningLotto) {
        while (true) {
            try {
                System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
                return checkInputBonusNumber(readLine(), winningLotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int checkInputBonusNumber(String input, Lotto winningLotto) {
        int number = 0;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_BONUS_NUMBER);
        }
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE_BONUS_NUMBER);
        }
        winningLotto.checkDuplicate(number);
        return number;
    }
}
