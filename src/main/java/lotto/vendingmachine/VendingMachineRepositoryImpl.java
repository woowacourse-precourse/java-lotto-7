package lotto.vendingmachine;

import lotto.draw.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachineRepositoryImpl implements VendingMachineRepository {

    private static List<Lotto> lottoStorage = new ArrayList<>();
    private static Map<Rank, Integer> lottoStatistics = new HashMap<>();

    @Override
    public void save(List<Lotto> lottos) {
        lottoStorage.addAll(lottos);
    }

    @Override
    public void saveWinningStatistics(Map<Rank, Integer> statistics) {
        lottoStatistics = statistics;
    }

    @Override
    public List<Lotto> getStoredLottoTickets() {
        return lottoStorage;
    }

    public Map<Rank, Integer> getWinningStatistics() {
        return lottoStatistics;
    }
}
