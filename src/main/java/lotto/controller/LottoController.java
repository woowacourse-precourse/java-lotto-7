package lotto.controller;

import static lotto.constant.LottoConstant.LOTTO_PRICE;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.service.LottoService;
import lotto.validator.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoValidator lottoValidator;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView, LottoValidator lottoValidator) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoValidator = lottoValidator;
    }

    public void startLottoProcess() {
        int purchaseAmount = getPurchaseAmount();
        int lottoAmount = getLottoTicketAmount(purchaseAmount);
        List<Lotto> purchasedLottos = generateAndPrintLottoTickets(lottoAmount);

        Lotto winningLotto = getWinningLotto();
        int bonusNumber = getBonusNumber();
        List<Prize> prizes = lottoService.calculateLottoResult(purchasedLottos, winningLotto, bonusNumber);
        Map<Prize, Integer> totalPrizeCount = lottoService.totalPrizeResult(prizes);
        outputView.printTotalLottoResult(totalPrizeCount);

        printTotalProfit(purchaseAmount, prizes);
    }

    private int getPurchaseAmount() {
        while(true) {
            try {
                String purchaseAmountInput = inputView.getPurchaseAmount();
                return lottoValidator.purchaseAmountValidate(purchaseAmountInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getLottoTicketAmount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    private Lotto getWinningLotto() {
        while(true) {
            try {
                String[] winningLottoInput = inputView.getWinningLotto();
                return lottoValidator.winningLottoValidate(winningLottoInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBonusNumber() {
        while(true) {
            try {
                String bonusNumberInput = inputView.getBonusNumber();
                return lottoValidator.bonusNumberValidate(bonusNumberInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> generateAndPrintLottoTickets(int lottoAmount) {
        List<Lotto> purchasedLottos = lottoService.generateLottoTickets(lottoAmount);
        outputView.printGeneratedLottoTickets(lottoAmount, purchasedLottos);
        return purchasedLottos;
    }

    private void printTotalProfit(int purchaseAmount, List<Prize> prizes) {
        BigDecimal bigDecimal = lottoService.calculateProfit(purchaseAmount, prizes);
        outputView.printTotalProfit(bigDecimal);
    }
}
