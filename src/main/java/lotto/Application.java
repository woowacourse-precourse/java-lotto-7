package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> numbers;
        Integer specNum;

        System.out.println("구입금액을 입력해 주세요");
        Integer amount = Integer.valueOf(Console.readLine());

        System.out.println(amount + "개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lotto.printNumbers();
            lottos.add(lotto);
        }

        System.out.println();
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                numbers = Arrays.stream(Console.readLine().split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .toList();

                validate(numbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println();
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                specNum = Integer.valueOf(Console.readLine());
                validateOne(specNum);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


        for (Lotto lotto : lottos) {
            lotto.checkForWinning(numbers, specNum);
        }
    }

    static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for (Integer number : numbers) {
            validateOne(number);
        }
    }

    static void validateOne(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
