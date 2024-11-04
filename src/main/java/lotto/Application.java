package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
            int purchaseAmount = getPurchaseAmount();
            List<Lotto> purchasedLottos = generateLottos(purchaseAmount / 1000);
            printPurchasedLottos(purchasedLottos);

            List<Integer> winningNumbers = getWinningNumbers();
    }

    // 구입 금액 입력 처리
    private static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        if (amount < 1000 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 유효한 금액을 입력해 주세요 (1,000원 단위).");
        }
        return amount;
    }

    // 로또 발행
    private static List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    // 발행된 로또 출력
    private static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    // 당첨 번호 입력
    private static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] inputs = Console.readLine().split(",");
        if (inputs.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        Set<Integer> winningNumbers = new HashSet<>();
        for (String input : inputs) {
            int number = Integer.parseInt(input.trim());
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 번호는 1에서 45 사이여야 합니다.");
            }
            winningNumbers.add(number);
        }
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
        }
        return new ArrayList<>(winningNumbers);
    }
}