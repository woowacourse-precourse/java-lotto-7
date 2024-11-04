package lotto;

import java.util.List;
import model.Lotto;
import model.LottoChecker;
import model.LottoMaker;
import model.MoneyCalculator;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {

        // 1. 구입 금액 입력
        InputView inputView = new InputView();
        int inputMoney = inputView.getInputMoney();

        // 2. 로또 구매
        int lottoCount = inputMoney / 1000;

        // 3. 로또 발행
        LottoMaker lottoMaker = new LottoMaker();
        lottoMaker.makeLottos(lottoCount);
        List<Lotto> lottos = lottoMaker.getLottos();

        // 4. 발행한 로또 출력
        OutputView outputview = new OutputView();
        outputview.showLottos(lottos);

        // 5. 당첨 번호 입력
        List<Integer> inputNumber = inputView.getInputNumber();

        // 6. 보너스 번호 입력
        int bonusNumber = inputView.getInputBonus();

        // 7. 당첨된 로또 확인
        LottoChecker lottoChecker = new LottoChecker(inputNumber, bonusNumber);
        List<Integer> matchNumberCount = lottoChecker.checkLottos(lottos);

        // 8. 당첨 통계
        outputview.showStatistics(matchNumberCount);

        // 9. 당첨 금액 계산
        MoneyCalculator moneyCalculator = new MoneyCalculator(matchNumberCount);
        long winningAmount = moneyCalculator.getWinningAmount();

        // 10. 수익률 계산
        String profitMargin = moneyCalculator.getProfitMargin(inputMoney, winningAmount);

        // 11. 수익률 출력
        outputview.showProfitMargin(profitMargin);

        // TODO: 매직넘버 사용 줄이기
    }
}
