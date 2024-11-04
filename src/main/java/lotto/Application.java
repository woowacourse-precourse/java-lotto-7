package lotto;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 구입 금액 입력 및 유효성 검증
        try {
            // 구입 금액 입력 및 유효성 검증
            int purchaseAmount = validatePurchaseAmount();

            // 로또 번호 발행
            List<Lotto> userLottos = publishLottos(purchaseAmount);
            System.out.println(userLottos.size() + "개를 구매했습니다.");


        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
    //로또 번호 생성 기능
    private static Lotto generateLotto() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        numbers.sort(Integer::compareTo); // 번호 오름차순 정렬
        return new Lotto(numbers);
    }
    //구입 금액 입력 및 유효성 검증 기능 추가
    private static int validatePurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            int amount = Integer.parseInt(Console.readLine());
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해 주세요.");
        }
    }
    //로또 티켓 발행기능
    private static List<Lotto> publishLottos(int amount) {
        int count = amount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }



}