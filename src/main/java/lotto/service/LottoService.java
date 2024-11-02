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
        int correctCount = getCorrectCount(lottoGame.getWinningNumbers(), lotto.getNumbers());
        int bonusCount = getBonusCount(lottoGame.getBonusNumber(), lotto.getNumbers());

        return Rank.getRank(correctCount, bonusCount);
    }

    private int getCorrectCount(List<Integer> winningNumbers, List<Integer> lottoNumbers){
        int correctCount = 0;
        for(int winningNumber : winningNumbers){
            if(lottoNumbers.contains(winningNumber)){
                correctCount++;
            }
        }
        return correctCount;
    }

    private int getBonusCount(int bonusNumber, List<Integer> lottoNumbers){
        if(lottoNumbers.contains(bonusNumber)){
            return 1;
        }
        return  0;
    }

    public double getReturnRate(User user, LottoResult lottoResult){
        return (double) user.getBuyAmount() / getTotalPrize(lottoResult);
    }

    private int getTotalPrize(LottoResult lottoResult) {
        int totalPrize = 0;
        for(Rank rank : Rank.values()){
            totalPrize += rank.getPrize() * lottoResult.getLottoResultMap().get(rank);
        }

        return totalPrize;
    }

}
