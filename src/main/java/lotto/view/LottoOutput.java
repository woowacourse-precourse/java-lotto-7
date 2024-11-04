package lotto.view;

import java.util.List;
import lotto.entity.Lotto;
import lotto.entity.Lottos;
import lotto.entity.Prize;

public class LottoOutput {

    public void requestMoney() {
        System.out.println();
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public void printAboutLottos(Lottos lottos) {
        System.out.println();

        int numOfLottos = lottos.getNumberOfLottos();
        System.out.println(numOfLottos + "개를 구매했습니다.");

        for (Lotto lotto : lottos.getLottos()) {
            printLottoInfo(lotto);
        }
    }

    private void printLottoInfo(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();

        System.out.print("[");
        System.out.print(String.join(", ", numbers.stream().map(String::valueOf).toArray(String[]::new)));
        System.out.println("]");
    }
}
