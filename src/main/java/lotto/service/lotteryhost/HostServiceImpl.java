package lotto.service.lotteryhost;

import java.util.List;
import lotto.domain.CriteriaTool;
import lotto.service.input.InputService;

public class HostServiceImpl implements HostService {

    private static HostService hostService;

    private final InputService<List<Integer>> ballEntryInputService;
    private final InputService<Integer> luckyNumberInputService;

    private HostServiceImpl(InputService<List<Integer>> ballEntryInputService,
                            InputService<Integer> luckyNumberInputService) {
        this.ballEntryInputService = ballEntryInputService;
        this.luckyNumberInputService = luckyNumberInputService;
    }

    private CriteriaTool winningCriteriaRegister() {
        return WinningCriteriaServiceImpl.getInstance(hostService).config();
    }

    @Override
    public void getReport() {
        PrizeCheckService prizeCheckLogic = new PrizeCheckServiceImpl(winningCriteriaRegister());
        PrizeReportService reportService = new PrizeReportServiceImpl(prizeCheckLogic);

        reportService.updateReport();
    }

    @Override
    public List<Integer> getWinningNumbers() {
        return ballEntryInputService.get();
    }

    @Override
    public Integer getLuckyNumber() {
        return luckyNumberInputService.get();
    }

    public static HostService getInstance(InputService<List<Integer>> ballEntryInputService,
                                          InputService<Integer> luckyNumberInputService) {
        if (hostService == null) {
            hostService = new HostServiceImpl(ballEntryInputService, luckyNumberInputService);
        }
        return hostService;
    }
}
