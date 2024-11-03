package lotto.model;

import static lotto.constants.LottoConstant.WON_1000;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import lotto.dto.LottoBundle;
import lotto.dto.LottoNumbers;
import lotto.dto.LottoEvaluatedStatus;

public class LottoEvaluator {
    private final LottoTicket lottoTicket;
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public LottoEvaluator(LottoTicket lottoTicket, Lotto winningNumbers, int bonusNumber) {
        this.lottoTicket = lottoTicket;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoEvaluatedStatus getEvaluatedStatus(){
        HashMap<LottoPrize, Integer> prize = getPrize();

        LottoBundle lottoBundle = lottoTicket.getLottoBundle();
        int lottoAmount = lottoBundle.getLottoNumbers().size() * WON_1000;
        double returnOnInvestment = calculateReturnOnInvestment(prize, lottoAmount);

        return new LottoEvaluatedStatus(prize, returnOnInvestment);
    }

    private HashMap<LottoPrize, Integer> getPrize() {
        LottoBundle lottoBundle = lottoTicket.getLottoBundle();
        List<LottoNumbers> lottoNumbers = lottoBundle.getLottoNumbers();

        return evaluateTicket(lottoNumbers);
    }

    private HashMap<LottoPrize, Integer> evaluateTicket(List<LottoNumbers> lottoNumbers) {
        HashMap<LottoPrize, Integer> prizeStatus = new HashMap<>();

        initializePrizeStatus(prizeStatus);
        for (LottoNumbers lottoNumber : lottoNumbers) {
            int matchingWinningCount = countMatchingWinningNumbers(lottoNumber);
            int bonusCount = countMatchingBonusNumber(lottoNumber);
            LottoPrize prize = checkPrize(matchingWinningCount, bonusCount);
            updatePrizeStatus(prizeStatus, prize);
        }

        return prizeStatus;
    }

    private void initializePrizeStatus(HashMap<LottoPrize, Integer> prizeStatus) {
        for (LottoPrize prize : LottoPrize.values()) {
            prizeStatus.put(prize, 0);
        }
    }

    private int countMatchingWinningNumbers(LottoNumbers lottoNumbers) {
        List<Integer> lottoNumber = lottoNumbers.getLottoNumbers();
        List<Integer> winningNumber = winningNumbers.getLottoNumbers().getLottoNumbers();
        int count = 0;

        for (Integer number : lottoNumber) {
            if (winningNumber.contains(number)) {
                count++;
            }
        }

        return count;
    }

    private int countMatchingBonusNumber(LottoNumbers lottoNumbers) {
        List<Integer> lottoNumber = lottoNumbers.getLottoNumbers();

        if (lottoNumber.contains(bonusNumber)) {
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

    private void updatePrizeStatus(HashMap<LottoPrize, Integer> prizeStatus, LottoPrize prize) {
        if (prize != null) {
            prizeStatus.put(prize, prizeStatus.get(prize) + 1);
        }
    }

    private double calculateReturnOnInvestment(HashMap<LottoPrize, Integer> prizeStatus, int lottoAmount) {
        Set<LottoPrize> lottoPrizes = prizeStatus.keySet();

        long totalPrize = 0;
        for (LottoPrize lottoPrize : lottoPrizes) {
            long prize = lottoPrize.getPrizeAmounts();
            totalPrize += prize * prizeStatus.get(lottoPrize);
        }

        double returnOnInvestment = (double) totalPrize / lottoAmount * 100;
        return  (double) Math.round(returnOnInvestment * 10) / 10.0;
    }
}
