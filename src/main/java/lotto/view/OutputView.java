package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {
    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        lottos.stream().map(Lotto::getNumbers).forEach(System.out::println);
    }

}
