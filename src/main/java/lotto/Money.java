package lotto;

public class Money {
    public static long buy(String moneyText){
        if (!moneyText.matches("\\d+")) {
            throw new IllegalArgumentException("로또 구입 금액 값은 숫자만 포함해야 합니다.(부호 안됨)");
        }
        long money = Long.parseLong(moneyText);
        if (money%1000 != 0){
            throw new IllegalArgumentException("돈은 1,000원 단위로 나누어 떨어져야 합니다.");
        }
        long purchaseAmount = money/1000;
        if (purchaseAmount < 1){
            throw new IllegalArgumentException("0개는 구매할 수 없습니다");
        }
        return (purchaseAmount);
    }
}