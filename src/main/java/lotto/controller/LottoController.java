package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.dto.LottoPurchasesDto;
import lotto.dto.LottoResultMessageDto;
import lotto.dto.WinningLottoDto;
import lotto.model.domain.InputValidator;
import lotto.model.domain.Lotto;
import lotto.model.service.LottoService;
import lotto.view.InputView;
import lotto.view.InputViewFactory;
import lotto.view.LottoPurchasesView;
import lotto.view.LottoResultView;
import lotto.view.OutputView;

public class LottoController {

    private InputView inputView;
    private OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        InputValidator inputValidator = new InputValidator();
        int amount = getAmount(inputValidator);
        LottoPurchasesDto lottoPurchasesDto = lottoService.purchaseLottos(amount);
        displayOutputView(new LottoPurchasesView(lottoPurchasesDto));
        Lotto lotto = getWinningLottoNumbers(inputValidator);
        WinningLottoDto winningLottoDto = getWinningLottoDto(inputValidator, lotto);
        LottoResultMessageDto lottoResultMessageDto = lottoService.matchMyLottoWith(winningLottoDto);
        displayOutputView(new LottoResultView(lottoResultMessageDto));
    }

    private void displayOutputView(OutputView outputView) {
        this.outputView = outputView;
        this.outputView.display();
    }

    private WinningLottoDto getWinningLottoDto(InputValidator inputValidator, Lotto lotto) {
        showRequestMessageByTypeOf(InputViewFactory.BONUS_NUMBER);
        while (true) {
            try {
                String input = inputView.getInput();
                inputValidator.validateInputBonusNumber(input);
                int bonusNumber = Integer.parseInt(input);
                return lotto.generateWinningLotto(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto getWinningLottoNumbers(InputValidator inputValidator) {
        showRequestMessageByTypeOf(InputViewFactory.WINNING_NUMBER);
        while (true) {
            try {
                String input = inputView.getInput();
                inputValidator.validateInputWinningNumber(input);
                List<Integer> winningNumbers = Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getAmount(InputValidator inputValidator) {
        showRequestMessageByTypeOf(InputViewFactory.AMOUNT);
        while (true) {
            try {
                String input = inputView.getInput();
                inputValidator.validateInputAmount(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void showRequestMessageByTypeOf(String type) {
        inputView = InputViewFactory.createInputViewOf(type);
        inputView.showRequestMessage();
    }
}
