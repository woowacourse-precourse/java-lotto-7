package lotto.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoPrize;
import lotto.app.dto.LottoResultResponseDto;
import lotto.app.dto.WinningNumberRequestDto;
import lotto.domain.Lotto;
import lotto.domain.PositiveNumber;

public class LottoService {

    private final RandomValueGenerator generator;

    public LottoService(RandomValueGenerator generator) {
        this.generator = generator;
    }

    public List<LottoResultResponseDto> getResult(WinningNumberRequestDto dto, List<Lotto> lottoList) {
        Lotto winningLotto = new Lotto(dto.winningNumbers());

        Map<LottoPrize, Integer> lottoPrizeResult = LottoPrize
            .createLottoPrizeResult(lottoList, winningLotto, dto.bonusNumber());

        return lottoPrizeResult.entrySet().stream()
            .map(entry -> new LottoResultResponseDto(
                entry.getKey().getWinningCount(),
                entry.getKey().getPrize(),
                entry.getValue()))
            .toList();
    }

    public List<Lotto> purchaseAll(PositiveNumber amount) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int round = 0; round < amount.get(); round++) {
            lottoList.add(purchaseLotto());
        }

        return lottoList;
    }

    public double getInvestment(Integer inputPrice, Map<LottoPrize, Integer> prizeIntegerMap) {
        long result = prizeIntegerMap.entrySet().stream()
            .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
            .sum();

        return (double) result / inputPrice;
    }

    private Lotto purchaseLotto() {
        return new Lotto(generator.generate());
    }
}
