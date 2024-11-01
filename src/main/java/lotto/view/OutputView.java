package lotto.view;

import java.util.List;

public class OutputView {
    public void result(List<List<Integer>> list){
        System.out.println();
        System.out.println(list.size() + "개를 구매했습니다.");
        for(List<Integer> l : list){
            System.out.println(l);
        }
    }
}
