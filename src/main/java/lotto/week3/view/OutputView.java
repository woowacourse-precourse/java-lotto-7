package lotto.week3.view;

import java.util.List;

public class OutputView {

    public void lottoOutput(List<List<Integer>> lotto){
        System.out.println(lotto.size() + " 개를 구매했습니다.");
        System.out.println(lotto);
    }
}
