package lotto.controller;

import static lotto.view.input.printWhiteSpace;
import static lotto.view.input.readBonusNumber;
import static lotto.view.input.readWinningNumbers;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.constants.Error_Messages;

public class lottoController {
    public static int checkTotalAmountIfValid(int totalAmount){
        if (totalAmount <= 0)
            throw new IllegalArgumentException(Error_Messages.INPUT_NOT_POSITIVE_INT);
        else if (totalAmount < 1000) {
            throw new IllegalArgumentException(Error_Messages.INPUT_TOTAL_AMOUNT_NOT_LARGER_THAN_1000);
        } else if (totalAmount % 1000 == 0) {
            return totalAmount / 1000;
        }
        else {
            throw new IllegalArgumentException(Error_Messages.INPUT_ERROR);
        }
    }

    public static List<Integer> changeStringListToIntList(List<String> stringList){
        List<Integer> intList = new ArrayList<>();
        for(String s : stringList) intList.add(Integer.valueOf(s));
        return intList;
    }

    public static Lotto makeWinningLotto(List<String> numbers){
        List<Integer> winningNumbers = changeStringListToIntList(numbers);
        return new Lotto(winningNumbers);
    }

    public static Lotto winningLotto(){
        List<String> number = readWinningNumbers();
        printWhiteSpace();
        return makeWinningLotto(number);
    }

    public static int bonusNumber(){
        return readBonusNumber();
    }


}
