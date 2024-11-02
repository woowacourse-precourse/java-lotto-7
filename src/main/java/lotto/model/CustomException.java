package lotto.model;

public class CustomException extends Exception {
    private final int MINIMUM_PURCHASE_AMOUNT = 1000;
    private final int PURCHASE_AMOUNT_UNIT = 1000;
    private static final CustomException instance = new CustomException();
    private CustomException() {}
    public static CustomException getInstance() {
        return instance;
    }

    public void purchaseAmountInputCheck(String purchase){
        int amount = purchaseOnlyIntCheck(purchase);
        purchaseAmountCheck(amount);
    }
    public int purchaseOnlyIntCheck(String purchase){
        try{
            return Integer.parseInt(purchase);
        }catch(IllegalArgumentException e){
            System.out.println("구매 금액은 숫자만 입력해주세요.");
        }
        return 0;
    }
    public void purchaseAmountCheck(int amount){
        if(amount < MINIMUM_PURCHASE_AMOUNT){
            throw new IllegalArgumentException("구매 금액은 "+MINIMUM_PURCHASE_AMOUNT+"원 이상이어야 합니다.");
        }
        if(amount % PURCHASE_AMOUNT_UNIT != 0){
            throw new IllegalArgumentException("구매 금액은 "+PURCHASE_AMOUNT_UNIT+"원 단위로 입력해주세요.");
        }
    }
}
