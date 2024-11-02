package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private List<Lotto> lottos;

    public LottoNumbers(int totalLottoPrice) {
        this.lottos = new ArrayList<>();
        int lottoCount = totalLottoPrice / 10;
        for(int i = 0; i < lottoCount; i++){
            this.lottos.add(new Lotto(createLotto()));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private List<Integer> createLotto() {
        return camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1,45,6);
    }
}
