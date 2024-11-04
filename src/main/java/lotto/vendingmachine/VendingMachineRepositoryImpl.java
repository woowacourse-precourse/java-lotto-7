package lotto.vendingmachine;

import java.util.List;
import java.util.Map;
import lotto.winning.Rank;

public class VendingMachineRepositoryImpl implements VendingMachineRepository {

    private static List<Lotto> lottoStorage;
    private static Map<Rank, Integer> lottoStatistics;
    private static double earningsRate;

    @Override
    public void save(List<Lotto> lottos) {
        lottoStorage = lottos;
    }

    @Override
    public void saveWinningStatistics(Map<Rank, Integer> statistics) {
        lottoStatistics = statistics;
    }

    @Override
    public void saveEarningRate(double rate) {
        earningsRate = rate;
    }

    @Override
    public List<Lotto> getStoredLottoTickets() {
        return lottoStorage;
    }

    @Override
    public Map<Rank, Integer> getWinningStatistics() {
        return lottoStatistics;
    }

    @Override
    public double getEarningRate() {
        return earningsRate;
    }


}
