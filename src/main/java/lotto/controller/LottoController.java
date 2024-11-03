package lotto.controller;

import lotto.service.LottoMachineService;
import lotto.service.MemberService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final MemberService memberService = new MemberService();
    private final LottoMachineService lottoMachineService = new LottoMachineService();

    public void run() {
        inputView.printInputLottoPurchaseAmount();
        lottoMachineService.issueLottos();
        outputView.printPurchaseLottoCount();
        outputView.printIssuedLottos();
        inputView.printInputWinningNumber();
        inputView.printInputBonusNumber();
        lottoMachineService.giveCorrectCountAndMoney();
        outputView.printLottoResult();
        memberService.calculateReturnOfRate();
        outputView.printReturnOfRate();
    }
}
