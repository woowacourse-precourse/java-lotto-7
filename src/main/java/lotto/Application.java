package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

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
        String bonusInput = Console.readLine();
        if (!bonusInput.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요.");
        }
        int bonusNumber = Integer.parseInt(bonusInput);
        if (bonusNumber < 0 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1이상 45이하의 숫자입니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호 6개와 중복될 수 없습니다.");
        }

        Map<WinningKind, Integer> lottoResult = new HashMap<>();
        for (WinningKind winningKind : WinningKind.values()) {
            lottoResult.put(winningKind, 0);
        }

        for (Lotto lotto : lottos) {  // `lottos`는 구입한 로또 목록
            int matchCount = getMatchCount(lotto.getNumbers(), winningNumbers);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            if (matchCount == 6) {
                lottoResult.put(WinningKind.MATCH_6, lottoResult.get(WinningKind.MATCH_6) + 1);
            } else if (matchCount == 4 && bonusMatch) {
                lottoResult.put(WinningKind.MATCH_5_BONUS, lottoResult.get(WinningKind.MATCH_5_BONUS) + 1);
            } else if (matchCount == 5) {
                lottoResult.put(WinningKind.MATCH_5, lottoResult.get(WinningKind.MATCH_5) + 1);
            } else if (matchCount == 4) {
                lottoResult.put(WinningKind.MATCH_4, lottoResult.get(WinningKind.MATCH_4) + 1);
            } else if (matchCount == 3) {
                lottoResult.put(WinningKind.MATCH_3, lottoResult.get(WinningKind.MATCH_3) + 1);
            }
        }

        System.out.println("당첨 통계\n---");

        int totalPrize = 0;
        for (WinningKind kind : WinningKind.values()) {
            int count = lottoResult.get(kind);
            int prize = kind.getPrize();
            totalPrize += count * prize;
            if (kind == WinningKind.MATCH_5_BONUS) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%d원) - %d개\n",
                        kind.getMatchCount(), prize, count);
            } else {
                System.out.printf("%d개 일치 (%d원) - %d개\n",
                        kind.getMatchCount(), prize, count);
            }
        }

        double yield = (double) totalPrize / account * 100;
        System.out.printf("총 수익률은 %.2f%%입니다.\n", yield);

    }

    public static int getMatchCount(List<Integer> numbers, List<Integer> winningNumbers) {
        Set<Integer> myLotto = new HashSet<>(numbers);
        Set<Integer> answer = new HashSet<>(winningNumbers);

        myLotto.retainAll(answer);
        return myLotto.size();
    }

}
