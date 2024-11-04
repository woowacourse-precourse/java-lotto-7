package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        private static int inputPurchaseAmount() {
            System.out.println("구입금액을 입력해 주세요.");
            int amount = Integer.parseInt(Console.readLine().trim());

            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 로또 구입금액은 1,000원 단위여야 합니다.");
            }
            return amount;
        }

        private static List<Lotto> purchaseLottos(int purchaseAmount) {
            int lottoCount = purchaseAmount / 1000;
            System.out.println(lottoCount + "개를 구매했습니다.");

            List<Lotto> lottos = new ArrayList<>();
            for (int i = 0; i < lottoCount; i++) {
                List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                        .stream().sorted().collect(Collectors.toList());
                lottos.add(new Lotto(numbers));
                System.out.println(numbers);
            }
            return lottos;
        }

        private static List<Integer> inputWinningNumbers() {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine().trim();
            List<Integer> winningNumbers = Arrays.stream(input.split(","))
                    .map(Integer::parseInt).collect(Collectors.toList());

            if (winningNumbers.size() != 6 || !isValidLottoNumbers(winningNumbers)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
            }
            return winningNumbers;
        }

        private static int inputBonusNumber(List<Integer> winningNumbers) {
            System.out.println("보너스 번호를 입력해 주세요.");
            int bonusNumber = Integer.parseInt(Console.readLine().trim());

            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            if (winningNumbers.contain(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
            }
            return bonusNumber;
        }

        private static boolean isValidLottoNumbers(List<Integar> numbers) {
            return numbers.stream().allMatch(num -> num >= 1 && num <= 45) &&
                    numbers.stream().distinct().count() == numbers.size();
        }

        private static Map<Rank, Integer> calculateResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
            Map<Rank, Integer> result = new EnumMap<>(Rank.class);

            for(Lotto lotto : lottos) {
                int matchCount = (int) lotto.getNumbers().stram().filter(winningNumbers::contains).count();
                boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
                Rank rank = Rank.valueOf(matchCount, bonusMatch);
                result.put(rank, result.getOrDefault(rank, 0) + 1);
            }
            return result;
        }

    }
}

