package lotto.controller;

import static lotto.view.input.readBonusNumber;
import static lotto.view.input.readTotalAmount;
import static lotto.view.input.readWinningNumbers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.CalculateResult;
import lotto.model.Lotto;
import lotto.constants.Error_Messages;
import lotto.model.WinningLotto;

public class lottoController {
    public static int checkTotalAmountIfValid(int totalAmount) {
        if (totalAmount <= 0)
            throw new IllegalArgumentException(Error_Messages.INPUT_NOT_POSITIVE_INT);
        else if (totalAmount < 1000) {
            throw new IllegalArgumentException(Error_Messages.INPUT_TOTAL_AMOUNT_NOT_LARGER_THAN_1000);
        } else if (totalAmount % 1000 == 0) {
            return totalAmount / 1000;
        } else {
            throw new IllegalArgumentException(Error_Messages.INPUT_TOTAL_AMOUNT_ERROR);
        }
    }

    public static int totalCount(){
        int totalCount = readTotalAmount();
        try{
            checkTotalAmountIfValid(totalCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            totalCount();
        }
        return totalCount;
    }

    public static List<Integer> changeStringListToIntList(List<String> stringList) {
        List<Integer> intList = new ArrayList<>();
        for (String s : stringList)
            intList.add(Integer.valueOf(s));
        return intList;
    }

    public static WinningLotto makeWinningLotto(List<String> numbers) {
        List<Integer> winningNumbers = changeStringListToIntList(numbers);
        WinningLotto winningLotto = new WinningLotto();
        winningLotto.setNumbers(winningNumbers);
        return winningLotto;
    }

    public static void checkNoDuplicate(List<String> number){
        Set<String> set = new HashSet<>(number);
        if (set.size() != number.size()){
            throw new IllegalArgumentException(Error_Messages.DUPLICATE_ERROR);
        }
    }

    public static WinningLotto winningLotto() {
        List<String> number = readWinningNumbers();
        try {
            checkNoDuplicate(number);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            winningLotto();
        }
        return makeWinningLotto(number);
    }

    private static void checkBonusNumber(WinningLotto winningLotto, int number){
        if (winningLotto.getNumbers().contains(number)) {
            throw new IllegalArgumentException(Error_Messages.DUPLICATE_ERROR);
        }
    }

    public static void bonusNumber(WinningLotto winningLotto){
        int bonusNumber = readBonusNumber();
        try{
            checkBonusNumber(winningLotto, bonusNumber);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            bonusNumber(winningLotto);
        }
        winningLotto.setBonusNumber(bonusNumber);
    }

    public static void getSummary(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        CalculateResult calculator = new CalculateResult(winningLotto, bonusNumber);
        calculator.calculateMatches(lottos);
//        calculator.getTotalResult();
    }
}


