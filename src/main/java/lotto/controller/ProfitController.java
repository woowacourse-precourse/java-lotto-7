package lotto.controller;

import lotto.dto.BonusNumberRequestDto;
import lotto.dto.WinningNumbersRequestDto;
import lotto.model.Lottos;
import lotto.model.Prize;
import lotto.model.PrizeRank;
import lotto.service.matching.MatchingService;
import lotto.service.calculate.ProfitService;
import lotto.view.OutputView;

import java.util.Map;

public class ProfitController {

    public static void run(Lottos lottos, WinningNumbersRequestDto winningNumbersRequestDto, BonusNumberRequestDto bonusNumberRequestDto) {
        MatchingService matchingService = new MatchingService(winningNumbersRequestDto, bonusNumberRequestDto);

        for (int i = 0; i < lottos.getLottosSize(); i++) {
            matchingService.determineAndCountPrize(lottos.getLotto(i));
        }
        Map<PrizeRank, Prize> prizeMap = matchingService.getPrizeMap();

        OutputView.displayPrizeResults(prizeMap);

        ProfitService profitService = new ProfitService(prizeMap, lottos.getLottosSize()*1000);
        double profitRate = profitService.calculateProfitRate();

        OutputView.displayProfitRate(profitRate);
    }
}
