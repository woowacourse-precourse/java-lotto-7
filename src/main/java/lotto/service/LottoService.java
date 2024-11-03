package lotto.service;

import lotto.model.*;
import lotto.utils.Utils;

import java.util.HashMap;
import java.util.List;

import static lotto.Constants.*;

public class LottoService {

    public void buyLottos(User user){
        int buyLottoCount = user.getBuyLottoCount();
        for(int i = 0; i < buyLottoCount; i++){
            user.buyLotto(createRandomLotto());
        }
    }

    private Lotto createRandomLotto(){
        return new Lotto(getRandomLottoNumber());
    }

    private List<Integer> getRandomLottoNumber(){
        return Utils.generateRandomNumber(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_PICK_NUM);
    }


    public LottoResult setLottoResult(LottoGame lottoGame, User user) {
        HashMap<Rank, Integer> lottoResultMap = Rank.initRank();

        for(Lotto lotto : user.getLottos()){
            Rank rank = getRank(lottoGame, lotto);
            lottoResultMap.put(rank, lottoResultMap.get(rank) + 1);
        }

        return new LottoResult(lottoResultMap);
    }

    private Rank getRank(LottoGame lottoGame, Lotto lotto){
        List<Integer> winningNumbers = lottoGame.getWinningNumbers();
        int bonusNumber = lottoGame.getBonusNumber();

        int correctCount = lotto.getWinningCount(winningNumbers);
        int bonusCount = lotto.getBonusCount(bonusNumber);

        return Rank.getRank(correctCount, bonusCount);
    }

    public double getReturnRate(User user, LottoResult lottoResult){
        return ((double) getTotalPrize(lottoResult) / user.getBuyAmount())*100;
    }

    private int getTotalPrize(LottoResult lottoResult) {
        int totalPrize = 0;
        for(Rank rank : Rank.values()){
            totalPrize += rank.getPrize() * lottoResult.getLottoResultMap().get(rank);
        }

        return totalPrize;
    }

}
