package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.converter.IntegerConverter;
import lotto.model.BonusNumber;
import lotto.model.LottoPurchase;
import lotto.model.WinningNumbers;
import lotto.parser.StringParser;

public class InputReader {

    public LottoPurchase purchase() {
        System.out.println("구입금액을 입력해 주세요.");
        return LottoPurchase.from(Console.readLine());
    }

    public WinningNumbers winningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        final String input = Console.readLine();
        final List<Integer> numbers = StringParser.numbers(input);
        return WinningNumbers.create(numbers);
    }

    public BonusNumber bonusNumber(final WinningNumbers winningNumbers) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        final String input = Console.readLine();
        final int number = IntegerConverter.getInteger(input);
        return BonusNumber.create(number, winningNumbers);
    }
}
