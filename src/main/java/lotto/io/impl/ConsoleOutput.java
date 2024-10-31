package lotto.io.impl;

import lotto.error.LottoErrorMessage;
import lotto.io.msg.LottoInquiryMessage;
import lotto.io.Output;

import java.util.List;

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
    public void printInquiry(LottoInquiryMessage msg) {

        System.out.println(msg.getMsg());
    }

    @Override
    public void completePurchase(int num) {
        System.out.println(num+ "개를 구매했습니다.");
    }

    @Override
    public void printLotto(List<String> lottoNumbers) {

    }

    @Override
    public void printWinningStatistics() {

    }

    @Override
    public void printErrorMsg(LottoErrorMessage msg) {
        System.out.println("[ERROR] " + msg.getMsg());
    }
}
