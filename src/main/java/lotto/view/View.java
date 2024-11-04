package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class View {


    public String input() {
        return Console.readLine();
    }
    public String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return input();
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }
}
