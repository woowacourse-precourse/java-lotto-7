package lotto.console.view;

import java.util.List;
import lotto.lotto.domain.Lotto;
import lotto.user.domain.User;

public class OutputView {


    public void printUserLottos(User user) {
        List<Lotto> lottos = user.getLottos();
        System.out.println(lottos.size() + "개를 구매했습니다.");

        lottos.forEach(this::printLotto);
    }

    private void printLotto(Lotto lotto) {
        System.out.println(lotto);
    }
}
