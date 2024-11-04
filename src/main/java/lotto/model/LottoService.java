package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.enums.LottoRank;
import lotto.util.FormatString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {
    public LottoService() {
    }

    public List<Lotto> getLottos(int numOfTickets) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numOfTickets; i++) {
            lottos.add(new Lotto(generateLottoNumbers()));
        }

        return lottos;
    }

    public List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));

        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }

    public List<LottoRank> getRanks(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        List<LottoRank> ranks = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            boolean bonusMatched = lotto.getNumbers().contains(bonusNumber);
            ranks.add(LottoRank.valueOf(matchCount, bonusMatched));
        }

        return ranks;
    }

    public String getPrizeResult(List<LottoRank> ranks) {
        StringBuilder result = new StringBuilder();

        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                result.append(rank.getDescription())
                        .append(" (")
                        .append(FormatString.formatPrize(rank.getPrize()))
                        .append("원) - ")
                        .append(getRankCount(ranks, rank))
                        .append("개\n");
            }
        }

        return result.toString();
    }

    public String getProfitRateResult(List<LottoRank> ranks, int purchaseAmount) {
        StringBuilder result = new StringBuilder();

        double profitRate = getProfitRate(ranks, purchaseAmount);

        result.append("총 수익률은 ")
                .append(FormatString.formatProfitRate(profitRate))
                .append("%입니다.\n");

        return result.toString();
    }

    private double getProfitRate(List<LottoRank> ranks, int purchaseAmount) {
        int totalPrize = 0;
        for (LottoRank rank : ranks) {
            totalPrize += rank.getPrize();
        }

        return (totalPrize / (double) purchaseAmount) * 100;
    }

    private int getRankCount(List<LottoRank> ranks, LottoRank rank) {
        return Collections.frequency(ranks, rank);
    }
}
