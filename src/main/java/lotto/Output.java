package lotto;

import java.time.LocalDate;
import java.util.stream.Collectors;

public class Output {
    static final String FIFTH = "3개 일치 (5,000원) - ";
    static final String FOURTH = "4개 일치 (50,000원) - 개";
    static final String THIRD = "5개 일치 (1,500,000원) - 개";
    static final String SECOND = "5개 일치, 보너스 볼 일치 (30,000,000원) - 개";
    static final String FIRST = "6개 일치 (2,000,000,000원) - 개";
    public static void currentLottos(MyLotto myLotto) {
        for (Lotto lotto : myLotto.getLottos()) {
            String balls = lotto.getNumbers().stream()
                            .map(String::valueOf)
                                    .collect(Collectors.joining(", "));
            System.out.println("[" + balls + "]");
        }
        System.out.println();
    }

    public void totalPrice(PriceStats priceStats) {
        System.out.println(FIFTH + priceStats.get(0) + "개");
        System.out.println(FOURTH + priceStats.get(1) + "개");
        System.out.println(THIRD + priceStats.get(2) + "개");
        System.out.println(SECOND + priceStats.get(3) + "개");
        System.out.println(FIRST + priceStats.get(4) + "개");
    }
}
