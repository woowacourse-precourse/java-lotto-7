package lotto.Domain;

import static lotto.Util.Constant.GeneralConstants.PERCENT_CONVERSION;
import static lotto.Util.Constant.GeneralConstants.PRIZE_3_MATCH;
import static lotto.Util.Constant.GeneralConstants.PRIZE_4_MATCH;
import static lotto.Util.Constant.GeneralConstants.PRIZE_5_MATCH;
import static lotto.Util.Constant.GeneralConstants.PRIZE_5_MATCH_WITH_BONUS;
import static lotto.Util.Constant.GeneralConstants.PRIZE_6_MATCH;
import static lotto.Util.Constant.GeneralConstants.TICKET_PRICE;

import java.util.List;
import lotto.DTO.BonusNumberDTO;
import lotto.DTO.LottoStatisticsDTO;
import lotto.DTO.RandomLottoNumberDTO;
import lotto.DTO.WinningNumberDTO;

public class PrizeMoneyCalculator {
    private static Double ROUNDING_SCALE = 10.0;

    private int matched3Count = 0;
    private int matched4Count = 0;
    private int matched5Count = 0;
    private int matched5WithBonusCount = 0;
    private int matched6Count = 0;
    private final int lottoPurchaseCount;

    public PrizeMoneyCalculator(Integer lottoPurchaseCount) {
        this.lottoPurchaseCount = lottoPurchaseCount;
    }

    public void calculatePrizeStatistics(WinningNumberDTO winningNumberDTO, BonusNumberDTO bonusNumberDTO,
                                         RandomLottoNumberDTO randomLottoNumberDTO) {
        List<Integer> winningNumbers = winningNumberDTO.getWinningNumber();
        Integer bonusNumber = bonusNumberDTO.getBonusNumber();

        List<Lotto> boughtLottos = randomLottoNumberDTO.getLottoTickets().getTickets();
        for (Lotto boughtLotto : boughtLottos) {
            Integer matchCount = countMatches(winningNumbers, boughtLotto);
            updateMatchCounts(matchCount, bonusNumber, boughtLotto);
        }
    }

    private int countMatches(List<Integer> winningNumbers, Lotto boughtLotto) {
        List<Integer> boughtLottoNumbers = boughtLotto.getNumbers();
        return (int) winningNumbers.stream()
                .filter(boughtLottoNumbers::contains)
                .count();
    }

    private void updateMatchCounts(int matchCount, int bonusNumber, Lotto boughtLotto) {
        if (matchCount == 3) {
            matched3Count++;
        }
        if (matchCount == 4) {
            matched4Count++;
        }
        if (matchCount == 5) {
            matched5Count++;
            checkBonusCount(bonusNumber, boughtLotto.getNumbers());
        }
        if (matchCount == 6) {
            matched6Count++;
        }
    }

    private void checkBonusCount(int bonusNumber, List<Integer> boughtLotto) {
        if (boughtLotto.contains(bonusNumber)) {
            matched5WithBonusCount++;
            matched5Count--;
        }
    }

    public LottoStatisticsDTO calculateProfitRate() {
        int ticketPrice = TICKET_PRICE.getValue();
        int totalPurchaseAmount = lottoPurchaseCount * ticketPrice;

        Integer totalPrizeMoney =
                (matched3Count * PRIZE_3_MATCH.getValue()) +
                        (matched4Count * PRIZE_4_MATCH.getValue()) +
                        (matched5Count * PRIZE_5_MATCH.getValue()) +
                        (matched5WithBonusCount * PRIZE_5_MATCH_WITH_BONUS.getValue()) +
                        (matched6Count * PRIZE_6_MATCH.getValue());

        double profitRate = (double) totalPrizeMoney / totalPurchaseAmount * PERCENT_CONVERSION.getValue();

        return createLottoStatisticsDTO(profitRate);
    }

    private LottoStatisticsDTO createLottoStatisticsDTO(double profitRate) {
        return new LottoStatisticsDTO(matched3Count, matched4Count, matched5Count,
                matched5WithBonusCount, matched6Count, profitRate);
    }
}
