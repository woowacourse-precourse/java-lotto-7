package lotto.service.lotteryhost;

import java.util.List;

public interface HostService {
    void getReport();
    List<Integer> getWinningNumbers();
    Integer getLuckyNumber();
}
