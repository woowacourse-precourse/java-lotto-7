package lotto.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import lotto.domain.LottoResult;
import lotto.util.ErrorMessage;
import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;
import lotto.domain.WinningLotto;
import lotto.util.NumberGenerate;
import lotto.domain.BonusBall;
import lotto.domain.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public LottoController(InputView inputView, OutputView outputView, NumberGenerate lottoGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = new LottoMachine(lottoGenerator);
    }

    public void run() {
        // 1. 구매 금액 입력 및 로또 발행
        PurchasedLottos purchasedLotto = inputMoney();

        // 2. 발행한 로또 출력
        outputView.showHowManyLotto(purchasedLotto);
        outputView.showAllLottoNums(purchasedLotto);

        // 3. 당첨 로또 번호 입력
        Lotto lotto = inputWinningLotto();

        // 4. 보너스 번호 입력
        BonusBall bonusNumbers = inputBonusNumber(lotto);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumbers);

        // 5. 당첨 결과 비교
        LottoResult lottoResult = lottoMachine.winLotto(purchasedLotto, winningLotto);

        outputView.showWinStatus(lottoResult);
        outputView.showProfit(lottoResult.getWinner(), lottoMachine.inMoney());
    }

    private BonusBall inputBonusNumber(Lotto lotto) {
        while (true) {
            try {
                BonusBall bonusBall = new BonusBall(inputView.lottoBonusNumInput());
                validateBonusNumberDuplication(lotto, bonusBall);
                return bonusBall;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto inputWinningLotto() {
        while (true) {
            try {
                String rawNumbers = inputView.lottoNumsInput();
                return new Lotto(Arrays.stream(rawNumbers.split(","))
                        .map(Integer::parseInt)
                        .toList());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private PurchasedLottos inputMoney() {
        while (true) {
            try {
                int money = inputView.lottoMoneyInput();
                return lottoMachine.issueLotto(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateBonusNumberDuplication(Lotto lotto, BonusBall bonus) {
        Set<Integer> duplication = new HashSet<>(lotto.lottoNums());
        duplication.add(bonus.getNum());
        if (duplication.size() != 7) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMS_DUPLICATION.getMsg());
        }
    }
}
