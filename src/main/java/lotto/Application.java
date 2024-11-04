package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        user.getPrice();
        Lotto lotto = new Lotto(user.getNumber());
        lotto.checkBonusDupl(user.getBonus(), user.getLottoNumbers());
        lotto.getResult(user.getBonus(), user.getLottoNumbers(), user.gotPrice());
    }
}
