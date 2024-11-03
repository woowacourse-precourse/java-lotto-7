package lotto.view;

import java.util.List;
import lotto.view.dto.LottoCountResponse;

public class OutputView {

    public void getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void buyLotto(LottoCountResponse response) {
        System.out.println("\n" + response.lottoCount() + "개를 구매했습니다.");
    }

    public void displayLotto(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public void getWinningNumber() {
        System.out.println(System.lineSeparator() + "당첨 번호를 입력해 주세요.");
    }

    public void getBonusNumber() {
        System.out.println(System.lineSeparator() + "보너스 번호를 입력해 주세요.");
    }
}
