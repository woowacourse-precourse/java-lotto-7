package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private List<Lotto> purchasedLottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoGame() {
        purchasedLottos = new ArrayList<>();
    }

    public void start() {
        purchaseLottos();
        enterWinningNumbers();
        enterBonusNumber();
        displayResult();
    }

    private void purchaseLottos() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
        }

        int numberOfLottos = amount / LOTTO_PRICE;
        System.out.println(numberOfLottos + "개를 구매했습니다.");
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            purchasedLottos.add(lotto);
            System.out.println(lotto.getNumbers());
        }
    }

    private void enterWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        winningNumbers = parseNumbers(input, 6);
    }

    private void enterBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(Console.readLine());
        if (bonusNumber < 1 || bonusNumber > 45 || winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 하며 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

    private List<Integer> parseNumbers(String input, int expectedCount) {
        String[] split = input.split(",");
        if (split.length != expectedCount) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 " + expectedCount + "개여야 합니다.");
        }
        List<Integer> numbers = new ArrayList<>();
        for (String numStr : split) {
            int number = Integer.parseInt(numStr.trim());
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            numbers.add(number);
        }
        if (numbers.stream().distinct().count() != expectedCount) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
        return numbers;
    }

    private void displayResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        int[] matchCounts = new int[5];

        for (Lotto lotto : purchasedLottos) {
            int matchCount = (int) lotto.getNumbers().stream().filter(winningNumbers::contains).count();
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
            if (matchCount == 6) matchCounts[0]++;
            else if (matchCount == 5 && bonusMatch) matchCounts[1]++;
            else if (matchCount == 5) matchCounts[2]++;
            else if (matchCount == 4) matchCounts[3]++;
            else if (matchCount == 3) matchCounts[4]++;
        }

        System.out.printf("3개 일치 (5,000원) - %d개%n", matchCounts[4]);
        System.out.printf("4개 일치 (50,000원) - %d개%n", matchCounts[3]);
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", matchCounts[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", matchCounts[1]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", matchCounts[0]);

        double revenue = matchCounts[4] * 5000 + matchCounts[3] * 50000 + matchCounts[2] * 1500000
                + matchCounts[1] * 30000000 + matchCounts[0] * 2000000000;
        double yield = (revenue / (purchasedLottos.size() * LOTTO_PRICE)) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }
}
