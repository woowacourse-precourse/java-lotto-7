package lotto;

import java.util.List;
import java.util.function.Function;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Printer printer = new Printer(System.out);
        Player player = new Player();

        printer.purchaseAmountPrompt();
        int purchaseAmount = getInput(InputHandler::parsePurchaseAmount);
        player.buyLottos(purchaseAmount);

        printer.linebreak();
        printer.purchased(player);

        printer.linebreak();
        printer.winningNumberPrompt();
        List<Integer> winningNumbers = getInput(InputHandler::parseWinningNumbers);

        printer.linebreak();
        printer.bonusNumberPrompt();
        int bonusNumber = getInput(InputHandler::parseBonusNumber);

        player.evalutateLottos(winningNumbers, bonusNumber);

        printer.linebreak();
        printer.summary(player);
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
