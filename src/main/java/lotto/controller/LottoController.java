package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoService();
    }

    public void start() {
        //지불할 금액 입력
        outputView.printNoticeToPayMent();
        int payment = inputView.payAmount();
        int countLotto = lottoService.calculPayment(payment);
        outputView.printNoticeCountBuy(countLotto);

        //로또 수 만큼 구입
        lottoService.buyLotto(countLotto);
        outputView.printLottoList(lottoService.getLottos());

        //당첨 번호와 보너스 번호 입력
        outputView.printNoticePrizeNumber();
        List<Integer> prizeNumbers = inputView.prizeNumbers();
        outputView.printNoticeBonusNumber();
        int bonusNumber = inputView.bonusNumber();

        //당첨 번호와 보너스 번호 객체 생성 및 저장
        lottoService.updateWinningNumber(prizeNumbers, bonusNumber);
        lottoService.matchLottos();

        //당첨 통계 출력
        LottoResult lottoResult = lottoService.getLottoResult();
        double rate = lottoService.calculRate(payment);
        outputView.printLottoResult(lottoResult.getLottoSameSize(),rate);
    }
}
