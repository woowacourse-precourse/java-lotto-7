package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.ExceptionConstant;
import lotto.domain.Lotto;
import lotto.constant.LottoConstant;
import lotto.domain.LottoTickets;

public class LottoMachineService {
    LottoService lottoService = new LottoService();

    public LottoTickets createLottoTickets(String input) {
        int lottoTicketAmount = calculateLottoCount(convertToInt(input));
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoTicketAmount; i++) {
            lottos.add(lottoService.createLotto());
        }
        return new LottoTickets(lottos);
    }

    private int calculateLottoCount(int purchaseAmount) {
        if (purchaseAmount % LottoConstant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionConstant.PURCHASE_AMOUNT_1000);
        }
        if (purchaseAmount < LottoConstant.LOTTO_PRICE) {
            throw new IllegalArgumentException(ExceptionConstant.MIN_PURCHASE_AMOUNT);
        }
        return purchaseAmount / LottoConstant.LOTTO_PRICE;
    }

    private int convertToInt(String input) {
        validatePurchaseAmount(input);
        LottoConstant.purchase = Integer.parseInt(input);
        return LottoConstant.purchase;
    }

    private void validatePurchaseAmount(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ExceptionConstant.NULL_OR_EMPTY);
        }
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ExceptionConstant.CONTAINS_INVALID_CHARACTER);
        }
    }
}
