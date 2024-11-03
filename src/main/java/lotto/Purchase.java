package lotto;

public class Purchase {

    private final int money;

    public Purchase(String money) throws IllegalArgumentException{
        validate(money);
        this.money = Integer.parseInt(money);
    }

    private void validate(String money) {
        try{
            int moneyAmount = Integer.parseInt(money);
            if(moneyAmount % 1000 != 0 || moneyAmount == 0) {
                throw new IllegalArgumentException("[ERROR] 0이 아닌 1000으로 나누어지는 수를 입력해 주세요");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요");
        }
    }

    public int money() {
        return money;
    }

    public int numberOfPurchases() {
        return money / 1000;
    }
}
