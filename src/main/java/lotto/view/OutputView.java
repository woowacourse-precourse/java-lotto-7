package lotto.view;

import java.util.List;

public class OutputView {

    public void getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void buyLotto(int lottoCount) {
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
    }

    public void displayLotto(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public void getWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }
}
