package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String readPurchaseAmount() {
        System.out.println("구입금액을 입력해주세요.");
        return Console.readLine();
    }

    public String[] readWinningLotto() {
        System.out.println("당첨 번호를 입력해주세요.");
        String rawWinningNumbers = Console.readLine();
        return parseNumbers(rawWinningNumbers);
    }

    private String[] parseNumbers(String rawWinningNumbers) {
        return rawWinningNumbers.split(",");
    }
}
