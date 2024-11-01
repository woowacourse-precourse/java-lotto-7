package lotto.controller;

import lotto.domain.repository.LottoRepository;
import lotto.dto.response.PurchaseLottosResponse;
import lotto.dto.response.getLottoResultResponse;
import lotto.service.LottoService;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class MainController {

    private final LottoRepository lottoRepository = new LottoRepository();
    private final LottoController lottoController = new LottoController(new LottoService(lottoRepository));

    public void start(){
        // 1000 단위 검사
        Long purchaseAmount = inputPurchaseAmount();
        purchaseLottos(purchaseAmount);
        // 중복 검사 해야함
        List<Integer> winLottoNumbers = inputWinLottoNumbers();
        // 로또 당첨 번호랑 중복 안되게 해야함
        Integer bonusNumber = inputBonusNumber();
        getLottoResultResponse response = lottoController.getLottoResult(winLottoNumbers, bonusNumber);
        OutputView.printLottoResult(response.result());
        OutputView.printLottoReturnRate(purchaseAmount, response.prizeMoney());
    }

    private Integer inputBonusNumber() {
        OutputView.inputBonusLottoNumber();
        return Parser.parseStringToInt(InputView.readUserInput());
    }

    private List<Integer> inputWinLottoNumbers() {
        OutputView.inputWinLottoNumbers();
        return Parser.parseDelimitersInteger(InputView.readUserInput());
    }

    private void purchaseLottos(Long purchaseAmount) {
        PurchaseLottosResponse purchaseLottosResponse = lottoController.purchaseLottos(purchaseAmount);
        OutputView.printPurchaseLottos(purchaseLottosResponse.count());
        OutputView.printIssueAllLottoNumbers(purchaseLottosResponse.allLottosNumbers());
    }

    private Long inputPurchaseAmount() {
        OutputView.inputPurchaseAmount();
        return Parser.parseStringToLong(InputView.readUserInput());
    }
}
