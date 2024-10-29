package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.MatchCondition.FifthPrize;
import lotto.MatchCondition.FirstPrize;
import lotto.MatchCondition.FourthPrize;
import lotto.MatchCondition.SecondPrize;
import lotto.MatchCondition.ThirdPrize;

// PrizeNumber와 LottoTicket의 List를 전달받아서 당첨 정보를 리턴하는 클래스
public class TicketPrizeMatcher {
    private static final List<MatchCondition> matchConditions = List.of(
            new FirstPrize(),
            new SecondPrize(),
            new ThirdPrize(),
            new FourthPrize(),
            new FifthPrize()
    );

    private final PrizeNumber prizeNumber;
    private final List<LottoTicket> lottoTickets;

    public TicketPrizeMatcher(
            PrizeNumber prizeNumber,
            List<LottoTicket> lottoTickets
    ) {
        this.prizeNumber = prizeNumber;
        this.lottoTickets = lottoTickets;
    }

    public MatchResult matchAll() {
        // 당첨번호(PrizeNumber)와 LottoTicket의 수가 일치하는지 확인, 당첨 내역 리턴

        // 구체적으로는, matchConditions를 for-loop 돌면서 매칭되는지 확인.
        List<MatchCondition> matchedConditions = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            MatchCondition matchedCondition = match(lottoTicket);
            if (matchedCondition != null) {
                matchedConditions.add(matchedCondition);
            }
        }

        Double profitRatio = calculateProfitRatio(matchedConditions, 0);
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
            Integer bonusNumber = prizeNumber.getBonusNumber();

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
            Integer purchasingAmount
    ) {
        return 0.0;
    }
}
