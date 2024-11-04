package lotto.controller;

import java.util.Map.Entry;
import lotto.domain.Prize;
import lotto.domain.PrizeResult;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoNumber;
import lotto.dto.RandomLottos;
import lotto.dto.WinningLotto;
import lotto.exception.model.LottoExceptionBase;
import lotto.service.LottoService;
import lotto.util.Parser;
import lotto.util.TicketMaker;
import lotto.view.LottoErrorView;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {

    private final LottoService lottoService;
    private final LottoInputView inputView;
    private final LottoOutputView outputView;
    private final LottoErrorView errorView;

    public LottoController(LottoService lottoService, LottoInputView inputView, LottoOutputView outputView,
                           LottoErrorView errorView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
        this.errorView = errorView;
    }

    public void run() {
        int price = requestPrice();
        int ticket = parseToTicket(price);

        outputView.printTicketGuide(ticket);
        RandomLottos randomLottos = lottoService.createRandomLottos(ticket);
        noticeRandomLottos(randomLottos);

        Lotto winningNumbers = requestWinningNumber();
        LottoNumber bonus = requestBonus();

        WinningLotto winningLotto = createWinningLotto(winningNumbers, bonus);
        calculatePrizeResult(randomLottos, winningLotto, price);
    }

    private int requestPrice() {
        try {
            String priceInput = inputView.getPriceInput();

            return Parser.parseToInt(priceInput);
        } catch (LottoExceptionBase e) {
            errorView.printErrorMessage(e.getMessage());

            return requestPrice();
        }
    }

    private int parseToTicket(int price) {
        try {
            return TicketMaker.make(price);
        } catch (LottoExceptionBase e) {
            errorView.printErrorMessage(e.getMessage());

            return requestPrice();
        }
    }

    private void noticeRandomLottos(RandomLottos randomLottos) {
        for (Lotto lotto : randomLottos.lottos()) {
            outputView.printNumbers(lotto.getNumberValues());
        }
    }

    private Lotto requestWinningNumber() {
        try {
            String winningNumberInput = inputView.getWinningNumberInput();

            return lottoService.createWinningLottoNumbers(winningNumberInput);
        } catch (LottoExceptionBase e) {
            errorView.printErrorMessage(e.getMessage());

            return requestWinningNumber();
        }
    }

    private LottoNumber requestBonus() {
        try {
            String bonusInput = inputView.getBonusInput();

            return new LottoNumber(Parser.parseToInt(bonusInput));
        } catch (LottoExceptionBase e) {
            errorView.printErrorMessage(e.getMessage());

            return requestBonus();
        }
    }

    private WinningLotto createWinningLotto(Lotto winningNumbers, LottoNumber bonus) {
        try {
            return lottoService.createWinningLotto(winningNumbers, bonus);
        } catch (LottoExceptionBase e) {
            errorView.printErrorMessage(e.getMessage());
            LottoNumber newBonus = requestBonus();

            return createWinningLotto(winningNumbers, newBonus);
        }
    }

    private void calculatePrizeResult(RandomLottos randomLottos, WinningLotto winningLotto, int price) {
        PrizeResult prizeResult = lottoService.calculateResult(randomLottos, winningLotto);

        outputView.printGuideMessage();
        for (Entry<Prize, Integer> prize : prizeResult.getEntrySet()) {
            outputView.printWinningResults(
                    prize.getKey().getMatchingCount(), prize.getKey().getMoney(),
                    prize.getValue(), prize.getKey().isMatchBonus());
        }

        outputView.printTotalReturn(prizeResult.calculateReturn(price));
    }
}
