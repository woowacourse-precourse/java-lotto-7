package lotto.controller;

import static lotto.exception.ErrorMessage.INVALID_BONUS_NUMBER_TYPE;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Count;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.exception.LottoException;
import lotto.utils.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void start() {
        Lottos lottos = buyLotto();
        showResult(lottos);
        Lotto winnerLotto = getWinnerNumbers();
        BonusNumber bonusNumber = getBonusNumber();
        LottoMachine lottoMachine = createLottoMachine(winnerLotto, bonusNumber);
        Map<LottoResult, Integer> lottoResult = getLottoResult(lottoMachine, lottos);
        printResult(lottoResult, lottos.getLottos().size() * 1000);
    }

    private Lottos buyLotto() {
        try {
            String purchaseAmount = InputView.getPurchaseAmount();
            Count count = Count.from(purchaseAmount);
            return Lottos.from(count.getCount());
        } catch (LottoException e) {
            System.out.println(e.getMessage());
            return buyLotto();
        }
    }

    private void showResult(Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottos();
        OutputView.printLotto(lottoList);
    }

    private Lotto getWinnerNumbers() {
        try {
            String winningNumbers = InputView.getWinningNumbers();
            return new Lotto(Parser.parse(winningNumbers));
        } catch (LottoException e) {
            System.out.println(e.getMessage());
            return getWinnerNumbers();
        }
    }

    private BonusNumber getBonusNumber() {
        String bonusNumber = InputView.getBonusNumber().trim();
        try {
            int number = Integer.parseInt(bonusNumber);
            return BonusNumber.from(number);
        } catch (NumberFormatException e) {
            System.out.println(INVALID_BONUS_NUMBER_TYPE.getMessage());
            return getBonusNumber();
        } catch (LottoException e) {
            System.out.println(e.getMessage());
            return getBonusNumber();
        }
    }

    private LottoMachine createLottoMachine(Lotto winnerLotto, BonusNumber bonusNumber) {
        try {
            return LottoMachine.of(winnerLotto, bonusNumber);
        } catch (LottoException e) {
            System.out.println(e.getMessage());
            return createLottoMachine(winnerLotto, bonusNumber);
        }
    }

    private Map<LottoResult, Integer> getLottoResult(LottoMachine lottoMachine, Lottos lottos) {
        Map<LottoResult, Integer> result = new EnumMap<>(LottoResult.class);
        for (Lotto lotto : lottos.getLottos()) {
            LottoResult lottoResult = lottoMachine.getLottoResult(lotto);
            result.put(lottoResult, result.getOrDefault(lottoResult, 0) + 1);
        }
        return result;
    }

    private void printResult(Map<LottoResult, Integer> result, int money) {
        OutputView.printResult(result, money);
    }
}
