package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InputView {

    private static final int AMOUNT_UNIT = 1000;
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ERROR_MESSAGE_AMOUNT = "[ERROR] 구입금액은 1000원 단위로 입력해 주세요.";
    private static final String ERROR_MESSAGE_LOTTO_NUMBER = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";


    public int inputPurchaseAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
        return checkAmount(readLine());
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

    public void inputLottoNumbers() {
        Lotto lotto = new Lotto(
                Arrays.stream(readLine().split(",")).map(num -> checkInputLottoNumbers(num))
                        .collect(Collectors.toList()));
    }

    public int checkInputLottoNumbers(String input) {
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
}
