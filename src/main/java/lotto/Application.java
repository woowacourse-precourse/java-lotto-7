package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> purchasedLottos = issueLottos(purchaseAmount);
        printLottos(purchasedLottos);
    }

    private static int getPurchaseAmount() {
        int amount = 0;

        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                amount = Integer.parseInt(Console.readLine());

                // 1000원 단위 확인하기
                if (amount <= 0 || amount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
                }
                break; // 유효한 금액이면 반복문 탈출

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return amount;
    }

    private static List<Lotto> issueLottos(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / 1000; // 로또 한 장당 1,000원
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers); // 오름차순 정렬
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
