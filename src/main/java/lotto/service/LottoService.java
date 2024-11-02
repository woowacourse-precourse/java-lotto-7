package lotto.service;

import static lotto.constant.core.LottoServiceConstant.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constant.category.Rank;
import lotto.model.RankCounter;
import lotto.model.domain.Lotto;
import lotto.model.domain.WinningLotto;
import lotto.util.random.RandomUtil;

public class LottoService {

    private final RandomUtil randomUtil;

    public LottoService(RandomUtil randomUtil) {
        this.randomUtil = randomUtil;
    }

    public Integer calculateLottoCount(Integer lottoPurchaseAmount) {
        return lottoPurchaseAmount / LOTTO_PRICE.getIntegerValue();
    }

    public WinningLotto createWinningTicket(List<Integer> numbers, Integer bonusNumber) {
        return WinningLotto.of(numbers, bonusNumber);
    }

    public List<Lotto> createLottoTickets(Integer lottoCount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lottoTicket = createLottoTicket();
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    public RankCounter determineWinning(WinningLotto winningTicket, List<Lotto> lottoTickets) {
        RankCounter rankCounter = RankCounter.create();
        for (Lotto lottoTicket : lottoTickets) {
            int matchCount = compareWinningNumbers(winningTicket.getNumbers(), lottoTicket);
            boolean isBonusNumberMatched = compareBonusNumber(winningTicket.getBonusNumber(), lottoTicket);
            Rank rank = Rank.getRankByMatch(matchCount, isBonusNumberMatched);
            rankCounter.increaseRankCount(rank);
        }
        return rankCounter;
    }

    public double calculateEarningRate(RankCounter rankCounter, Integer lottoPurchaseAmount) {
        double totalPrizeAmount = calculateTotalPrizeAmount(rankCounter);
        double earningRate = totalPrizeAmount / lottoPurchaseAmount * 100;
        return roundToDecimalPlaces(earningRate);
    }

    private Lotto createLottoTicket() {
        List<Integer> numbers = new ArrayList<>(randomUtil.issueLottoTicket(
                MIN_LOTTO_NUMBER.getIntegerValue(),
                MAX_LOTTO_NUMBER.getIntegerValue(),
                LOTTO_NUMBER_COUNT.getIntegerValue()));
        sortNumbersAscending(numbers);
        return Lotto.of(numbers);
    }

    private void sortNumbersAscending(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    private int compareWinningNumbers(List<Integer> winningNumbers, Lotto lottoTicket) {
        int count = 0;
        for (Integer lottoNumber : lottoTicket.getNumbers()) {
            if (winningNumbers.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    private boolean compareBonusNumber(Integer bonusNumber, Lotto lottoTicket) {
        return lottoTicket.getNumbers().contains(bonusNumber);
    }

    private double calculateTotalPrizeAmount(RankCounter rankCounter) {
        double totalPrizeAmount = 0.0;
        for (Rank rank : Rank.values()) {
            Integer rankCount = rankCounter.getRankCount(rank);
            Integer prizeAmount = rank.getPrizeAmount();
            totalPrizeAmount += rankCount * prizeAmount;
        }
        return totalPrizeAmount;
    }

    private double roundToDecimalPlaces(double value) {
        BigDecimal roundedValue = new BigDecimal(value)
                .setScale(EARNING_RATE_DECIMAL_PLACE.getIntegerValue(), RoundingMode.HALF_UP);
        return roundedValue.doubleValue();
    }
}
