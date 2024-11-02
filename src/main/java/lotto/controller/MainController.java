package lotto.controller;

import lotto.domain.repository.LottoRepository;
import lotto.domain.repository.MoneyManagerRepository;
import lotto.domain.repository.WinLottoRepository;
import lotto.dto.response.PurchaseLottosResponse;
import lotto.dto.response.getLottoResultResponse;
import lotto.service.LottoService;
import lotto.util.Formatter;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class MainController {

    private final LottoRepository lottoRepository = new LottoRepository();
    private final MoneyManagerRepository moneyManagerRepository = new MoneyManagerRepository();
    private final WinLottoRepository winLottoRepository = new WinLottoRepository();
    private final LottoService lottoService = new LottoService(lottoRepository, moneyManagerRepository, winLottoRepository);
    private final LottoController lottoController = new LottoController(lottoService);

    public void start() {
        purchaseLottos();
        setWinLottoNumbers();
        setWinLottoBonusNumber();
        resultLotto();
    }

    private void purchaseLottos() {
        OutputView.inputPurchaseAmount();
        while (true) {
            try {
                PurchaseLottosResponse purchaseLottosResponse = lottoController.purchaseLottos(inputPurchaseAmount());
                OutputView.printPurchaseLottos(purchaseLottosResponse.count());
                OutputView.printIssueAllLottoNumbers(purchaseLottosResponse.allLottosNumbers());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(Formatter.formatToErrorMessage(e.getMessage()));
            }
        }
    }

    private Long inputPurchaseAmount() {
        return Parser.parseStringToLong(InputView.readUserInput());
    }

    private void setWinLottoNumbers() {
        OutputView.inputWinLottoNumbers();
        while (true) {
            try {
                lottoController.setWinLottoNumbers(inputWinLottoNumbers());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(Formatter.formatToErrorMessage(e.getMessage()));
            }
        }
    }

    private List<Integer> inputWinLottoNumbers() {
        return Parser.parseDelimitersInteger(InputView.readUserInput());
    }

    private void setWinLottoBonusNumber() {
        OutputView.inputBonusLottoNumber();
        while (true) {
            try {
                lottoController.setWinLottoBonusNumber(inputBonusNumber());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(Formatter.formatToErrorMessage(e.getMessage()));
            }
        }
    }

    private Integer inputBonusNumber() {
        return Parser.parseStringToInt(InputView.readUserInput());
    }

    private void resultLotto() {
        getLottoResultResponse response = lottoController.getLottoResult();
        OutputView.printLottoResult(response.result());
        OutputView.printLottoReturnRate(response.returnRate());
    }
}
