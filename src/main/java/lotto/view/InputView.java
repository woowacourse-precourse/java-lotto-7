package lotto.view;

public class InputView {
    public static int inputMoney() {
        System.out.println(INPUT_MONEY.getMessage());
        String input = input();
        LottoValidator.validateNumber(input);

        int money = Integer.parseInt(input);
        validateMoney(money);
        return money;
    }

    private static String input() {
        String input = readLine();
        validateInput(input);
        return input;
    }
}
