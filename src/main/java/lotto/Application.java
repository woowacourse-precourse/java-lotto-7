package lotto;

import java.util.List;
import java.util.function.Function;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        Player player = new Player();

        System.out.println("구입급액을 입력해 주세요.");
        int purchaseAmount = getInput(inputHandler::parsePurchaseAmount);
        player.buyLottos(purchaseAmount);

        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", player.getLottoAmount());
        System.out.println(player.getLottoDescription());

        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = getInput(inputHandler::parseWinningNumbers);

        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = getInput(inputHandler::parseBonusNumber);

        player.evalutateLottos(winningNumbers, bonusNumber);

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(player.getWinningResult());
        System.out.printf("총 수익률은 %.1f%%입니다.", player.getRateOfReturn());
    }

    /**
     * This function tries to parse input from the Console.
     * If {@code IllegalArgumentException} is thrown during the process, print
     * error message and retry. Repeatetion ends when there's no input remains.
     * 
     * @param <T> The type of return value
     * @param parser The parser function
     * @return Parsed value of type {@code T}
     */
    static <T> T getInput(Function<String, T> parser) {
        while (true) {
            try {
                return parser.apply(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
