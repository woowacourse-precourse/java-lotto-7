package lotto.controller;

import static lotto.constant.Number.MAX_LOTTO_LENGTH;
import static lotto.view.InputView.getPrintInputBonusNumberMessage;
import static lotto.view.InputView.getPrintInputPurchaseMessage;
import static lotto.view.OutputView.getPrintLottoCountMessage;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.PrizeNumbers;
import lotto.domain.UserLotto;
import lotto.service.LottoCalculateService;
import lotto.service.LottoCreateService;
import lotto.service.LottoPrizeService;

public class LottoController {
    LottoCalculateService lottoCalculateService = new LottoCalculateService();
    LottoPrizeService lottoPrizeService = new LottoPrizeService();


    public void startLotto(){
        //로또 갯수 계산과 동시에 로또 번호 생성
        lottoCalculateService.inputMoney();
        //여기서 우승자 로또 번호, 보너스 번호 다 포함되게 함
        lottoPrizeService.PrizeNumbers();

    }




}
