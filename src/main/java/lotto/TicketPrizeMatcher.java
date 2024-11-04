package lotto;

import static java.lang.Integer.sum;

import java.util.ArrayList;
import java.util.List;
import lotto.MatchCondition.FifthPrize;
import lotto.MatchCondition.FirstPrize;
import lotto.MatchCondition.FourthPrize;
import lotto.MatchCondition.SecondPrize;
import lotto.MatchCondition.ThirdPrize;

// PrizeNumber와 LottoTicket의 List를 전달받아서 당첨 정보를 리턴하는 클래스
public class TicketPrizeMatcher {
    public static final List<MatchCondition> matchConditions = List.of(
            new FirstPrize(),
            new SecondPrize(),
            new ThirdPrize(),
            new FourthPrize(),
            new FifthPrize()
    );

    private final PrizeNumber prizeNumber;
    private final List<LottoTicket> lottoTicketBundle;
    private final Integer bonusNumber;

    public TicketPrizeMatcher(
            PrizeNumber prizeNumber,
            List<LottoTicket> lottoTicketBundle,
            Integer bonusNumber
    ) {
        this.prizeNumber = prizeNumber;
        this.lottoTicketBundle = lottoTicketBundle;
        this.bonusNumber = bonusNumber;
    }

    public MatchResult matchAll() {
        // 당첨번호(PrizeNumber)와 LottoTicket의 수가 일치하는지 확인, 당첨 내역 리턴

        // 구체적으로는, matchConditions를 for-loop 돌면서 매칭되는지 확인.
        List<MatchCondition> matchedConditions = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTicketBundle) {
            MatchCondition matchedCondition = match(lottoTicket);
            if (matchedCondition != null) {
                matchedConditions.add(matchedCondition);
            }
        }

        Double profitRatio = calculateProfitRatio(matchedConditions, lottoTicketBundle.size());
        return new MatchResult(
                matchedConditions,
                profitRatio
        );
    }

    private MatchCondition match(LottoTicket lottoTicket) {
        for (MatchCondition matchCondition : matchConditions) {
            Integer numberCount = matchCondition.getNumberCount();
            Boolean hasBonusNumber = matchCondition.hasBonusNumber();

            List<Integer> ticketNumbers = lottoTicket.getNumbers();
            List<Integer> prizeNumbers = prizeNumber.getNumbers();
            Integer bonusNumber = this.bonusNumber;

            List<Integer> matchedNumbers = ticketNumbers.stream()
                    .filter(prizeNumbers::contains)
                    .toList();
            Integer matchedNumberCount = matchedNumbers.size();

            Boolean isMatched = matchedNumberCount.equals(numberCount);
            Boolean isBonusNumberMatched = prizeNumbers.contains(bonusNumber);
            if (hasBonusNumber) {
                if (isMatched && isBonusNumberMatched) {
                    return matchCondition;
                }
            } else {
                if (isMatched) {
                    return matchCondition;
                }
            }
        }

        return null;
    }

    // 수익률 계산하는 메서드
    private Double calculateProfitRatio(
            List<MatchCondition> matchedConditions,
            Integer ticketCount
    ) {
        int purchasingAmount = ticketCount * 1000;
        int prizedAmount = matchedConditions.stream().mapToInt(MatchCondition::getPrizedAmount).sum();
        double profitRatio = ( (double) (prizedAmount - purchasingAmount) / purchasingAmount ) * 100;
        return Math.round(profitRatio * 100) / 100.0;
    }
}
