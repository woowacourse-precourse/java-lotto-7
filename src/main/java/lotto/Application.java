package lotto;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // 당첨 번호와 보너스 번호 입력받기
        System.out.println("당첨 번호를 입력하세요.(숫자는 쉼표(,) 기준으로 구분)");
        String input = readLine();
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("보너스 번호를 입력하세요.");
        input = readLine();
        int bonusNum = Integer.parseInt(input);
        WinningNumbers winningNumbers = new WinningNumbers(numbers, bonusNum);

        // 로또 구입 금액 입력받기
        input = readLine();
        buyLotto(Integer.parseInt(input));

    }

    static public void buyLotto(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000으로 나눠떨어져야 합니다.");
        }

        int numberOfLottos = amount / 1000; // 로또 개수 계산
    }
}
