package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.List;

public class OutputView {

    public void purchaseLottoMessage(int count, Lottos lottos) {
        StringBuilder stringBuilder = new StringBuilder("\n" + count + "개를 구매했습니다.\n");

        lottos.getLottos().stream()
                .forEach(lotto -> stringBuilder.append(lotto.getNumbers() + "\n"));

        stringBuilder.append("\n");
        System.out.println(stringBuilder);
    }

    public void amountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void winningNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void bonusNumberMessage(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

}
