package lotto.view;

import lotto.domain.AutoLotto;

import java.util.List;

public class OutputView {

    public void lottoCount(long lottoCount) {
        System.out.println();
        System.out.println(lottoCount+"개를 구매했습니다.");
    }

    public void lottos(List<AutoLotto> autoLottoList) {
        autoLottoList.stream()
                .map(AutoLotto::getNumbers)
                .forEach(System.out::println);
    }
}
