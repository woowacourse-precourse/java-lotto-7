package lotto.view;

import lotto.domain.User;
import lotto.domain.UserLotto;

public class OutputView {

    public static void buyLottoQuantity(User user) {
        System.out.println();
        System.out.println(user.getLottoQuantity() + "개를 구매했습니다.");
    }

    public static void buyLottoNumber(User user) {
        for (UserLotto userLotto : user.getUserLotto()) {
            System.out.println(userLotto.getLottoNumber());
        }
    }
}
