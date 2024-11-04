package lotto;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();

        try {
            System.out.println("구입 금액을 입력해 주세요.");
            String input = Console.readLine();
            int amount = parseInputAmount(input);
            lottoMachine.buyLottos(amount);

            System.out.println("당첨 번호를 입력해 주세요.");
            List<Integer> winningNumbers = parseWinningNumbers(Console.readLine());

            System.out.println("보너스 번호를 입력해 주세요.");
            int bonusNumber = parseBonusNumber(Console.readLine());

            lottoMachine.setWinningLotto(winningNumbers, bonusNumber);
            lottoMachine.calculateResults();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private static int parseInputAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입 금액은 숫자여야 합니다.");
        }
    }

    private static List<Integer> parseWinningNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("당첨 번호는 숫자여야 합니다.");
        }
    }

    private static int parseBonusNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 번호는 숫자여야 합니다.");
        }
    }
}
