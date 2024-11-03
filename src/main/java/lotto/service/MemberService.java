package lotto.service;

import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.Member;
import lotto.enums.lotto.LottoRank;
import lotto.util.LottoParser;

public class MemberService {

    private final Member member = Member.getInstance();

    public void calculateReturnOfRate() {
        Map<LottoRank, Integer> lottoResults = member.getLottoResults();
        int purchaseAmount = member.getPurchaseAmount();
        int totalPrize = calculateTotalPrize(lottoResults);

        member.saveReturnOfRate(LottoParser.parsingRate(totalPrize, purchaseAmount));
    }

    private int calculateTotalPrize(Map<LottoRank, Integer> lottoResults) {
        int totalPrize = 0;
        for (Entry<LottoRank, Integer> entry : lottoResults.entrySet()) {
            totalPrize += entry.getKey().getPrize() * entry.getValue();
        }
        return totalPrize;
    }
}
