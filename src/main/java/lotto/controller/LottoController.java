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

        // 당첨 번호와 보너스 번호 입력을 별도의 메서드로 처리
        WinningLotto winningLotto = inputWinningLotto();

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
        List<Integer> winningNumbersList = inputWinningNumbers();
        int bonusNumber = inputBonusNumber(winningNumbersList);
        return new WinningLotto(winningNumbersList, bonusNumber);
    }

    private List<Integer> inputWinningNumbers() {
        InputLottoNumbersValidator validator = new InputLottoNumbersValidator();
        return Retry.retryOnException(() -> {
            String winningLotto = inputView.getLottoNumbers();
            validator.validateSplitDelimiter(winningLotto);
            String[] winningNumbers = winningLotto.split(DELIMITER);
            List<Integer> numbersList = new ArrayList<>();
            for (String number : winningNumbers) {
                numbersList.add(Integer.parseInt(number.trim()));
            }
            return numbersList;
        });
    }

    private int inputBonusNumber(List<Integer> winningNumbersList) {
        return Retry.retryOnException(() -> {
            String bonusInput = inputView.getBonusNumber();
            int bonus = InputConverter.convertInputNumber(bonusInput);

            // 보너스 번호가 당첨 번호와 중복되지 않는지 검증
            if (winningNumbersList.contains(bonus)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            }
            return bonus;
        });
    }
}
