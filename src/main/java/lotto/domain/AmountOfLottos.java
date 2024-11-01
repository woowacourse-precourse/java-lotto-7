package lotto.domain;

import lotto.error.LottoErrorMessage;

public class AmountOfLottos {

    private static final int LOTTO_PRICE = 1000;

    private final int amount;

    public AmountOfLottos(String inputMoney) {
        validate(inputMoney);
        this.amount = Integer.parseInt(inputMoney) / LOTTO_PRICE;
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
