package lotto.view;

import lotto.domain.User;
import lotto.domain.UserLottoNumber;

public class OutputView {

    public static void buyLottoQuantity(User user) {
        System.out.println(user.getLottoQuantity() + "개를 구매했습니다.");
    }

    public static void buyLottoNumber(User user) {
        for (UserLottoNumber userLottoNumber : user.getUserLottoNumber()) {
            System.out.println(userLottoNumber.getLottoNumber());
        }
    }
}
