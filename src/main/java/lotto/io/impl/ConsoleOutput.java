package lotto.io.impl;

import lotto.error.LottoErrorMessage;
import lotto.io.LottoOutputMessage;
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

    @Override
    public void printInquiry(LottoOutputMessage msg) {

        System.out.println(msg.getMsg());
    }

    @Override
    public void printErrorMsg(LottoErrorMessage msg) {
        System.out.println("[ERROR] " + msg.getMsg());
    }
}
