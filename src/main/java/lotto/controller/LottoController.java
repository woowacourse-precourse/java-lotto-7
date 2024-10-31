package lotto.controller;

import static lotto.constant.LottoConstant.LOTTO_PRICE;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.enumerate.Prize;
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
        List<Lotto> purchasedLottos = lottoService.generateLottoTickets(lottoAmount);
        outputView.printGeneratedLottoTickets(lottoAmount, purchasedLottos);

        Lotto winningLotto = getWinningLotto();
        int bonusNumber = getBonusNumber(); //DTO 만들기
        List<Prize> prizes = lottoService.calculateLottoResult(purchasedLottos, winningLotto, bonusNumber);
        Map<Prize, Integer> totalPrizeCount = lottoService.totalPrizeResult(prizes);

        outputView.printTotalLottoResult(totalPrizeCount);

        BigDecimal bigDecimal = lottoService.calculateProfit(purchaseAmount, prizes);
        outputView.printTotalProfit(bigDecimal);
    }

    private int getPurchaseAmount() {
        int purchaseAmount = inputView.getPurchaseAmount();
        lottoValidator.purchaseAmountValidator(purchaseAmount);

        return purchaseAmount;
    }

    private int getLottoTicketAmount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    private Lotto getWinningLotto() {
        return inputView.getWinningLotto();
    }

    private int getBonusNumber() {
        return inputView.getBonusNumber();
    }
}
