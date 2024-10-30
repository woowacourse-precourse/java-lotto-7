package lotto.handler;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    private static final String ERROR_INVALID_NUMBER_FORMAT_MESSAGE = "[ERROR] 숫자 형식이 올바르지 않습니다. 다시 입력해 주세요.";
    private static final String ERROR_INPUT_MONEY_NEGATIVE_MESSAGE = "[ERROR] 구입금액은 0보다 커야 합니다.";
    private static final String ERROR_LOTTO_NUMBER_RANGE_MESSAGE = "[ERROR] 로또 번호는 1~45 범위여야 합니다.";
    private static final String ERROR_BONUS_NUMBER_RANGE_MESSAGE = "[ERROR] 보너스 번호는 1~45 범위여야 합니다.";

    public int setInputMoney() {
        try {
            int inputMoney = Integer.parseInt(Console.readLine());
            if (inputMoney <= 0) {
                throw new IllegalArgumentException(ERROR_INPUT_MONEY_NEGATIVE_MESSAGE);
            }
            return inputMoney;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER_FORMAT_MESSAGE);
        }
    }

    public List<Integer> setInputLottoNumbers() {
        String inputString = Console.readLine();
        List<Integer> lottoWinnerNumbers = new ArrayList<>();
        String[] lottoNumbers = inputString.split(",");

        for (String number : lottoNumbers) {
            int num = Integer.parseInt(number.trim());
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE_MESSAGE);
            }
            lottoWinnerNumbers.add(num);
        }
        return lottoWinnerNumbers;
    }

    public int setBonusNumber() {
        int bonusNumber = Integer.parseInt(Console.readLine());
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER_RANGE_MESSAGE);
        }
        return bonusNumber;
    }
}
