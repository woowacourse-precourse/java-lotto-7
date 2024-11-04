package lotto.repository;

import lotto.domain.Lotto;
import lotto.domain.Winning;

import java.util.*;

public class LottoRepository {
    private final List<Lotto> lottos;
    private final Map<Winning, Integer> winningMap;
    private static LottoRepository instance;

    private LottoRepository() {
        lottos = new ArrayList<>();
        winningMap = new EnumMap<>(Winning.class);
        initWinningCount();
    }

    public static LottoRepository getInstance() {
        if (instance == null) {
            instance = new LottoRepository();
        }
        return instance;
    }

    public void incrementWinning(Winning winning) {
        winningMap.put(winning, winningMap.get(winning) + 1);
    }

    private void initWinningCount() {
        for (Winning winning : Winning.values()) {
            winningMap.put(winning, 0);
        }
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> findAllLottos() {
        return lottos;
    }

    public Integer getLottoCount() {
        return lottos.size();
    }

    public Map<Winning, Integer> getWinningMap() {
        return winningMap;
    }

    public Integer getTotalPrize() {
        int totalPrize = 0;
        for (Map.Entry<Winning, Integer> winningIntegerEntry : winningMap.entrySet()) {
            Winning winning = winningIntegerEntry.getKey();
            Integer count = winningIntegerEntry.getValue();
            totalPrize += winning.getPrize() * count;
        }
        return totalPrize;
    }
}
