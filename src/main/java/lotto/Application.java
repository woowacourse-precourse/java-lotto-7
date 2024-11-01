package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String buyAmountInput = Console.readLine();

            int buyAmount = Integer.parseInt(buyAmountInput);

            if (buyAmount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 천원 단위만 입력 가능합니다.");
            }

            int lottoCount = buyAmount / 1000;
            System.out.println("로또 구매 개수: " + lottoCount);

            List<Lotto> lottoNumbers = new ArrayList<>();
            for (int i = 0; i < lottoCount; i++) {
                lottoNumbers.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
                System.out.println(lottoNumbers.get(i).getNumbers());
            }
            System.out.println("당첨 번호를 입력해 주세요.");
            String winningNumberInput = Console.readLine();

            List<Integer> winningNumbers = List.of(winningNumberInput.split(","))
                    .stream()
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusNumberInput = Console.readLine();

            int bonusNumbers = Integer.parseInt(bonusNumberInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
