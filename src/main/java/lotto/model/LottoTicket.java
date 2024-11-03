package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottoList;

    // 생성자 - 전달받은 로또 리스트로 초기화
    public LottoTicket(List<Lotto> lottoList) {
        this.lottoList = new ArrayList<>(lottoList); // 방어적 복사로 리스트 초기화
    }

    // Lotto 리스트를 반환 (수정 불가한 리스트로 제공)
    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottoList); // 외부에서 리스트를 수정하지 못하도록 방지
    }

    // 로또를 추가하는 메서드
    public void addLotto(Lotto lotto) {
        lottoList.add(lotto); // 새로운 로또를 리스트에 추가
    }
}
