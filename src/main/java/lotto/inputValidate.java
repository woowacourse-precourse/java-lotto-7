package lotto;

public class inputValidate {

    public boolean amountValidate(int amount){
        try {
            if (amount < 1000 || amount%1000!=0) {
                throw new IllegalArgumentException("[ERROR] 구매 금액을 다시 입력해주세요.");
            }
            return true;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
