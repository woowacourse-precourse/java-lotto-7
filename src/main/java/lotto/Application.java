package lotto;
import camp.nextstep.edu.missionutils.Randoms;
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
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine().trim();
        String[] splittedNumber = userInput.split(",");
        List<Integer> winningNumber = new ArrayList<>();
        for (String number : splittedNumber) {
            winningNumber.add(Integer.parseInt(number));
        }

        return winningNumber;
    }

    public static int bonus_input() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String userInput = Console.readLine().trim();

        return Integer.parseInt(userInput);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int budget = budget_input();

        List<Integer> winningNumber = new ArrayList<>();
        winningNumber = lotto_input();

        int bonusNumber = bonus_input();





    }
}
