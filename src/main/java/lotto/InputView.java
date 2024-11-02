package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public static int getPurchaseAmount() {

        System.out.println("구입금액을 입력해 주세요.");
        String inputAmount = Console.readLine();

        return Integer.parseInt(inputAmount);
    }

    public List<String> getWinningNumber() {

        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinningNumber = Console.readLine();
        List<String> winningNumbers = Arrays.asList(inputWinningNumber.split(","));

        return winningNumbers;
    }

    public static int getBonusNumber() {

        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Console.readLine();

        return Integer.parseInt(inputBonusNumber);
    }

}
