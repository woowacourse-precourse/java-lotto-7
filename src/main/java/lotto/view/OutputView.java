package lotto.view;

import java.util.List;

public class OutputView {
    private final String LOTTO_COUNT_NOTICE = "개를 구매했습니다.";

    public void printPublishedLotto(List<List<Integer>> publishedLotto){
        int lottoCount = publishedLotto.size();
        System.out.println(lottoCount+LOTTO_COUNT_NOTICE);

        for(int i = 0; i < lottoCount; i++){
            System.out.println(publishedLotto.get(i));
        }
    }
}
