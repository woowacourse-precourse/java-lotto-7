package lotto.io.impl;

import lotto.io.Output;

public class ConsoleOutput implements Output {

    public ConsoleOutput() {

    }

    public void printPurchaseAmount() {

        System.out.println("구입금액을 입력해 주세요.");
    }


}
