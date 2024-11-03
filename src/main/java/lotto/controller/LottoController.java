package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoTicket;
import lotto.domain.DrawingLotto;
import lotto.domain.DrawingLottoTicket;
import lotto.handler.InputHandler;
import lotto.handler.LottoHandler;
import lotto.handler.OutputHandler;

public class LottoController {
    private static final int PRICE_PER_LOTTO = 1000;
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final LottoHandler lottoHandler;

    public LottoController(InputHandler inputHandler, OutputHandler outputHandler, LottoHandler lottoHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.lottoHandler = lottoHandler;
    }

    public void lottoStart() {
        int purchaseMoney;
        DrawingLottoTicket winningLottoTicket;
        LottoTicket lottoTicket;

        try {
            purchaseMoney = inputHandler.getPurchasePrice();
            winningLottoTicket = makeWinningLottoTicket(purchaseMoney / PRICE_PER_LOTTO);

            outputHandler.printPurchaseResult(purchaseMoney / PRICE_PER_LOTTO, winningLottoTicket.getWinningNumbers());

            lottoTicket = makeLottoTicket();

            List<Double> matchNumbers = lottoHandler.compareNumbers(winningLottoTicket, lottoTicket);
            double rateOfReturn = lottoHandler.calculateRateOfReturn(matchNumbers, purchaseMoney);

            outputHandler.printLottoResult(matchNumbers, rateOfReturn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // 입력된 구입금액 만큼 로또를 발행
    private DrawingLottoTicket makeWinningLottoTicket(int count) {
        List<DrawingLotto> winningNumbers = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            winningNumbers.add(new DrawingLotto());
        }

        return new DrawingLottoTicket(winningNumbers);
    }

    // 입력된 당첨 번호와 보너스 번호로 로또 정보를 발행
    private LottoTicket makeLottoTicket() {
        List<Integer> numbers = inputHandler.getLottoNumber();
        int bonusNumber = inputHandler.getBonusNumber();

        return new LottoTicket(numbers, bonusNumber);
    }
}
