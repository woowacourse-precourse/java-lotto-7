package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Lotties {
    private final List<Lotto> lottoTickets = new ArrayList<>();

    public void addLotto(List<Integer> generatedLottoNumbers) {
        /*
        final인데 어떻게 더할 수 있는거야?
        -> final로 선언된 변수는 참조 자체를 변경할 수 없다는 의미이지, 그 객체의 내용물이 불변이라는 뜻은 아닙니다.
         */

        lottoTickets.add(new Lotto(generatedLottoNumbers));
    }

    // 현재 보유한 모든 로또 티켓 조회
    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}