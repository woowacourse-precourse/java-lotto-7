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
        result.put(LottoPrize.FIRST, 0);
        result.put(LottoPrize.SECOND, 0);
        result.put(LottoPrize.THIRD, 0);
        result.put(LottoPrize.FOURTH, 0);
        result.put(LottoPrize.FIFTH, 0);
        for (Lotto myLotto : myLottos) {
            LottoPrizeDto lottoPrizeDto = myLotto.matchLottoNumbers(winningLottoDto);
            LottoPrize lottoPrize = lottoPrizeDto.getLottoPrize();
            if (lottoPrize != LottoPrize.NO_RANK) {
                result.put(lottoPrize, result.get(lottoPrize) + 1);
            }
        }
        double wholePrize = 0.0;
        for (LottoPrize lottoPrize : result.keySet()) {
            wholePrize += lottoPrize.calculateWholePrize(result.get(lottoPrize));
        }
        return new LottoResultDto(result, String.format("%.1f", wholePrize / (myLottos.size() * 1000)));
    }
}
