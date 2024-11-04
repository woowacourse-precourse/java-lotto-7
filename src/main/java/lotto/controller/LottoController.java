package lotto.controller;

import lotto.dto.LottoResultDTO;
import lotto.dto.LottoStatisticsDTO;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.service.LottoService;
import lotto.utils.InputConverter;
import lotto.utils.Retry;
import lotto.validator.InputLottoNumbersValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    private static final String DELIMITER = ",";

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        InputLottoNumbersValidator validator = new InputLottoNumbersValidator();

        // 예산 입력을 예외 처리와 함께 재시도
        String input = Retry.retryOnException(() -> {
            String budgetInput = inputView.getBudget();
            validator.validateBudget(budgetInput);
            return budgetInput;
        });
        int budget = InputConverter.convertInputNumber(input);
        Lottos userLottos = purchaseLottos(budget);

        outputView.printLottoNumbers(userLottos.toDtoList(), budget);

        // 당첨 번호와 보너스 번호 입력을 예외 처리와 함께 재시도
        WinningLotto winningLotto = Retry.retryOnException(this::inputWinningLotto);
        LottoResultDTO resultDTO = lottoService.checkWinnings(userLottos, winningLotto);
        outputView.printWinningResults(resultDTO);

        LottoStatisticsDTO statisticsDTO = lottoService.calculateProfitRate(budget, resultDTO.getTotalPrize());
        outputView.printProfitRate(statisticsDTO);
    }


    private Lottos purchaseLottos(int purchaseAmount) {
        int lottoCount = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.generateRandomLotto());
        }
        return new Lottos(lottos);
    }

    private WinningLotto inputWinningLotto() {
        InputLottoNumbersValidator validator = new InputLottoNumbersValidator();
        String winningLotto = inputView.getLottoNumbers();
        validator.validateSplitDelimiter(winningLotto);
        String[] winningNumbers = winningLotto.split(DELIMITER);
        List<Integer> winningNumbersList = new ArrayList<>();
        for (String number : winningNumbers) {
            winningNumbersList.add(Integer.parseInt(number.trim()));
        }

        int bonusNumber = Integer.parseInt(inputView.getBonusNumber());
        return new WinningLotto(winningNumbersList, bonusNumber);
    }
}
