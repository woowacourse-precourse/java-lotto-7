package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public class LottoPrizeService {
    private List<Lotto> randomLottos;
    private WinningLotto winningLotto;


    public LottoPrizeService(List<Lotto> randomLottos, WinningLotto winningLotto) {
        this.randomLottos = randomLottos;
        this.winningLotto = winningLotto;
    }

//    public void lottoMatchCount() {
//        List<Integer> matchCounts = new ArrayList<>();
//        for (Lotto randomLotto : randomLottos) {
//            matchCounts.add(eachLottoNumberMatch(randomLotto));
//        }
//    }
//
//    private Integer eachLottoNumberMatch(Lotto eachLotto) {
//        int count = 0;
//        List<Integer> numbers = eachLotto.getLotto();
//        for (Integer number : numbers) {
//            if(number.equals(getWinningLottoNumber())){
//                count++;
//            }
//        }
//        return count;
//    }
//
//    private Integer getWinningLottoNumber() {
//
//    }
}
