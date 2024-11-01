package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
        WinningLotto winningLotto = getWinningLotto();
        LottoStatistics lottoStatistics = calculateLottoStatistics(lottoTickets, winningLotto);
        displayStatistics(lottoStatistics);
        Console.close();
    }

    private LottoTickets getPurchasedLottoTickets() {
        outputView.printInputAmount();
        int amount = Integer.parseInt(Console.readLine());
        return lottoService.purchaseTickets(amount);
    }

    private void displayPurchasedTickets(LottoTickets lottoTickets) {
        outputView.printBuyingLotto(lottoTickets);
    }

    private WinningLotto getWinningLotto() {
        outputView.printInputWinningLotto();
        List<Integer> winningNumbers = validate(Console.readLine());
        outputView.printInputBonusNumber();
        int bonusNumber = Integer.parseInt(Console.readLine());
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private LottoStatistics calculateLottoStatistics(LottoTickets lottoTickets, WinningLotto winningLotto) {
        return lottoService.checkResults(lottoTickets, winningLotto);
    }

    private void displayStatistics(LottoStatistics lottoStatistics) {
        double returnRate = lottoService.calculateProfitRate(lottoStatistics);
        outputView.printLottoStatistics(lottoStatistics, returnRate);
    }

    public List<Integer> validate(String winningLottoNumbers) {
        try {
            return Arrays.stream(winningLottoNumbers.split(DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 숫자를 입력해 주세요.");
        }
    }
}
