package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.service.LottoService;
import lotto.view.InputLottoView;
import lotto.view.OutputLottoView;

import java.util.List;
import java.util.Set;

public class LottoController {
    private final InputLottoView lottoView;
    private final OutputLottoView outputView;
    private final LottoService lottoService;

    public LottoController(InputLottoView lottoView, OutputLottoView outputView, LottoService lottoService) {
        this.lottoView=lottoView;
        this.outputView=outputView;
        this.lottoService=lottoService;
    }
    public void startLotto() {
        //구입 금액 입력하기
        int lottoPrice = lottoView.printLottoMoney();
        //로또 발행하기
        int publishNum = lottoPrice/1000;
        Set<Lotto> publishedNumbers = lottoService.createLottoList(publishNum);

        // 당첨번호 +보너스 번호 입력하기
        LottoResult lottoResult=lottoService.getLottoResult();

        //당첨결과 계산
        lottoService.calcMatchCount(publishedNumbers,lottoResult);

        //당첨 통계 출력
        outputView.printLottoStatic();
        // 수익률
        double earningsRate= lottoService.calcEarningsRate(lottoPrice);
        outputView.printEarningsRate(earningsRate);

    }

}
