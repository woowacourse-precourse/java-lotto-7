package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.UserMoney;
import lotto.service.LottoMachine;
import lotto.service.LottoService;

public class LottoController {
    public void start() {
        // 구매 금액 입력
        UserMoney userMoney = LottoService.inputUserMoney();

        // 구매 금액에 따른 로또 발행
        List<Lotto> issuedLottos = LottoMachine.issueLotto(userMoney);

        // 당첨 번호 및 보너스 번호 입력


        // 발행한 로또와 당첨 번호 비교


        // 수익률 계산 및 출력

    }


}
