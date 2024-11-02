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
        System.out.println("구입금액을 입력해 주세요.");
        return inputConverter.convertToLottoAmount(Console.readLine());
    }

    @Override
    public WiningNumbers inputWiningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return inputConverter.convertToWiningNumbers(Console.readLine().split(NUMBER_DELIMITER));
    }

    @Override
    public LottoNumber inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return inputConverter.convertToBonusNumber(Console.readLine());
    }
}
