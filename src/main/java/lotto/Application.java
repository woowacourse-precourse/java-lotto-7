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
        List<Integer> winningNumbers = InputUtil.insertWinningNumbers();
        // 4. 보너스 번호 입력
        Integer bonusNumber = InputUtil.insertBonusNumber();
        // 5. 당첨 통계 출력
        LottoResult lottoResult = lottoMachine.generateResult(winningNumbers, bonusNumber);
    }
}
