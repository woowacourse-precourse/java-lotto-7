package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.domain.ValueExtractor.convertNumericList;
import static lotto.domain.ValueExtractor.getDelimitedValue;

import java.util.List;
import lotto.domain.Lotto;
import lotto.validator.NumberValidate;

public class InputView {
    public static int getAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = readLine();

                NumberValidate.validateAmount(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Lotto getWinningNumber() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = readLine();
                String[] delimitedValue = getDelimitedValue(input);

                List<Integer> WinningNumber = convertNumericList(delimitedValue);

                return new Lotto(WinningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getBonus() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String input = readLine();

                NumberValidate.validateBonus(input);

                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
