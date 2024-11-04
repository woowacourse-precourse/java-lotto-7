package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGroup {
    private final List<Lotto> lottos;

    LottoGroup(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoGroup create(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.getRandom());
        }
        return new LottoGroup(lottos);
    }

    // TODO
    //  ### 로또그룹
    //  - [ ] 일급 컬렉션으로 구현한다.
    //  - [x] N개 만큼 로또 생성
    //  - [ ] 로또에서 받은 번호를 N개 출력한다
    //  - [ ] 로또 등수를 이용하여 통계를 출력한다.
    //  - [ ] 로또 등수를 이용하여 수익율을 계산한다.
    //  - [ ] 로또 수익율 출력한다.
    //
}
