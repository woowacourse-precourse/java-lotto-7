package lotto.io.impl;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;
import lotto.io.*;
import lotto.io.msg.*;

import java.util.*;

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
    public AmountOfLottos inputMoney() {

        output.printMsg(LottoInquiryMessage.PURCHASE_AMOUNT_INQUIRY.getMsg());

        AmountOfLottos amountOfLottos = null;
        try{
            amountOfLottos = new AmountOfLottos(Console.readLine().trim());
        } catch (IllegalArgumentException e){
            output.printMsg(e.getMessage());
            return inputMoney();
        }

        return amountOfLottos;
    }

    @Override
    public WinningNumbers inputWinningNumbers() {

        output.printMsg(LottoInquiryMessage.BONUS_NUMBER_INQUERY.getMsg());
        List<Integer> tempWinningNumbers = Arrays.stream(Console.readLine().trim().split(","))
                .map(Integer::parseInt).toList();

        WinningNumbers winningNumbers = null;
        try{
            winningNumbers = new WinningNumbers(tempWinningNumbers);
        } catch (IllegalArgumentException e) {
            output.printMsg(e.getMessage());
            return inputWinningNumbers();
        }

        return winningNumbers;
    }

    @Override
    public BonusNumber inputBonusNumber() {

        /*
        output.printMsg(LottoInquiryMessage.BONUS_NUMBER_INQUERY.getMsg());
        String a = Console.readLine().trim();

        return new BonusNumber();
         */
        return null;
    }
}
