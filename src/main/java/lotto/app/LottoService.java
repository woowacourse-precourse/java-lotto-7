package lotto.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoPrize;
import lotto.app.dto.LottoResultDto;
import lotto.app.dto.WinningNumberRequestDto;
import lotto.domain.Lotto;
import lotto.domain.PositiveNumber;

public class LottoService {

    private final RandomValueGenerator generator;

    public LottoService(RandomValueGenerator generator) {
        this.generator = generator;
    }

    public List<LottoResultDto> getResult(WinningNumberRequestDto dto, List<Lotto> lottoList) {
        Lotto winningLotto = new Lotto(dto.winningNumbers());

        Map<LottoPrize, Integer> lottoPrizeResult = LottoPrize
            .createLottoPrizeResult(lottoList, winningLotto, dto.bonusNumber());

        return lottoPrizeResult.entrySet().stream()
            .map(entry -> new LottoResultDto(
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

    public double getInvestment(PositiveNumber inputPrice, List<LottoResultDto> dtos) {
        long prizeSum = dtos.stream().mapToLong(dto -> dto.prize() * dto.amount())
            .sum();

        return (double) prizeSum / inputPrice.get();
    }

    private Lotto purchaseLotto() {
        return new Lotto(generator.generate());
    }
}
