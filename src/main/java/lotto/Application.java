package lotto;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static int budget_input() {
        try {
            System.out.println("\n구입금액을 입력해 주세요.");
            String userInput = Console.readLine().trim();
            int budget = Integer.parseInt(userInput);

            if (budget < 1000 || budget % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액이 1000원보다 작거나 1000원으로 나누어 떨어지지 않습니다.");
            }

            return budget;
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 잘못 입력했습니다.");
        }
    }

    public static List<Integer> lotto_input() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine().trim();
        String[] splitNumbers = userInput.split(",");
        List<Integer> winningNumber = new ArrayList<>();
        for (String number : splitNumbers) {
            try {
                int lottoNum = Integer.parseInt(number);
                winningNumber.add(lottoNum);
            }
            catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 로또 번호를 잘못 입력했습니다.");
            }
        }

        return winningNumber;
    }

    public static int bonus_input(Lotto winningLotto) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String userInput = Console.readLine().trim();
        try {
            int bonusNumber = Integer.parseInt(userInput);

            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호에 1부터 45 사이의 숫자가 아닌 값을 입력했습니다.");
            }

            if (winningLotto.getNumbers().contains(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호가 로또 번호에 포함되어 있습니다.");
            }

            return bonusNumber;
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호에 잘못된 값을 입력했습니다.");
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int budget;
        while (true) {
            try {
                budget = budget_input();
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int numToBuy = budget / 1000;
        LottoCollection lottoTickets = new LottoCollection(numToBuy);

        System.out.println("\n" + numToBuy + "개를 구매했습니다.");
        for (Lotto lotto : lottoTickets.getTickets()) {
            lotto.printLottery();
        }

        List<Integer> winningNumber;
        Lotto winningLotto;
        while (true) {
            try {
                winningNumber = lotto_input();
                winningLotto = new Lotto(winningNumber);
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int bonusNumber;
        while (true) {
            try {
                bonusNumber = bonus_input(winningLotto);
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // check result of lottery
        lottoTickets.checkResult(winningLotto, bonusNumber);

        // print winning results
        lottoTickets.printResult(budget);
    }
}
