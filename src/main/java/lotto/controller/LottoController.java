package lotto.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.ErrorMessage;
import lotto.service.LottoService;
import lotto.model.BonusBall;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.util.NumberGenerate;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, NumberGenerate lottoGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = new LottoService(lottoGenerator);
    }

    public void run() {
        List<Lotto> purchasedLotto = lottoMoneyInput();

        outputView.showHowManyLotto(purchasedLotto);
        outputView.showAllLottoNums(purchasedLotto);

        WinningLotto prizeWinningLotto = winningLottoInput();
    }

    private List<Lotto> lottoMoneyInput() {
        while (true) {
            try {
                int money = inputView.lottoMoneyInput();
                return lottoService.purchaseLotto(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningLotto winningLottoInput() {
        Lotto prizeLotto = prizeNumberInput();
        BonusBall bonusBall = bonusBallInput(prizeLotto);
        return new WinningLotto(prizeLotto, bonusBall);
    }

    private Lotto prizeNumberInput() {
        while (true) {
            try {
                String rawNumbers = inputView.lottoNumsInput();
                List<Integer> numbers = StringToIntList(rawNumbers);
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusBall bonusBallInput(Lotto lotto) {
        while (true) {
            try {
                int bonusNumbers = inputView.lottoBonusNumInput();
                BonusBall bonusBall = new BonusBall(bonusNumbers);
                validateBonusNumberDuplication(lotto, bonusBall);
                return bonusBall;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> StringToIntList(String rawNumbers) {
        return Arrays.stream(rawNumbers.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    private static void validateBonusNumberDuplication(Lotto lotto, BonusBall bonus) {
        Set<Integer> duplication = new HashSet<>(lotto.lottoNums());
        duplication.add(bonus.getNum());
        if (duplication.size() != 7) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMS_DUPLICATION.getMsg());
        }
    }
}
