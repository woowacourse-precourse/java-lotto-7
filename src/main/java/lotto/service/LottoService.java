package lotto.service;

import lotto.model.Lotto;
import lotto.model.User;
import lotto.utils.Utils;

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

}
