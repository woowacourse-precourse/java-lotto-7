package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class Messages {
    //Message처럼 상수화하고 싶다.
    public static final StringBuilder ISSUED_LOTTO(Lotto lotto) {
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
        return issuedLotto;
    }
}
