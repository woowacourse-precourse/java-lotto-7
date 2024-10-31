package lotto;

import java.util.List;


public class UserView {

    public void displayInputMessageOfLottoAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void displayInputMessageOfWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void displayInputMessageOfBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void displayCountOfLottos(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void displayLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

}
