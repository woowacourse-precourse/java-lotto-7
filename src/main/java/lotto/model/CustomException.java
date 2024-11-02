package lotto.model;

public class CustomException extends Exception {
    private static final CustomException instance = new CustomException();
    private CustomException() {}
    public static CustomException getInstance() {
        return instance;
    }

    public void purchaseInputCheck(String purchase){
        purchaseOnlyIntCheck(purchase);
        purchaseAmountCheck(purchase);
    }
    public void purchaseOnlyIntCheck(String purchase){
        try{
            int num = Integer.parseInt(purchase);
        }catch(IllegalArgumentException e){
            System.out.println("구매 금액은 숫자만 입력해주세요.");
        }
    }
    public void purchaseAmountCheck(String purchase){
        if(Integer.parseInt(purchase)%1000 != 0){
            throw new IllegalArgumentException("구매 금액은 1000원 이상이며, 1000원 단위로 입력해주세요.");
        }
    }
}
