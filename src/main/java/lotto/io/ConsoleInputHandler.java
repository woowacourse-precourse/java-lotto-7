package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.lotto.LottoAmount;
import lotto.lotto.LottoNumber;
import lotto.lotto.WiningNumbers;

public class ConsoleInputHandler implements InputHandler {

    private static final String NUMBER_DELIMITER = ",";

    private final InputConverter inputConverter = new InputConverter();

    @Override
    public LottoAmount inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                return inputConverter.convertToLottoAmount(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public WiningNumbers inputWiningNumbers() {
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                return inputConverter.convertToWiningNumbers(Console.readLine().split(NUMBER_DELIMITER));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public LottoNumber inputBonusNumber() {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                return inputConverter.convertToBonusNumber(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
