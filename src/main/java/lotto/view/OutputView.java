package lotto.view;

import java.util.List;

public class OutputView {

    public void printLottoStatus(List<List<Integer>> Lottos) {
        System.out.println(Lottos.size() + "개를 구입했습니다.");
        for (List<Integer> lotto : Lottos) {
            System.out.println(lotto);
        }
    }
}
