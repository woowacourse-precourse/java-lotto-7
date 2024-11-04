package lotto;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

	public static int requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readInput();
        try {
            int amount = Integer.parseInt(input);
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자로 입력해야 합니다.");
        }
    }

    public static List<Integer> requestWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readInput();
        List<Integer> numbers = parseInputNumbers(input);
        return numbers;
    }

    public static int requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = readInput();
        try {
            int bonusNumber = Integer.parseInt(input);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로 입력해야 합니다.");
        }
    }


    private static List<Integer> parseInputNumbers(String input) {
        return Stream.of(input.split(","))
                     .map(String::trim)
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }
    
    private static String readInput() {
        return Console.readLine();
    }
}