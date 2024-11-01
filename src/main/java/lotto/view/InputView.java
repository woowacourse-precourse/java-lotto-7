package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.exception.InvalidInputException;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public Integer inputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw InvalidInputException.invalidNumber();
        }
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");

        try {
            return Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw InvalidInputException.invalidNumber();
        }
    }

    public int inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw InvalidInputException.invalidNumber();
        }
    }
}
