package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumAllocation {

    private List<Lotto> purchasedLottos;
    public RandomNumAllocation(int purchaseAmount) {

        //구매한 로또 개수만큼 로또 번호 발행
        int numOfLotto=purchaseAmount/1000;
        purchasedLottos=new ArrayList<>();

        for (int i=0;i<numOfLotto;i++) {
            List<Integer> randomNum=Randoms.pickUniqueNumbersInRange(1,45,6);
            Collections.sort(randomNum);
            Lotto lotto=new Lotto(randomNum);

            purchasedLottos.add(lotto);
        }

    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }
}
