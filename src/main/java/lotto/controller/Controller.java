package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.domain.BonusNumber;
import lotto.domain.LottoMarket;
import lotto.domain.NumbersComparator;
import lotto.domain.ProfitRatioCalculator;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    public void run() {

        // 구입 금액을 입력
        int inputMoney = InputView.readMoney();

        // 로또 번호 생성
        LottoMarket lottoMarket = new LottoMarket();
        List<Lotto> myLottos = lottoMarket.buyLotto(inputMoney);

        // 발급된 로또 번호를 출력
        OutputView.showLottoNumbers(myLottos);

        // 당첨 번호를 입력
        String inputNumbers = InputView.readWinningNumbers();

        // 보너스 번호를 입력
        String inputBonusNumber = InputView.readBonusNumber();

        // 번호 비교
        BonusNumber bonusNumber = new BonusNumber(inputBonusNumber);
        WinningNumbers winningNumbers = new WinningNumbers(inputNumbers, bonusNumber);
        NumbersComparator numbersComparator = new NumbersComparator(myLottos, winningNumbers);
        int[] result = numbersComparator.determineRank();

        // 수익률 계산
        ProfitRatioCalculator profitRatioCalculator = new ProfitRatioCalculator(result, myLottos);

        // 당첨 통계와 수익률 출력
        OutputView.showWinningResult(result);
        OutputView.showProfitRatio(profitRatioCalculator.calculateProfitRatio());

    }
}
