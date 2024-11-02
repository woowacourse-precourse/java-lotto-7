package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.InputProvider.InputProvider;

public class ConsoleInput {
    final private InputProvider inputProvider;

    public ConsoleInput(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    public String getPurchasedAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = inputProvider.readLine();
        System.out.println();
        return input;
    }

    public String getWinnerNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = inputProvider.readLine();
        System.out.println();
        return input;
    }

    public String getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = inputProvider.readLine();
        System.out.println();
        return input;
    }

    public void close() {
        Console.close();
    }

}
