package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.dto.LottoPurchasesDto;
import lotto.dto.LottoResultDto;
import lotto.dto.LottoResultMessageDto;
import lotto.dto.WinningLottoDto;
import lotto.model.domain.InputValidator;
import lotto.model.domain.Lotto;
import lotto.model.service.GenerateMessageService;
import lotto.model.service.LottoResultService;
import lotto.model.service.MyLottosGenerateService;
import lotto.view.InputView;
import lotto.view.InputViewFactory;
import lotto.view.LottoPurchasesView;
import lotto.view.LottoResultView;
import lotto.view.OutputView;

public class LottoController {

    private InputView inputView;
    private OutputView outputView;
    private final MyLottosGenerateService lottoGenerateService;
    private final LottoResultService lottoResultService;

    public LottoController(InputView inputView, OutputView outputView,
                           MyLottosGenerateService lottoGenerateService,
                           LottoResultService lottoResultService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGenerateService = lottoGenerateService;
        this.lottoResultService = lottoResultService;
    }

    public void run() {
        String input;
        InputValidator inputValidator = new InputValidator();
        inputView.showRequestMessage();
        while (true) {
            try {
                input = inputView.getInput();
                inputValidator.validateInputAmount(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int amount = Integer.parseInt(input);
        List<Lotto> myLottos = lottoGenerateService.generateLottos(amount);
        GenerateMessageService generateMessageService = new GenerateMessageService();
        LottoPurchasesDto lottoPurchasesDto = generateMessageService.generatePurchasesMessage(myLottos);

        outputView = new LottoPurchasesView(lottoPurchasesDto);
        outputView.display();

        inputView = InputViewFactory.createInputView(InputViewFactory.WINNING_NUMBER);
        inputView.showRequestMessage();
        Lotto lotto;
        while (true) {
            try {
                input = inputView.getInput();
                inputValidator.validateInputWinningNumber(input);
                List<Integer> winningNumbers = Arrays.stream(input.split(","))
                        .map(Integer::parseInt).toList();
                lotto = new Lotto(winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        inputView = InputViewFactory.createInputView(InputViewFactory.BONUS_NUMBER);
        inputView.showRequestMessage();
        WinningLottoDto winningLottoDto;
        while (true) {
            try {
                input = inputView.getInput();
                inputValidator.validateInputBonusNumber(input);
                int bonusNumber = Integer.parseInt(input);
                winningLottoDto = lotto.generateWinningLotto(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        LottoResultDto lottoResultDto = lottoResultService.resultFrom(winningLottoDto, myLottos);
        LottoResultMessageDto lottoResultMessageDto = generateMessageService.generateResultMessage(lottoResultDto);
        outputView = new LottoResultView(lottoResultMessageDto);
        outputView.display();
    }
}
