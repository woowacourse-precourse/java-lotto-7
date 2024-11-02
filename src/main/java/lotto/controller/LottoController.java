package lotto.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.service.LottoResult;
import lotto.util.ErrorMessage;
import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;
import lotto.domain.WinningLotto;
import lotto.util.NumberGenerate;
import lotto.domain.BonusBall;
import lotto.service.LottoMachine;
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
        PurchasedLottos purchasedLotto = inputMoney();

        outputView.showHowManyLotto(purchasedLotto);
        outputView.showAllLottoNums(purchasedLotto);

        Lotto lotto = inputWinningLotto();
        BonusBall bonusNumbers = inputBonusNumber(lotto);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumbers);

        LottoResult lottoResult = lottoMachine.winLotto(purchasedLotto, winningLotto);

        outputView.showWinStatus(lottoResult);
        outputView.showProfit(lottoResult, lottoMachine.inMoney());
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
                String[] rawNumbers = inputView.lottoNumsInput();
                List<Integer> numbers = toIntegerList(rawNumbers);
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> toIntegerList(String[] numbers) {
        try {
            return Arrays.stream(numbers)
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUM_IS_NOT_NUM.getMsg());
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
