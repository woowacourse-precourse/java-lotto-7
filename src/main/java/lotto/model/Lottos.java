package lotto.model;

import lotto.enumerate.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos init(List<List<Integer>> numbers) {
        List<Lotto> lottos = convertToLottoList(numbers);
        return new Lottos(lottos);
    }

    public int getBuyLottoQuantity() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private static List<Lotto> convertToLottoList(List<List<Integer>> numbers) {
        return numbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    public Map<Rank, Integer> findLottoRanks(WinNumber winNumber) {
        Map<Rank, Integer> currentRankSituationMap = new HashMap<>();

        for (Lotto lotto : lottos) {
            Rank rank = lotto.findRank(winNumber);
            currentRankSituationMap.put(rank, currentRankSituationMap.getOrDefault(rank, 0) + 1);
        }

        return currentRankSituationMap;
    }
}
