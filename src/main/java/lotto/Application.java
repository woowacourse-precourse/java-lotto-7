package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        // 1 . 구매 금액 입력 및 로또 수량 계산
        System.out.println("구입금액을 입력해 주세요.");
        int purchasePrice = getValidPurchasePrice();
        int lottoQuantity = purchasePrice / 1000;

        // 2 . 로또 번호 생성 및 저장
        List<Lotto> lottoRepository = new ArrayList<>();
        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer> lotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lotto);
            lottoRepository.add(new Lotto(lotto));
        }

        // 3 . 로또 번호 출력
        System.out.println(lottoQuantity + "개를 구매했습니다.");
        for (Lotto lotto : lottoRepository) {
            System.out.println(lotto.getNumbers());
        }


    }

    private static int getValidPurchasePrice() {
        while (true) {
            try {
                int purchasePrice = getInt(Console.readLine());
                if (purchasePrice < 1000 || purchasePrice % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 구매 금액은 1000이상, 1000원 단위여야 합니다.");
                }
                return purchasePrice;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("구입금액을 입력해 주세요.");
            }
        }
    }
    
    private static int getInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요");
        }
    }
}
