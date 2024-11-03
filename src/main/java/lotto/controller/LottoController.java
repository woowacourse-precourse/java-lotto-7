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

public class LottoController {
    private int totalCount;
    private List<Lotto> lottos;

    public LottoController() {
        this.totalCount = 0;
        this.lottos = new ArrayList<>();
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
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

    public static void setTotalCount(LottoController lottoController){
        int totalCount = readTotalAmount();
        try{
            totalCount = checkTotalAmountIfValid(totalCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setTotalCount(lottoController);
        }
        lottoController.totalCount = totalCount;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public static List<Integer> changeStringListToIntList(List<String> stringList) {
        List<Integer> intList = new ArrayList<>();
        for (String s : stringList)
            intList.add(Integer.valueOf(s));
        return intList;
    }

    public static void checkRange(List<Integer> numbers){
        for (Integer number : numbers) {
            if (number > 45 || number < 1) {
                throw new IllegalArgumentException(Error_Messages.NUMBER_RANGE_ERROR);
            }
        }
    }

    public static void checkWinningLotto(WinningLotto winningLotto){
        List<Integer> numbers = winningLotto.getNumbers();
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(Error_Messages.DUPLICATE_ERROR);
        }
        checkRange(numbers);
    }

    public static WinningLotto makeWinningLotto() {
        List<String> inputNumbers = readWinningNumbers();
        List<Integer> numbers = changeStringListToIntList(inputNumbers);
        try {
            Lotto lotto = new Lotto(numbers);
            WinningLotto winningLotto = new WinningLotto(lotto);
            checkWinningLotto(winningLotto);
            return winningLotto;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            makeWinningLotto();
        }
        return null;
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

    public static void getSummary(LottoController lottoController, WinningLotto winningLotto) {
        CalculateResult calculator = new CalculateResult(winningLotto);
        calculator.calculateMatches(lottoController.getLottos());
        calculator.getTotalResult();
    }
}


