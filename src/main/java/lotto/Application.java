package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 1. 구입 금액 입력
        int lottoCount = InputUtil.insertMoney();
        // 2. 로또 생성
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.generateLottos(lottoCount);
        // 3. 당첨 번호 입력
        // 4. 보너스 번호 입력
        // 5. 당첨 통계 출력
    }
}
