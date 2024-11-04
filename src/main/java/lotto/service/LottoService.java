package lotto.service;

import static lotto.constant.LottoConstant.BONUS_NUMBER_CHECK_CRITERIA;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.dto.LottoMatchResult;
import lotto.domain.Prize;
import lotto.dto.WinningLottoNum;

public class LottoService {

    public List<Lotto> generateLottoTickets(int lottoAmount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lottoTicket = new Lotto(lottoNumbers);
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    public List<Prize> calculateLottoResult(List<Lotto> lottoTickets, WinningLottoNum winningLotto) {
        List<Prize> prizes = new ArrayList<>();

        for (Lotto lottoTicket : lottoTickets) {
            LottoMatchResult lottoMatchResult = matchLottoNums(lottoTicket, winningLotto);
            Prize prize = calculatePrize(lottoMatchResult);

            if(prize != null) {
                prize.incrementCount();
                prizes.add(prize);
            }
        }
        return prizes;
    }

    public BigDecimal calculateProfit(int purchaseAmount, List<Prize> prizes) {
        BigDecimal totalPrizeAmount = BigDecimal.ZERO;
        BigDecimal purchase = BigDecimal.valueOf(purchaseAmount);

        for (Prize prize : prizes) {
            BigDecimal prizeAmount = BigDecimal.valueOf(prize.getPrizeAmount());
            totalPrizeAmount = totalPrizeAmount.add(prizeAmount);
        }

        BigDecimal profit = totalPrizeAmount.divide(purchase, 3, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("100"));

        BigDecimal roundedProfit = profit.setScale(1, BigDecimal.ROUND_HALF_UP);
        return roundedProfit;
    }

    private LottoMatchResult matchLottoNums(Lotto lottoTicket, WinningLottoNum winningLottoNum) {
        List<Integer> lottoNums = lottoTicket.getNumbers();
        List<Integer> winningNums = winningLottoNum.getWinningLotto().getNumbers();
        int bonusNumber = winningLottoNum.getBonusNum();
        int matchCount = 0;

        for (Integer lottoNum : lottoNums) {
            if(winningNums.contains(lottoNum)) {
                matchCount++;
            }
        }
        boolean bounsMatch = matchCount == BONUS_NUMBER_CHECK_CRITERIA && lottoNums.contains(bonusNumber);
        return new LottoMatchResult(matchCount, bounsMatch);
    }

    private Prize calculatePrize(LottoMatchResult lottoMatchResult) {
        int matchCount = lottoMatchResult.getMatchCount();
        Boolean bonusMatch = lottoMatchResult.getBonusMatch();

        for(Prize prize: Prize.values()) {
            if(prize.getMatchCount() == matchCount && prize.getBonusMatch() == bonusMatch) {
                return prize;
            }
        }
        return null;
    }
}
