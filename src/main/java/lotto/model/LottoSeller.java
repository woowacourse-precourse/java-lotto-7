package lotto.model;

import java.util.List;
import lotto.common.ErrorMessage;
import lotto.dto.InputMoneyDTO;

public class LottoSeller {

    public static final int SELL_UNIT = 1000;

    public List<Lotto> sell(final InputMoneyDTO moneyDTO){
        validateUnit(moneyDTO.money());
        return LottoGenerator.generate(getQuantity(moneyDTO));
    }

    private void validateUnit(final Long money) {
        if(isMultipleOfSellUnit(money)){
            throw new IllegalArgumentException(ErrorMessage.INPUT_MONEY_IS_MULTIPLE_1000.getMessage());
        }
    }

    private boolean isMultipleOfSellUnit(Long money) {
        return money % SELL_UNIT != 0;
    }

    private int getQuantity(InputMoneyDTO moneyDTO) {
        return (int) (moneyDTO.money() / SELL_UNIT);
    }
}
