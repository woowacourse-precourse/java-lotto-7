package lotto.controller;

import java.util.List;
import lotto.model.Lotto;

public class LottoController {

    public void payingForLotto() {
        Long paidAmount = paying();
        generateLottoRequest(paidAmount);
    }

    private Long paying() {
        /*
        TODO
        1. 구매할 금액을 입력한다.
        2. 입력한 내용의 유효성 검사를 실시한다.
        3. 유효성 검사에서 통과하지 못했다면, 다시 입력을 받는다.
        4. 검사를 통과했다면, 본인이 지불한 금액을 Long타입으로 변환하여 반환한다.
         */

        return null;
    }

    private void generateLottoRequest(Long paidAmount) {
        /*
        1. 지불을 완료한 만큼 새로운 로또의 발급을 요청한다.
         */
    }

}
