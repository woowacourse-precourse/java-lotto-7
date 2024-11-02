package lotto;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.view.InputView;

public class LottoController {
    public void run() {
        int inpuMoney = InputView.readInputMoney();
        Lottos lottos = Lotto.buyAsMoney(inpuMoney);
        System.out.println(lottos.getLottos().size() + "개를 구매했습니다.");
        lottos.printLottoNumber();

        Lotto winningLotto = new Lotto(InputView.readAndSplitWinningNumber());
        int bonusNumber = InputView.readBonusNumber(winningLotto);

        System.out.println("당첨 통계\n---");
        Map<String, Integer> lottoResult = lottos.getLottoResult(winningLotto, bonusNumber);
        System.out.println("3개 일치 (5,000원) - " +lottoResult.get("5등") + "개");
        System.out.println("4개 일치 (50,000원) - " +lottoResult.get("4등") + "개");
        System.out.println("5개 일치 (1,500,000원) - " +lottoResult.get("3등") + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " +lottoResult.get("2등") + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " +lottoResult.get("1등") + "개");

        double returnsByLottos = lottos.calculateReturns(lottoResult, inpuMoney);
        System.out.printf("총 수익률은 %.1f%%입니다.", returnsByLottos);
    }
}
