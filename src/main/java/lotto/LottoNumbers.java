package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    private final List<Lotto> lottos;
    private final int lottoCount;

    public LottoNumbers(int totalLottoPrice) {
        this.lottos = new ArrayList<>();
        this.lottoCount = totalLottoPrice / 1000;
        for(int i = 0; i < lottoCount; i++){
            this.lottos.add(new Lotto(createLotto()));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private List<Integer> createLotto() {
        List<Integer> lottoNumbers = new ArrayList<>(camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1,45,6));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public void printLottos() {
        System.out.println("\n"+lottoCount + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(Arrays.toString(lotto.getNumbers().toArray()));
        }
    }
}
