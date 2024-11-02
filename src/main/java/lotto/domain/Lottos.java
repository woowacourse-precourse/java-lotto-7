package lotto.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public final class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public Map<String, Integer> getLottoResult(Lotto winningLotto, int bonusNumber) {
        Map<String, Integer> lottosResult = new HashMap<>(Map.of(
                "1등",0,"2등",0,"3등",0,"4등",0,"5등",0 ,"꽝",0));

        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchingNumbers(winningLotto);
            boolean isMatchBonus = lotto.contains(bonusNumber);
            String rank = getLottoRank(matchCount,isMatchBonus);

            lottosResult.computeIfPresent(rank, (key,value)-> value+1);
        }
        return lottosResult;
    }

    private String getLottoRank(int matchCount, boolean isMatchBonus) {
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


    public double calculateReturns(Map<String, Integer> lottoResult, int usingMoney) {
        double value = getTotalPrizeMoney(lottoResult) / usingMoney * 100;

        return Math.round(value*10)/10.0;
    }
    public double getTotalPrizeMoney(Map<String, Integer> lottoResult) {
        double totalPrize = 0.0;
        totalPrize += lottoResult.get("1등") * 2000000000;
        totalPrize += lottoResult.get("2등") * 30000000;
        totalPrize += lottoResult.get("3등") * 1500000;
        totalPrize += lottoResult.get("4등") * 50000;
        totalPrize += lottoResult.get("5등") * 5000;

        return totalPrize;
    }

    public void printLottoNumber() {
        for (Lotto lotto : lottos)
        System.out.println("["+lotto.getNumbers().stream()
                        .sorted(Comparator.naturalOrder())
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "))+"]");
    }
}
