package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {

    public static void printUserLottoNumber(List<Lotto> lottoList){

        System.out.println(lottoList.size()+"개를 구매했습니다.");

        lottoList.stream()
                .map(lotto -> lotto.getNumbers().toString())
                .forEach(System.out::println);

        System.out.println();
    }
}
