package view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import validator.LottoValidator;
import util.Parser;

public class InputView {
    public static Integer inputCost() {
        System.out.println("구입 금액을 입력해 주세요.");
        String cost = Console.readLine();

        return Parser.parseCost(cost);
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();

        return Parser.parseWinningNumbers(numbers);

    }

    public static Integer inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();

        return Parser.parseBonusNumber(bonusNumber);

    }
}
