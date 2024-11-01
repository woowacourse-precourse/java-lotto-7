package lotto.domain;

import lotto.error.enums.LottoErrorMessage;

public class AmountOfLottos {

    private final int amount;

    public AmountOfLottos(String inputMoney, int lottoPrize) {
        validate(inputMoney);
        this.amount = Integer.parseInt(inputMoney) / lottoPrize;
    }

    private void validate(String input) {
        try {
            int money = Integer.parseInt(input);
            if(money % 1000 != 0)
                throw new Exception();
        } catch (Exception e){
            throw new IllegalArgumentException(LottoErrorMessage.MONEY_EXCEPTION.getMsg());
        }
    }

    public int getAmount() {
        return amount;
    }
}
