package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConstant;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private int money;

    private LottoGenerator(int money){
        validateMoney(money);
        this.money=money;
    }

    public static LottoGenerator of(int money){
        return new LottoGenerator(money);
    }

    private void validateMoney(int money){
        if(money<0){
            throw new IllegalArgumentException("로또 구매 금액은 음수가 될 수 없습니다.");
        }

        if(money==0 || money%1000!=0){
            throw new IllegalArgumentException("로또 구매 금액은 1,000원 단위가 되어야 합니다.");
        }
    }

    public List<Lotto> publicLottos(){
        List<Lotto> lottos = new ArrayList<>();
        while(money>0 && money%1000==0){
            lottos.add(publicLotto());
            money-=1000;
        }
        return lottos;
    }

    private Lotto publicLotto(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LottoConstant.LOTTO_MIN_NUMBER, LottoConstant.LOTTO_MAX_NUMBER, LottoConstant.LOTTO_PICK_NUMBER);
        return new Lotto(lottoNumbers);
    }

    public int getMoney(){
        return money;
    }

}
