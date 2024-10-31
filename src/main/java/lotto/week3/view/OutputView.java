package lotto.week3.view;

import java.util.List;
import lotto.week3.domain.Lotto;

public class OutputView {

    public static void lottoOutput(List<Lotto> lotto){
        System.out.println(lotto.size() + " 개를 구매했습니다.");
        System.out.println(lotto);
    }
}
