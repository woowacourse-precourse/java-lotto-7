package module;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PurchaseLotto {

    final int lottoPrice = 1000;

    public List<Lotto> purchase(int money){
        int lottoCount = money / lottoPrice;
        int remains = money % lottoPrice;

        if(lottoCount < 1) {
            throw new IllegalArgumentException("구입 금액은 최소 1,000원이 필요합니다.");
        }

        if(remains > 0)
        {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해주세요.");
        }

        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < lottoCount; i++)
        {
            lottos.add(new Lotto(generateLottoNumbers()));
        }
        return lottos;
    }

    private List<Integer> generateLottoNumbers(){
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
