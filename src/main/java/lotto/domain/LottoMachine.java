package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.CountMatchNumbers;
import lotto.dto.GeneratedNumbers;
import lotto.dto.InputNumbers;
import lotto.dto.WinningNumbersStatics;
import lotto.dto.WinningResultStatics;
import lotto.factory.WinningConditionFactory;
import lotto.vo.WinningConditions;

public class LottoMachine {

    private final LottoNumbersComparison lottoNumbersComparison;
    private final ProfitCalculator profitCalculator;

    public LottoMachine() {
        lottoNumbersComparison = new LottoNumbersComparison();
        profitCalculator = new ProfitCalculator();
    }

    public WinningResultStatics runMachine(GeneratedNumbers generatedNumbers, InputNumbers inputNumbers,
                                           int numberOfTickets) {
        List<CountMatchNumbers> CountMatchNumbers = lottoNumbersComparison.countingWinning(generatedNumbers,
                inputNumbers);
        List<WinningConditions> winningConditions = WinningConditionFactory.initializeConditions();

        return getWinningStatics(winningConditions, CountMatchNumbers, numberOfTickets);
    }

    private WinningResultStatics getWinningStatics(List<WinningConditions> winningConditions,
                                                   List<CountMatchNumbers> countMatchNumbers, int numberOfTickets) {

        List<WinningNumbersStatics> winningNumbersStatics = new ArrayList<>();
        int prizeSum = 0;
        for (WinningConditions winningCondition : winningConditions) {
            winningNumbersStatics.add(storeWinningNumbersStatics(winningCondition, countMatchNumbers));
            prizeSum += getWinningPrizeStatics(winningCondition, countMatchNumbers);
        }

        return new WinningResultStatics(winningNumbersStatics, profitCalculator.calculateProfit(prizeSum,numberOfTickets));
    }

    private WinningNumbersStatics storeWinningNumbersStatics(WinningConditions winningCondition,
                                                             List<CountMatchNumbers> countMatchNumbers) {
        int matchNumbersCounting = 0;
        for (CountMatchNumbers countMatchNumbersPerTurn : countMatchNumbers) {
            if (winningCondition.getWinningNumbersConditions() == countMatchNumbersPerTurn.getWinningNumbers()
                    && winningCondition.getWinningBonusCondition()
                    == countMatchNumbersPerTurn.getWinningBonusNumber()) {
                matchNumbersCounting++;
            }
        }
        return new WinningNumbersStatics(matchNumbersCounting);
    }

    private int getWinningPrizeStatics(WinningConditions winningCondition,
                                       List<CountMatchNumbers> countMatchNumbers) {
        int prizePerTurn = 0;
        for (CountMatchNumbers countMatchNumbersPerTurn : countMatchNumbers) {
            prizePerTurn += winningCondition.match(countMatchNumbersPerTurn.getWinningNumbers(),
                    countMatchNumbersPerTurn.getWinningBonusNumber());
        }
        return prizePerTurn;

    }
}
