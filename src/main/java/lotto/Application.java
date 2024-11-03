package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        Host host = Host.getHost();

        System.out.println("구입금액을 입력해 주세요.");

        String inputAccount = Console.readLine();

        if (!inputAccount.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자만 입력하세요.");
        }

        int account = Integer.parseInt(inputAccount);
        int lottoCount = LottoGenerator.howManyLottos(account);
        List<Lotto> lottos = LottoGenerator.getLottos(lottoCount);

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

        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : inputs) {
            if (!number.matches("\\d+")) {
                throw new IllegalArgumentException("[ERROR] 6개의 당첨번호를 쉼표(,)로 구분하여 입력해주세요.");
            }
            winningNumbers.add(Integer.parseInt(number));
        }

        host.setSelectedNumbers(winningNumbers);

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusInput = Console.readLine();
        if (!bonusInput.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요.");
        }
        host.setBonusNumber(Integer.parseInt(bonusInput));

        Map<WinningKind, Integer> lottoResult = new HashMap<>();
        for (WinningKind winningKind : WinningKind.values()) {
            lottoResult.put(winningKind, 0);
        }

        for (Lotto lotto : lottos) {  // `lottos`는 구입한 로또 목록
            int matchCount = host.countResult(lotto);
            boolean bonus = false;
            if (host.isBonus(lotto)) {
                matchCount++;
                bonus = true;
            }

            WinningKind kind = WinningKind.getWinningKind(matchCount, bonus);
            lottoResult.put(kind, lottoResult.get(kind) + 1);
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



}
