package lotto.model.dto;

import lotto.model.domain.Lotto;

import java.util.Collections;
import java.util.List;

public record LottosResponse(
        List<Lotto> lottos
) {

    public LottosResponse(List<Lotto> lottos) {
        this.lottos = List.copyOf(lottos);
    }

    @Override
    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos); // 수정할 수 없는 리스트 반환
    }

    public int getCount() {
        return lottos.size();
    }
}
