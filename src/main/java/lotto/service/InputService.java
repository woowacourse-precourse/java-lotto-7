package lotto.service;

import lotto.domain.BonusNum;
import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningLotto;
import lotto.util.InputParsingUtil;
import lotto.view.InputView;

import java.util.List;
import java.util.function.Supplier;

public class InputService {
    private static final String ERROR = "[ERROR] ";
    private static final String RETRY = " 다시 입력해주세요.\n";

    private final InputView inputView;

    public InputService(final InputView inputView) {
        this.inputView = inputView;
    }

    public PurchasePrice readPurchasePrice() {
        return executeWithRetry(() -> {
            int purchasePrice = inputView.readPurchasePrice();
            return new PurchasePrice(purchasePrice);
        });
    }

    public WinningLotto readWinningLotto() {
        Lotto lotto = readWinningLottoNumbers();
        BonusNum bonusNum = readBonusNum(lotto);
        return new WinningLotto(lotto, bonusNum);
    }

    private Lotto readWinningLottoNumbers() {
        return executeWithRetry(() -> {
            String input = inputView.readWinningNumbers();
            List<Integer> numbers = InputParsingUtil.parseWinningLottoNumbers(input);
            return new Lotto(numbers);
        });
    }

    private BonusNum readBonusNum(Lotto winningLotto) {
        return executeWithRetry(() -> {
            int bonusNumber = inputView.readBonusNumber();
            return new BonusNum(bonusNumber, winningLotto.getNumbers());
        });
    }

    private static <T> T executeWithRetry(Supplier<T> action) {
        while (true) {
            try {
                return action.get();
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR + e.getMessage() + RETRY);
            }
        }
    }
}
