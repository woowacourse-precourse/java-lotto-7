package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.WinningResult;
import lotto.utils.Utils;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;
    private final int lottoAmount;
    private final List<Lotto> userLottoList = new ArrayList<>();
    private final List<WinningResult> winningResultList = new ArrayList<>();

    public LottoGame(int lottoCost){

        this.lottoAmount = lottoCost / LOTTO_PRICE;
    }

    public List<Lotto> generateUserLotto(){

        for(int i = 0; i < lottoAmount; i++){

            userLottoList.add(new Lotto(Utils.generateLottoNumber()));
        }

        return userLottoList;
    }

    public List<Lotto> getUserLottoList() {
        return userLottoList;
    }

    private int checkMatchCount(Lotto lotto, List<Integer> winningNumbers) {

        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }




}
