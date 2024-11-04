package lotto.controller;

import lotto.dto.MatchResponse;
import lotto.dto.UserLotto;
import lotto.dto.WinNumberForm;
import lotto.model.lotto.Bonus;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoService;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class LottoController {
    private final Input input;
    private final Output output;
    private final LottoService lottoService;

    public LottoController(Input input, Output output, LottoService lottoService) {
        this.input = input;
        this.output = output;
        this.lottoService = lottoService;
    }

    public void run() {
        UserLotto userLotto = getUserLotto();

        Lotto winLotto = getWinLotto();
        Bonus bonus = getBonusNumber(winLotto);

        matchingLottos(userLotto, winLotto, bonus);
    }

    private UserLotto getUserLotto() {
        while (true) {
            output.inputMoney();
            try {
                int money = input.number();
                UserLotto userLotto = purchaseLottos(money);
                return userLotto;
            } catch (IllegalArgumentException e) {
                output.message(e.getMessage());
            }
        }

    }

    private UserLotto purchaseLottos(int money) {
        UserLotto userLotto = lottoService.purchase(money);
        output.purchaseSign(userLotto);
        output.userLottos(userLotto);
        return userLotto;
    }

    private Lotto getWinLotto() {
        output.inputWinNumbers();
        try {
            List<Integer> winLottoNumbers = input.numbers();
            Lotto lotto = lottoService.getLotto(winLottoNumbers);
            return lotto;
        } catch (IllegalArgumentException e) {
            output.message(e.getMessage());
            return getWinLotto();
        }
    }

    private Bonus getBonusNumber(Lotto lotto) {
        output.inputBonusNumber();
        try {
            int bonusNumber = input.number();
            Bonus bonus = lottoService.getBonus(lotto, bonusNumber);
            return bonus;
        } catch (IllegalArgumentException e) {
            output.message(e.getMessage());
            return getBonusNumber(lotto);
        }
    }

    private void matchingLottos(UserLotto userLotto, Lotto lotto, Bonus bonus) {
        MatchResponse matchResponse =
                lottoService.matchLottos(userLotto, new WinNumberForm(lotto, bonus));
        output.matchResult(matchResponse);
    }
}
