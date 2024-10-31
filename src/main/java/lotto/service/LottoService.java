package lotto.service;

import lotto.model.Lotto;
import lotto.model.User;
import lotto.utils.Utils;

import java.util.List;

public class LottoService {

    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_PICK_NUM = 6;

    public void buyLottos(User user){
        int buyLottosCount = user.getBuyLottoCount();
        for(int i = 0; i < buyLottosCount; i++){
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
