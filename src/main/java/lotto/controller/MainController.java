package lotto.controller;

import lotto.domain.repository.LottoRepository;
import lotto.dto.response.PurchaseLottosResponse;
import lotto.service.LottoService;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class MainController {

    private final LottoRepository lottoRepository = new LottoRepository();
    private final LottoController lottoController = new LottoController(new LottoService(lottoRepository));

    public void start(){
        // 구매 금액 입력
        Integer purchaseAmount = inputPurchaseAmount();
        // 로또 구매 개수  + 번호 출력
        purchaseLottos(purchaseAmount);
        // 로또 당첨 번호 입력
        List<Integer> winLottoNumbers = inputWinLottoNumbers();
        // 보너스 번호 입력
        Integer bonusNumber = inputBonusNumber();
        // 당첨 내역
        
        // 수익률
    }

    private Integer inputBonusNumber() {
        OutputView.inputBonusLottoNumber();
        return Parser.parseStringToInt(InputView.readUserInput());
    }

    private List<Integer> inputWinLottoNumbers() {
        OutputView.inputWinLottoNumbers();
        return Parser.parseDelimitersInteger(InputView.readUserInput());
    }

    private void purchaseLottos(Integer purchaseAmount) {
        PurchaseLottosResponse purchaseLottosResponse = lottoController.purchaseLottos(purchaseAmount);
        OutputView.printPurchaseLottos(purchaseLottosResponse.count());
        OutputView.printIssueAllLottoNumbers(purchaseLottosResponse.allLottosNumbers());
    }

    private Integer inputPurchaseAmount() {
        OutputView.inputPurchaseAmount();
        return Parser.parseStringToInt(InputView.readUserInput());
    }
}
