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
        DrawingLottoTicket drawingLottoTicket;
        LottoTicket lottoTicket;

        try {
            purchaseMoney = inputHandler.getPurchasePrice();
            drawingLottoTicket = makeDrawingLottoTicket(purchaseMoney / PRICE_PER_LOTTO);

            outputHandler.printPurchaseResult(purchaseMoney / PRICE_PER_LOTTO, drawingLottoTicket.getDrawingNumbers());

            lottoTicket = makeLottoTicket();

            List<Double> matchNumbers = lottoHandler.compareNumbers(drawingLottoTicket, lottoTicket);
            double rateOfReturn = lottoHandler.calculateRateOfReturn(matchNumbers, purchaseMoney);

            outputHandler.printLottoResult(matchNumbers, rateOfReturn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // 입력된 구입금액 만큼 로또를 발행
    private DrawingLottoTicket makeDrawingLottoTicket(int count) {
        List<DrawingLotto> drawingNumbers = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            drawingNumbers.add(new DrawingLotto());
        }

        return new DrawingLottoTicket(drawingNumbers);
    }

    // 입력된 당첨 번호와 보너스 번호로 로또 정보를 발행
    private LottoTicket makeLottoTicket() {
        List<Integer> numbers = inputHandler.getLottoNumber();
        int bonusNumber = inputHandler.getBonusNumber();

        return new LottoTicket(numbers, bonusNumber);
    }
}
