package lotto;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static int budget_input() {
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine().trim();

        return Integer.parseInt(userInput);
    }

    public static List<Integer> lotto_input() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine().trim();
        String[] splitNumbers = userInput.split(",");
        List<Integer> winningNumber = new ArrayList<>();
        for (String number : splitNumbers) {
            winningNumber.add(Integer.parseInt(number));
        }

        return winningNumber;
    }

    public static int bonus_input() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String userInput = Console.readLine().trim();

        return Integer.parseInt(userInput);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int budget = budget_input();
        List<Integer> winningNumber;

        int numToBuy = budget / 1000;
        LottoCollection lottoTickets = new LottoCollection(numToBuy);

        System.out.println("\n" + numToBuy + "개를 구매했습니다.");
        for (Lotto lotto : lottoTickets.getTickets()) {
            lotto.printLottery();
        }

        winningNumber = lotto_input();
        int bonusNumber = bonus_input();

        Lotto winningLotto = new Lotto(winningNumber);

        // check result of lottery
        lottoTickets.checkResult(winningLotto, bonusNumber);

        // print winning results
        lottoTickets.printResult(budget);
    }
}
