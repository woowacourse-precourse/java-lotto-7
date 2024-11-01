package lotto.io.impl;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;
import lotto.io.*;
import lotto.io.enums.*;

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
    public AmountOfLottos inputMoney(int lottoPrize) {

        output.printMsg(LottoInquiryMessage.PURCHASE_AMOUNT_INQUIRY.getMsg());

        AmountOfLottos amountOfLottos = null;
        try{
            amountOfLottos = new AmountOfLottos(Console.readLine().trim(), lottoPrize);
        } catch (IllegalArgumentException e){
            output.printMsg(e.getMessage());
            return inputMoney(lottoPrize);
        }

        return amountOfLottos;
    }

    @Override
    public WinningNumbers inputWinningNumbers() {

        output.printMsg(LottoInquiryMessage.WINNING_NUMBERS_INQUIRY.getMsg());
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
    public BonusNumber inputBonusNumber(WinningNumbers winningNumbers) {

        output.printMsg(LottoInquiryMessage.BONUS_NUMBER_INQUERY.getMsg());

        BonusNumber bonusNumber = null;
        try{
            bonusNumber = new BonusNumber(Console.readLine().trim(), winningNumbers);
        } catch (IllegalArgumentException e) {
            output.printMsg(e.getMessage());
            return inputBonusNumber(winningNumbers);
        }

        return bonusNumber;
    }
}
