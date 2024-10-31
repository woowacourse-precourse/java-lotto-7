package view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import validator.LottoValidator;

public class InputView {
    public static Integer inputCost() {
        System.out.println("구입 금액을 입력해 주세요.");
        String cost = Console.readLine();

        Integer parsedCost = LottoValidator.isNumber(cost);

        return LottoValidator.isDivisibleByThousand(parsedCost);
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();

        List<Integer> parsedNumbers = LottoValidator.isParseableString(numbers);
        List<Integer> validDuplicateNumbers = LottoValidator.isUniqueNumbers(parsedNumbers);

        return LottoValidator.hasSixElements(validDuplicateNumbers);
    }

    public static Integer inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();

        Integer parsedBonusNumber = LottoValidator.isNumber(bonusNumber);

        return LottoValidator.isInLottoRange(parsedBonusNumber);

    }
}
