package lotto.io;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputHandler implements InputHandler {

    private static final String NUMBER_DELIMITER = ",";

    @Override
    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    @Override
    public List<Integer> inputLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] splitNumbers = Console.readLine().split(NUMBER_DELIMITER);
        return Arrays.stream(splitNumbers)
                .map(Integer::parseInt)
                .toList();
    }

    @Override
    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
