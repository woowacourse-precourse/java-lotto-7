package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import lotto.dto.LottoBundle;
import lotto.dto.LottoNumbers;
import lotto.dto.LottoPrizeStatus;

public class LottoEvaluator {
    private final HashMap<LottoPrize, Integer> prizeStatus = new HashMap<>();

    public LottoEvaluator(LottoTicket lottoTickets, Lotto winningNumbers, int bonusNumbers) {
        LottoBundle lottoBundle = lottoTickets.getLottoTicketStatus();
        List<LottoNumbers> lottoNumbers = lottoBundle.getLottoNumbers();

        initializePrizeStatistics();
        for (LottoNumbers lottoNumber : lottoNumbers) {
            int winningCount = countMatchingNumbers(lottoNumber, winningNumbers);
            int bonusCount = countMatchingBonus(lottoNumber, bonusNumbers);
            LottoPrize prize = checkPrize(winningCount, bonusCount);
            updatePrizeStatistics(prize);
        }
    }

    public LottoPrizeStatus getPrizeStatus(int lottoAmount) {
        double returnOnInvestment = calculateEarningRate(prizeStatus, lottoAmount);
        return new LottoPrizeStatus(prizeStatus, returnOnInvestment);
    }


    private void initializePrizeStatistics() {
        for (LottoPrize prize : LottoPrize.values()) {
            prizeStatus.put(prize, 0);
        }
    }

    private int countMatchingNumbers(LottoNumbers lottoNumbers, Lotto winningNumbers) {
        List<Integer> lottoNumber = lottoNumbers.getLottoNumbers();
        int count = 0;

        for (Integer number : lottoNumber) {
            if (winningNumbers.getLottoNumbers().getLottoNumbers().contains(number)) {
                count++;
            }
        }

        return count;
    }

    private int countMatchingBonus(LottoNumbers lottoNumbers, int bonusNumbers) {
        List<Integer> lottoNumber = lottoNumbers.getLottoNumbers();

        if (lottoNumber.contains(bonusNumbers)) {
            return 1;
        }
        return 0;
    }

    private LottoPrize checkPrize(int winningCount, int bonusCount) {
        for (LottoPrize prize : LottoPrize.values()) {
            if (winningCount == prize.getMatchingWinningCount() && bonusCount == prize.getMatchingBonusCount()) {
                return prize;
            }
        }
        return LottoPrize.FAIL;
    }

    private void updatePrizeStatistics(LottoPrize prize) {
        if (prize != null) {
            prizeStatus.put(prize, prizeStatus.get(prize) + 1);
        }
    }

    private double calculateEarningRate(HashMap<LottoPrize, Integer> prizeStatus, int lottoAmount) {
        Set<LottoPrize> lottoPrizes = prizeStatus.keySet();
        double returnOnInvestment;

        long totalPrize = 0;
        for (LottoPrize lottoPrize : lottoPrizes) {
            long prize = lottoPrize.getPrizeAmounts();
            totalPrize += prize * prizeStatus.get(lottoPrize);
        }

        returnOnInvestment = (double) totalPrize / lottoAmount * 100;
        return  (double) Math.round(returnOnInvestment * 10) / 10.0;
    }
}
