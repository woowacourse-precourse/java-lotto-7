package lotto.controller;

import lotto.dto.LottoResponse;
import lotto.dto.LottoResultResponse;
import lotto.model.*;
import lotto.utils.LottoUtils;
import lotto.view.input.InputView;
import lotto.view.output.OutPutView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private final InputView inputView;
    private final OutPutView outPutView;

    public LottoController(InputView inputView, OutPutView outPutView) {
        this.inputView = inputView;
        this.outPutView = outPutView;
    }

    public void run(){
        Money money = processingPurchaseMoney();

        outPutView.displayPurchaseCount(money.getBuyLottoCount());

        List<Lotto> lottos = processingPurchessLottos(money);

        Lotto lotto = processingWinningLottoNumber();

        BonusNumber bonusNumber = processingBonusNumber();

        LottoEvaluator lottoEvaluator = createLottoManger(lotto, bonusNumber, money, lottos);

        LottoResult lottoResult = processingLottoResult(lottoEvaluator);

        outPutView.displayTotalReturnOfRate(lottoEvaluator.calculateRateOfReturn(lottoResult.calculateTotalIncome()));
    }

    private LottoResult processingLottoResult(LottoEvaluator lottoEvaluator) {
        List<LottoRank> lottoRanks = lottoEvaluator.evaluateTicketsRank();
        LottoResult lottoResult = new LottoResult(lottoRanks);
        outPutView.displayLottoResults(LottoResultResponse.from(lottoResult));
        return lottoResult;
    }

    private LottoEvaluator createLottoManger(Lotto lotto, BonusNumber bonusNumber, Money money, List<Lotto> lottos) {
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        return new LottoEvaluator(money, lottos, winningLotto);
    }

    private BonusNumber processingBonusNumber() {
        while(true){
            try {
                outPutView.displayBonusNumberPrompt();
                String inputBonusNumber = inputView.requestWinningLottoBonusNumber();
                ControllerValidation.inputBonusNumberValidation(inputBonusNumber);
                return new BonusNumber(Integer.valueOf(inputBonusNumber));
            }catch (IllegalArgumentException e){
                outPutView.displayExceptionMessage(e.getMessage());
            }
        }
    }

    private Lotto processingWinningLottoNumber() {
        while(true){
            try {
                outPutView.displayWinningNumberPrompt();
                String inputWinningNumber = inputView.requestWinningLottoNumbers();
                List<Integer> winningNumbers = LottoUtils.generateWinningNumber(inputWinningNumber);
                return new Lotto(winningNumbers);
            }catch (IllegalArgumentException e){
                outPutView.displayExceptionMessage(e.getMessage());
            }
        }
    }

    private List<Lotto> processingPurchessLottos(Money money) {
        List<Lotto> lottos = LottoUtils.lottoGenerator(money.getBuyLottoCount());

        List<LottoResponse> lottoResponses = lottos.stream()
                .map(LottoResponse::from)
                .collect(Collectors.toList());

        outPutView.displayPurchaseLotto(lottoResponses);
        return lottos;
    }

    private Money processingPurchaseMoney() {
        outPutView.displayPurchaseAmountPrompt();
        while(true){
            try{
                String inputPrice = inputView.requestLottoPurchaseAmount();
                ControllerValidation.inputPurchaseMoneyValidation(inputPrice);
                return new Money(Integer.valueOf(inputPrice));
            }catch (IllegalArgumentException e){
                outPutView.displayExceptionMessage(e.getMessage());
            }
        }
    }
}
