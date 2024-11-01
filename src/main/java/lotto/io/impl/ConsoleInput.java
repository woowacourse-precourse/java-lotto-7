package lotto.io.impl;

import camp.nextstep.edu.missionutils.Console;
import lotto.io.Input;
import lotto.io.msg.LottoInquiryMessage;
import lotto.io.Output;

public class ConsoleInput implements Input {

    private static ConsoleInput input;

    private final Output output;

    private ConsoleInput(Output output) {
        this.output = output;
    }

    public static ConsoleInput getInstance(Output output) {
        if(input == null)
            input = new ConsoleInput(output);

        return input;
    }

    @Override
    public String inputMoney() {

        output.printInquiry(LottoInquiryMessage.PURCHASE_AMOUNT_INQUIRY);
        return Console.readLine().trim();
    }

    @Override
    public String[] inputWinningNumbers() {

        output.printInquiry(LottoInquiryMessage.BONUS_NUMBER_INQUERY);
        return Console.readLine().trim().split(",");
    }

    @Override
    public String inputBonusNumber() {

        output.printInquiry(LottoInquiryMessage.BONUS_NUMBER_INQUERY);
        return "";
    }
}
