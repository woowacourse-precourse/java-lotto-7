package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int purchaseAmount = readPurchaseAmount();
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottoTickets = lottoMachine.purchase(purchaseAmount);
        outputView.printPurchasedQuantity(lottoTickets.size());
        outputView.printLottoTickets(getLottoTickets(lottoTickets));
    }

    private List<List<Integer>> getLottoTickets(List<Lotto> lottoTickets) {
        return lottoTickets.stream()
                .map(Lotto::getNumbers)
                .toList();
    }

    private int readPurchaseAmount() {
        String rawInputPurchaseAmount = inputView.requestPurchaseAmount();
        return validateAndParsePurchaseAmount(rawInputPurchaseAmount);
    }

    private int validateAndParsePurchaseAmount(String rawInput) {
        if (rawInput.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 구입금액을 입력되지 않았어요. 다시 입력해주세요.");
        }

        int purchaseAmount = parsePurchaseAmount(rawInput);
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    private int parsePurchaseAmount(String rawInput) {
        try {
            return Integer.parseInt(rawInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액에 숫자가 아닌 문자가 포함되어 있어요. 다시 입력해주세요.");
        }
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액이 0보다 작아요. 다시 입력해주세요.");
        }
        if (purchaseAmount == 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액이 0이에요. 다시 입력해주세요.");
        }
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위여야 해요. 다시 입력해주세요.");
        }
    }

}
