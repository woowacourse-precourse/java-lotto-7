package lotto.view;

import java.util.Collections;
import java.util.List;

public class OutputView {
    // TODO: 발행된 로또 번호 출력
    public void printGeneratedNum(List<List<Integer>> lottos){
        System.out.printf("\n%d개를 구매했습니다.\n",lottos.size());
        for(List<Integer> lotto : lottos){
            Collections.sort(lotto);
            System.out.println(lotto);
        }
    }
    // TODO: 당첨 내역 출력
    // TODO: 총 이익률 출력
}
