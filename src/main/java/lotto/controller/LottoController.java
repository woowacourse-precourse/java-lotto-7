package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import lotto.config.FilterConfig;
import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class LottoController {
    private static final String DELIMITER = ",";

    private final LottoService lottoService;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, OutputView outputView) {
        this.lottoService = lottoService;
        this.outputView = outputView;
    }

    public void start() {
        LottoTickets lottoTickets = getPurchasedLottoTickets();
        displayPurchasedTickets(lottoTickets);
        Lotto winningLottoWithoutBonusNumber = getWinningLotto();
        WinningLotto winningLotto = getBonusNumber(winningLottoWithoutBonusNumber);

        LottoStatistics lottoStatistics = calculateLottoStatistics(lottoTickets, winningLotto);
        displayStatistics(lottoStatistics);
        Console.close();
    }

    private LottoTickets getPurchasedLottoTickets() {
        return executeWithRetry(() -> {
            outputView.printInputAmountNotice();
            String amountInput = Console.readLine();
            FilterConfig.getInstance().getPositiveIntegerFilterChain().doFilter(amountInput);
            int amount = Integer.parseInt(amountInput);
            return lottoService.purchaseTickets(amount);
        });
    }

    private Lotto getWinningLotto() {
        return executeWithRetry(() -> {
            outputView.printInputWinningLottoNotice();
            String winningLottoInput = Console.readLine();
            FilterConfig.getInstance().getCommaSeparatedNumberFilterChain().doFilter(winningLottoInput);
            return Lotto.create(separateInputWinningLotto(winningLottoInput));
        });
    }

    private WinningLotto getBonusNumber(Lotto winningLottoWithoutBonusNumber) {
        return executeWithRetry(() -> {
            outputView.printInputBonusNumberNotice();
            String bonusNumberInput = Console.readLine();
            FilterConfig.getInstance().getPositiveIntegerFilterChain().doFilter(bonusNumberInput);
            return lottoService.createWinningNumbers(
                    winningLottoWithoutBonusNumber,
                    Integer.parseInt(bonusNumberInput)
            );
        });
    }

    private <T> T executeWithRetry(Callable<T> callable) {
        while (true) {
            try {
                return callable.call();
            } catch (NoSuchElementException error) {
                throw error;
            } catch (Exception error) {
                System.out.println(error.getMessage());
            }
        }
    }

    private LottoStatistics calculateLottoStatistics(LottoTickets lottoTickets, WinningLotto winningLotto) {
        return lottoService.collectResults(lottoTickets, winningLotto);
    }

    private void displayPurchasedTickets(LottoTickets lottoTickets) {
        outputView.printPurchasedLotto(lottoTickets);
    }

    private void displayStatistics(LottoStatistics lottoStatistics) {
        double returnRate = lottoService.calculateProfitRate(lottoStatistics);
        outputView.printLottoStatistics(lottoStatistics, returnRate);
    }

    private List<Integer> separateInputWinningLotto(String winningLottoNumbersInput) {
        return Arrays.stream(winningLottoNumbersInput.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
