package lotto.service.lotteryhost;

import java.util.List;
import lotto.domain.CriteriaTool;
import lotto.domain.PrizeCheckMachine;

public class WinningCriteriaServiceImpl implements WinningCriteriaService<CriteriaTool> {

    private static WinningCriteriaServiceImpl instance;
    private final HostService hostService;

    private WinningCriteriaServiceImpl(HostService hostService) {
        this.hostService = hostService;
    }

    @Override
    public CriteriaTool config() {
        return new PrizeCheckMachine(winningNumbersConfig(),luckyNumbersConfig());
    }

    private List<Integer> winningNumbersConfig() {
        return hostService.getWinningNumbers();
    }

    private Integer luckyNumbersConfig() {
        return hostService.getLuckyNumber();
    }

    public static WinningCriteriaServiceImpl getInstance(HostService hostService) {
        if (instance == null) {
            instance = new WinningCriteriaServiceImpl(hostService);
        }
        return instance;
    }
}
