package lotto.controller;

import lotto.model.LottoResult;
import lotto.service.LottoService;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class LottoController {
    private final Input input;
    private final Output output;
    private final LottoService lottoService;

    public LottoController() {
        this.input = new Input();
        this.output = new Output();
        this.lottoService = new LottoService();
    }

    public void start() {
        //지불할 금액 입력
        int payment = input.payment();
        int countLotto = lottoService.calculPayment(payment);

        //로또 수 만큼 구입
        output.printCountLotto(countLotto);
        lottoService.buyLotto(countLotto);
        output.printLottoList(lottoService.getLottos());

        //당첨 번호와 보너스 번호 입력
        List<Integer> prizeNumbers = input.prizeNumbers();
        int bonusNumber = input.bonusNumber(prizeNumbers);

        //당첨 번호와 보너스 번호 객체 생성 및 저장
        lottoService.updateWinningNumber(prizeNumbers, bonusNumber);
        lottoService.matchLottos();

        //당첨 통계 출력
        LottoResult lottoResult = lottoService.getLottoResult();
        double rate = lottoService.calculRate(payment);
        output.printLottoResult(lottoResult.getLottoSameSize(), rate);
    }
}
