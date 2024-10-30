package lotto;

public class Money {
    public static long buy(String moneyText){
        if (!moneyText.matches("\\d+")) {
            throw new IllegalArgumentException("입력 값은 숫자만 포함해야 합니다.");
        }
        long money = Long.parseLong(moneyText);
        if (money%1000 != 0){
            throw new IllegalArgumentException("돈은 1,000원 단위로 나누어 떨어져야 합니다.");
        }
        money = money/1000;

        System.out.println(money+"개를 구매했습니다.");
        return (money);
    }
}