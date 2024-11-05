package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static final String REQUEST_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private static int amount;
    private static WinningNumber winningNumber;

    public static String readLine() {
        return Console.readLine();
    }

    public static void requestAmount() {
        while (true) {
            try {
                System.out.println(REQUEST_AMOUNT);
                String inputAmount = readLine();
                amount = Integer.parseInt(inputAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 금액에는 숫자만 입력해야 해요.");
            }
        }
    }

    public static void requestWinningNumber() {
        System.out.println(REQUEST_WINNING_NUMBER);
        String inputWinningNumber = readLine();
        String[] inputNumbers = inputWinningNumber.split(",");

        try {
            List<Integer> numbers = new ArrayList<>();
            for (String inputNumber : inputNumbers) {
                int number = Integer.parseInt(inputNumber);
                numbers.add(number);
            }

            System.out.println();
            System.out.println(REQUEST_BONUS_NUMBER);
            String inputBonusNumber = readLine();
            int bonusNumber = Integer.parseInt(inputBonusNumber);

            winningNumber = new WinningNumber(new Lotto(numbers), bonusNumber);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식이 아닙니다.");
        }
    }

    public static int getAmount() {
        return amount;
    }

    public static WinningNumber getWinningNumber() {
        return winningNumber;
    }
}
