package controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.Lottos;
import lotto.Winning;
import model.QuantityCalculator;
import model.resultMaker;
import validation.BudgetValidator;
import view.InputView;
import view.OutputView;

import java.util.*;


public class StartLotto {
    public static void run() {
        int budget = inputBudget();
        int quantity = getQuantity(budget);
        ArrayList<List<Integer>> lottos = LottosGenerate(quantity);
        Lottos.sortLottos(lottos);
        InputView.printQuantity(quantity);
        InputView.printLottos(lottos);
        String[] myLottoNumbers = InputView.getInputLotto();
        int bonus = InputView.getBonusNumber();
        Map<Winning, Integer> makeResult = resultMaker.makeResult(lottos, myLottoNumbers, bonus);
        OutputView.printResult(makeResult);
        double profit = resultMaker.makeProfit(makeResult, budget);
        OutputView.printProfit(profit);
    }

    private static int inputBudget() {
        String budget = InputView.getInputBudget();
        try {
            BudgetValidator.validate(budget);
        } catch (IllegalArgumentException e) {
            return inputBudget();
        }
        return Integer.parseInt(budget);
    }

    private static int getQuantity(int budget) {
        return QuantityCalculator.calculateQuantity(budget);
    }

    private static ArrayList<List<Integer>> LottosGenerate(int quantity) {
        ArrayList<List<Integer>> generationResult = new ArrayList<>(quantity);
        for(int i = 0; i < quantity; i++) {
            generationResult.add(singleLottoGenerate());
        }
        return generationResult;
    }

    private static List<Integer> singleLottoGenerate() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}