package lotto.controller;

import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.processor.BonusProcessor;
import lotto.processor.Processor;
import lotto.processor.WinNumbersProcessor;
import lotto.service.WinService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class WinController {
    private final WinService winService;

    public WinController(WinService winService) {
        this.winService = winService;
    }

    public void win(Money money){
        List<Integer> winNumbers = getWinNumbers();
        System.out.println();
        int bonus = getBonusNumbers(winNumbers);
        System.out.println();

        Map<Rank, Integer> result = winService.win(winNumbers, bonus);
        double profit = winService.getProfit(money);

        OutputView.printResult(result, profit);
    }
    public List<Integer> getWinNumbers(){
        Processor<List<Integer>> winNumbersProcessor = new WinNumbersProcessor();
        return winNumbersProcessor.process();
    }
    public int getBonusNumbers(List<Integer> winNumbers){
        Processor<Integer> bonusProcessor = new BonusProcessor(winNumbers);
        return bonusProcessor.process();
    }
}
