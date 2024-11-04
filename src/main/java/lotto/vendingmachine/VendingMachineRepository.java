package lotto.vendingmachine;

import lotto.winning.Rank;

import java.util.List;
import java.util.Map;

public interface VendingMachineRepository {

    void save(List<Lotto> lottos);

    void saveWinningStatistics(Map<Rank, Integer> statistics);

    void saveEarningRate(double rate);

    List<Lotto> getStoredLottoTickets();

    Map<Rank, Integer> getWinningStatistics();

    double getEarningRate();
}
