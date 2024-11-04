package lotto.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.dto.LottoPrizeDto;
import lotto.dto.LottoResultDto;
import lotto.dto.WinningLottoDto;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoPrize;

public class LottoResultService {
    public LottoResultDto resultFrom(WinningLottoDto winningLottoDto, List<Lotto> myLottos) {
        Map<LottoPrize, Integer> result = new HashMap<>();
        initializedResult(result);
        countPrize(result, winningLottoDto, myLottos);

        double wholePrize = calculateWholePrize(result);
        String winningRate = String.format("%.1f", (wholePrize / (myLottos.size() * 1000)) * 100);
        return new LottoResultDto(result, winningRate);
    }

    private double calculateWholePrize(Map<LottoPrize, Integer> result) {
        double wholePrize = 0.0;
        for (LottoPrize lottoPrize : result.keySet()) {
            wholePrize += lottoPrize.calculateWholePrize(result.get(lottoPrize));
        }
        return wholePrize;
    }

    private void initializedResult(Map<LottoPrize, Integer> result) {
        result.put(LottoPrize.FIRST, 0);
        result.put(LottoPrize.SECOND, 0);
        result.put(LottoPrize.THIRD, 0);
        result.put(LottoPrize.FOURTH, 0);
        result.put(LottoPrize.FIFTH, 0);
    }

    private void addPrize(Map<LottoPrize, Integer> result, LottoPrize lottoPrize) {
        boolean isGotPrize = lottoPrize != LottoPrize.NO_RANK;
        if (isGotPrize) {
            result.put(lottoPrize, result.get(lottoPrize) + 1);
        }
    }

    private void countPrize(Map<LottoPrize, Integer> result, WinningLottoDto winningLottoDto, List<Lotto> myLottos) {
        for (Lotto myLotto : myLottos) {
            LottoPrizeDto lottoPrizeDto = myLotto.matchLottoNumbers(winningLottoDto);
            LottoPrize lottoPrize = lottoPrizeDto.getLottoPrize();
            addPrize(result, lottoPrize);
        }
    }
}
