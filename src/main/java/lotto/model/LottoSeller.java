package lotto.model;

import static lotto.model.Lotto.getLottoPrice;

import java.util.List;
import lotto.common.ErrorMessage;
import lotto.dto.MoneyDTO;

public class LottoSeller {

    public List<Lotto> sell(final MoneyDTO moneyDTO) {
        validateUnit(moneyDTO.money());
        return Lotto.createLottos(getQuantity(moneyDTO));
    }

    private void validateUnit(final Long money) {
        if (isMultipleOfPrice(money)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MONEY_IS_MULTIPLE_1000.getMessage());
        }
    }

    private boolean isMultipleOfPrice(Long money) {
        return money % getLottoPrice() != 0;
    }

    private int getQuantity(MoneyDTO moneyDTO) {
        return (int) (moneyDTO.money() / getLottoPrice());
    }
}
