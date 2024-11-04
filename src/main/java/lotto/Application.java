package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            Money amount = Input.setMoney();

            Lotto winning = Input.setWinningNumbers();
            int bonus = Input.setBonusNumber();

        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
