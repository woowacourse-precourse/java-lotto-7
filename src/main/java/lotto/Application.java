package lotto;

import java.util.List;
import model.Lotto;
import model.LottoMaker;
import view.InputView;
import view.OutpuView;

public class Application {
    public static void main(String[] args) {

        // 1. 구입 금액 입력
        InputView inputView = new InputView();
        int inputMoney = inputView.getInputMoney();

        // 2. 로또 구매
        int lottoCount = inputMoney / 1000;

        // 3. 로또 발행
        LottoMaker lottoMaker = new LottoMaker(lottoCount);
        lottoMaker.makeLottos();
        List<Lotto> lottos = lottoMaker.getLottos();

        // 4. 발행한 로또 출력
        OutpuView outpuView = new OutpuView();
        outpuView.showLottos(lottos);

        // 5. 당첨 번호 입력
        List<Integer> inputNumber = inputView.getInputNumber();

        // 6. 보너스 번호 입력
        int bonusNumber = inputView.getInputBonus();

        // 7. 당첨된 로또 확인

        // 8. 당첨 통계

        // 9. 당첨 금액 계산

        // 10. 수익률 계산

        // 11. 수익률 출력
    }
}
