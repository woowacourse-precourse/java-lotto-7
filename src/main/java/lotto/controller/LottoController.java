package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.model.LottoDrawMachine;
import lotto.model.LottoPurchaseMachine;
import lotto.model.LottoWinningStatics;
import lotto.util.parser.InputParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputParser inputParser;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.inputParser = new InputParser();
    }

    public void run() {
        //구매 금액 요청
        inputView.requestPurchaseAmount();
        String purchaseAmountInput = inputView.inputPurchaseAmount();
        int purchaseAmount = inputParser.convertPurchaseAmountToInt(purchaseAmountInput);

        //lotto 생성
        LottoPurchaseMachine lottoPurchaseMachine = new LottoPurchaseMachine(purchaseAmount);
        List<Lotto> lottos = lottoPurchaseMachine.generateLottoTickets();

        outputView.printLottoTickets(lottos);

        //승리 번호 입력 받기
        inputView.requestWinningNumber();
        String winNum = inputView.inputWinningNumber();
        List<Integer> winNumList = inputParser.getWinNumList(winNum);

        inputView.requestWinningBounusNumber();
        String bonusNum1 = inputView.inputWinningBonusNumber();
        int bonusNum = inputParser.convertWinningBonusNumber(bonusNum1);
        LottoDrawMachine lottoDrawMachine = new LottoDrawMachine(winNumList, bonusNum);

        // 당첨 결과 확인 및 출력
        LottoWinningStatics lottoWinningStatics = new LottoWinningStatics(lottos, lottoDrawMachine, purchaseAmount);
        outputView.printStatistics(lottoWinningStatics);
    }
}