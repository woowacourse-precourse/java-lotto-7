package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        try {
            int amount = inputAmount();
            List<Lotto> purchasedLottos = purchaseLottos(amount / LOTTO_PRICE);
            printLottos(purchasedLottos);
            List<Integer> winningNumbers = inputWinningNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int inputAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                int amount = Integer.parseInt(Console.readLine());
                if (amount < LOTTO_PRICE || amount % LOTTO_PRICE != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
                }
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Lotto> purchaseLottos(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(generateLottoNumbers()));
        }
        return lottos;
    }

    private static List<Integer> generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return numbers;
    }

    private static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    // 당첨 번호 입력 메서드 - 유효성 검사는 Lotto 클래스에서 처리
    private static List<Integer> inputWinningNumbers() {
        while (true) {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            try {
                String input = Console.readLine();
                String[] inputs = input.split(",");
                List<Integer> winningNumbers = new ArrayList<>();
                for (String num : inputs) {
                    winningNumbers.add(Integer.parseInt(num.trim()));
                }
                return winningNumbers;
            } catch (Exception e) {
                System.out.println("[ERROR] 올바른 형식의 당첨 번호를 입력해 주세요.");
            }
        }
    }
}