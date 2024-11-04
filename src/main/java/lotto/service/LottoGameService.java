package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoIssuer;
import lotto.dto.LottoPurchase;
import lotto.validator.LottoBonusNumberValidator;
import lotto.validator.LottoNumberValidator;
import lotto.validator.LottoPurchaseValidator;
import lotto.view.InputView;

public class LottoGameService {
    private final LottoIssuer lottoIssuer = new LottoIssuer();

    public LottoPurchase createLottoPurchase(int purchaseAmount) {
        return new LottoPurchase(purchaseAmount);
    }

    public LottoPurchase inputPurchaseAmount() {
        while (true) {
            try {
                String input = InputView.inputPurchaseAmount();
                int purchaseAmount = LottoPurchaseValidator.validateAndParse(input);
                return createLottoPurchase(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Lotto> generateLottoTickets(LottoPurchase lottoPurchase) {
        int count = lottoPurchase.amount() / 1000;
        List<Lotto> tickets = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Lotto lotto = lottoIssuer.issue();
            tickets.add(lotto);
        }
        return tickets;
    }

    public List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                String input = InputView.inputWinningNumbers();
                return LottoNumberValidator.validateAndParse(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String input = InputView.inputBonusNumber();
                return LottoBonusNumberValidator.validateAndParse(input, winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
