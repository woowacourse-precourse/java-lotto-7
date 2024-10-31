package lotto;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        int money = input.moneyInput();

        try {
            LottoNum lottoNum = new LottoNum(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
