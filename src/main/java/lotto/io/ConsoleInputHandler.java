package lotto.io;

import java.util.function.Function;

import camp.nextstep.edu.missionutils.Console;
import lotto.lotto.LottoAmount;
import lotto.lotto.LottoNumber;
import lotto.lotto.WiningNumbers;

public class ConsoleInputHandler implements InputHandler {

    private static final String NUMBER_DELIMITER = ",";

    private final InputConverter inputConverter = new InputConverter();

    @Override
    public LottoAmount inputPurchaseAmount() {
        return retryInput("구입금액을 입력해 주세요.", inputConverter::convertToLottoAmount);
    }

    @Override
    public WiningNumbers inputWiningNumbers() {
        return retryInput("\n당첨 번호를 입력해 주세요.",
                input -> inputConverter.convertToWiningNumbers(input.split(NUMBER_DELIMITER)));
    }

    @Override
    public LottoNumber inputBonusNumber() {
        return retryInput("\n보너스 번호를 입력해 주세요.", inputConverter::convertToBonusNumber);
    }

    private <T> T retryInput(String message, Function<String, T> converter) {
        while (true) {
            try {
                System.out.println(message);
                return converter.apply(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
