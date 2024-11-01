package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.Rank;
import lotto.model.User;
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


    public void setWinningResult(LottoGame lottoGame, User user) {
        HashMap<Rank, Integer> winningResultMap = user.getWinningResultMap();

        for(Lotto lotto : user.getLottos()){
            Rank rank = getRank(lottoGame, lotto);
            winningResultMap.put(rank, winningResultMap.get(rank) + 1);
        }
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

}
