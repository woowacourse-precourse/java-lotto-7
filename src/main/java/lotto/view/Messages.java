package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningRank;

public class Messages {
    //Message처럼 상수화하고 싶다.
    public static final String ISSUED_LOTTO(Lotto lotto) {
        StringBuilder issuedLotto = new StringBuilder("[");
        List<Integer> numbers = lotto.getNumbers();
        for (int i = 0; i < 6; i++) {
            issuedLotto.append(numbers.get(i));
            if (i == 5) {
                issuedLotto.append("]");
                break;
            }
            issuedLotto.append(", ");
        }
        return issuedLotto.toString();
    }

    public static final String MATCHING_CONDITION(WinningRank winningRank) {
        StringBuilder matchingContidion = new StringBuilder(
                String.format("%d개 일치", winningRank.getMatchingAmount())
        );
        if (winningRank == WinningRank.SECOND) {
            matchingContidion.append(", 보너스 볼 일치");
        }
        return matchingContidion.toString();
    }

    public static final String PRICE(int priceInteger) {
        StringBuilder price = new StringBuilder(String.valueOf(priceInteger))
                .reverse();
        int insertIndex = 3;
        while (insertIndex < price.length()) {
            price.insert(insertIndex, ",");
            insertIndex += 4;
        }
        return price.reverse().toString();
    }
}
