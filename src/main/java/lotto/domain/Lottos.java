package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Lottos {
    public static final int FIRST_PRIZE_AMOUNT = 2000000000;
    public static final int SECOND_PRIZE_AMOUNT = 30000000;
    public static final int THIRD_PRIZE_AMOUNT = 1500000;
    public static final int FOURTH_PRIZE_AMOUNT = 50000;
    public static final int FIFTH_PRIZE_AMOUNT = 5000;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLotto() {
        return Collections.unmodifiableList(lottos);
    }

    public Map<String, Integer> getResult(Lotto winningLotto, int bonusNumber) {
        Map<String, Integer> lottosResult = new HashMap<>(Map.of(
                "1등",0,"2등",0,"3등",0,"4등",0,"5등",0 ,"꽝",0, "총상금",0,"구매금액",0));

        lottosResult.put("총상금", getTotalPrizeMoney(lottosResult));
        lottosResult.put("구매금액", lottos.size()*1000);

        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchingNumbers(winningLotto);
            boolean isMatchBonus = lotto.contains(bonusNumber);
            String rank = determineLottoRank(matchCount,isMatchBonus);

            lottosResult.computeIfPresent(rank, (key,value)-> value+1);
        }

        return lottosResult;
    }

    private String determineLottoRank(int matchCount, boolean isMatchBonus) {
        if (matchCount == 6) {
            return "1등";
        }
        if (matchCount == 5 && isMatchBonus) {
            return "2등";
        }
        if (matchCount == 5) {
            return "3등";
        }
        if (matchCount == 4) {
            return "4등";
        }
        if (matchCount == 3) {
            return "5등";
        }
        return "꽝";
    }

    public double calculateReturns(Map<String, Integer> lottoResult) {
        int usingMoney = lottoResult.get("구매금액");
        double value = getTotalPrizeMoney(lottoResult) / (double) usingMoney * 100;

        return Math.round(value*10)/10.0;
    }

    public int getTotalPrizeMoney(Map<String, Integer> lottoResult) {
        int totalPrize = 0;
        totalPrize += lottoResult.get("1등") * FIRST_PRIZE_AMOUNT;
        totalPrize += lottoResult.get("2등") * SECOND_PRIZE_AMOUNT;
        totalPrize += lottoResult.get("3등") * THIRD_PRIZE_AMOUNT;
        totalPrize += lottoResult.get("4등") * FOURTH_PRIZE_AMOUNT;
        totalPrize += lottoResult.get("5등") * FIFTH_PRIZE_AMOUNT;

        return totalPrize;
    }
}
