package lotto.view;

import static lotto.message.ExceptionMessage.DUPLICATED_NUMBER;
import static lotto.message.ExceptionMessage.DUPLICATED_WITH_WINNING_NUMBERS;
import static lotto.message.ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT;
import static lotto.message.ExceptionMessage.OUT_OF_RANGE_LOTTO_NUMBER;
import static lotto.message.ExceptionMessage.WRONG_NUMBER_FORMAT;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class InputView {
    public static int readInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 번호는 숫자만 입력할 수 있습니다.");
            return readInputMoney();
        }
    }

    public static List<Integer> readAndSplitNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = new ArrayList<>();

        for (String splitString : Console.readLine().split(",")) {
            try {
                int number = Integer.parseInt(splitString.trim());

                if (number < 1 && number > 45) {
                    throw new IllegalArgumentException(OUT_OF_RANGE_LOTTO_NUMBER.getMessage());
                }

                if (numbers.contains(number)) {
                    throw new IllegalArgumentException(DUPLICATED_NUMBER.getMessage());
                }
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(WRONG_NUMBER_FORMAT.getMessage());
            }
        }

        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }

        return Collections.unmodifiableList(numbers);
    }

    public static int readBonusNumber(Lotto LottoNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_NUMBER_FORMAT.getMessage());
        }

        if (LottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_WITH_WINNING_NUMBERS.getMessage());
        }
        if (bonusNumber < 1 && bonusNumber > 45) {
            throw new IllegalArgumentException(OUT_OF_RANGE_LOTTO_NUMBER.getMessage());
        }
        return bonusNumber;
    }
}
