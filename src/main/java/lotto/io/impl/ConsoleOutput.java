package lotto.io.impl;

import lotto.io.Output;

public class ConsoleOutput implements Output {

    private static ConsoleOutput output;

    private ConsoleOutput() {

    }

    public static ConsoleOutput getInstance(){
        if(output == null)
            output = new ConsoleOutput();

        return output;
    }

    public void printPurchaseAmount() {

        System.out.println("구입금액을 입력해 주세요.");
    }


}
