package lotto.model;

public class BuyAmount {
    private final int buyAmount;

    public BuyAmount(String buyAmountString) {
        emptyValidation(buyAmountString);
        notNumberValidation(buyAmountString);
        underMinimumAmountValidation(buyAmountString);
        remainValidatiion(buyAmountString);
        this.buyAmount = Integer.parseInt(buyAmountString);
    }

    private void emptyValidation(String buyAmount) {
        if(buyAmount.isEmpty()) throw new IllegalArgumentException("[ERROR] 구입금액은 빈 값이 들어올 수 없습니다.");
    }

    private void notNumberValidation(String buyAmount) {
        try{
            Integer.parseInt(buyAmount);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자로 입력되어야 합니다.");
        }
    }

    private void underMinimumAmountValidation(String buyAmount) {
        if(Integer.parseInt(buyAmount) < 1000) throw new IllegalArgumentException("[ERROR] 구매금액은 1000원 이상이어야 합니다.");
    }

    private void remainValidatiion(String buyAmount) {
        if(Integer.parseInt(buyAmount) % 1000 != 0) throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액을 입력해야 합니다.");
    }

}
