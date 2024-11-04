package lotto.model.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.dto.LottoWinningNumbersDto;
import lotto.dto.LottosDto;
import lotto.dto.RankResultDto;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoWinningNumbers;
import lotto.model.domain.Lottos;
import lotto.model.domain.Money;
import lotto.util.BigDecimalUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static lotto.global.Constants.*;
import static lotto.global.PrizeRank.fromRank;

public class LottoService {

    public LottosDto buyLottos(long purchaseAmount) {
        Money money = new Money(purchaseAmount);
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < calculatePurchasableLottoCount(money); i++) {
            lottoList.add(generateLottoNumber());
        }

        return new LottosDto(new Lottos(lottoList));
    }

    public List<RankResultDto> calculateResults(LottoWinningNumbersDto winningNumbersDto, LottosDto purchasedLottosDto) {
        LottoWinningNumbers winningNumbers = new LottoWinningNumbers(winningNumbersDto);
        Lottos purchasedLottos = new Lottos(purchasedLottosDto);

        return purchasedLottos.getLottos().stream()
                .map(lotto -> new RankResultDto(lotto.calculateResult(winningNumbers).getRank()))
                .toList();
    }

    private int calculatePurchasableLottoCount(Money money) {
        return (int) (money.getAmount() / LOTTO_PRICE);
    }

    private Lotto generateLottoNumber() {
        List<Integer> numbers =
                Randoms.pickUniqueNumbersInRange(
                        MINIMUM_LOTTO_NUMBER,
                        MAXIMUM_LOTTO_NUMBER,
                        LOTTO_NUMBERS_COUNT);

        return new Lotto(numbers);
    }

    public double calculateProfitRate(List<RankResultDto> rankResults) {
        BigDecimal totalPrize = calculateTotalPrize(rankResults);
        BigDecimal totalSpent = calculateTotalSpent(rankResults.size());

        BigDecimal profitRate = BigDecimalUtil.divideAndMultiplyByPercentage(totalPrize, totalSpent);

        return BigDecimalUtil.roundToDecimalPlaces(profitRate, PROFIT_RATE_ROUNDING_SCALE);
    }

    private BigDecimal calculateTotalPrize(List<RankResultDto> rankResults) {
        return rankResults.stream()
                .map(result -> BigDecimal.valueOf(fromRank(result.rank()).getPrize()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculateTotalSpent(int ticketCount) {
        return BigDecimal.valueOf(ticketCount).multiply(BigDecimal.valueOf(LOTTO_PRICE));
    }

}