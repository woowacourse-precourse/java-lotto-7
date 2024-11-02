package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        System.out.println("구입금액을 입력해 주세요.");

        String inputAccount = Console.readLine();

        if (!inputAccount.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자만 입력하세요.");
        }

        int account = Integer.parseInt(inputAccount);
        if (account < 1_000 || account > 100_000) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 최소 1000원부터 최대 10만원입니다.");
        }

        if (account % 1_000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력하세요.");
        }

        int lottoCount = account / 1_000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        System.out.println(lottoCount + "개 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        String[] numbersInputs = Console.readLine().split(",");
        List<String> inputs = Arrays.stream(numbersInputs)
                .map(String::trim)
                .filter(x -> !x.isEmpty())
                .toList();

        if (inputs.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개 입니다.");
        }

        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : inputs) {
            if (!number.matches("\\d+")) {
                throw new IllegalArgumentException("[ERROR] 6개의 당첨번호를 쉼표(,)로 구분하여 입력해주세요.");
            }
            winningNumbers.add(Integer.parseInt(number));
        }

        for (Integer winningNumber : winningNumbers) {
            if (winningNumber < 0 || winningNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 6개의 당첨번호는 모두 1이상 45이하의 숫자입니다.");
            }
        }

        Set<Integer> numbers = new HashSet<>(winningNumbers);
        if (winningNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 6개의 당첨번호는 서로 중복되지 않아야 합니다.");
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();

    }
}
