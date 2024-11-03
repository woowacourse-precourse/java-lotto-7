package lotto.model.lotto;

import java.util.List;
import java.util.stream.Collectors;

public record LottoTicket(List<Lotto> lottoTicket) {
    // 구입한 로또들을 티켓으로 관리
    private static final String DELIMITER = "\n";

    public int getSize() {
        return lottoTicket.size();
    }

    @Override
    public List<Lotto> lottoTicket() {
        return List.copyOf(lottoTicket);
    }

    @Override
    public String toString() {
        return lottoTicket.stream()
                .map(Lotto::toString)
                .collect(
                        Collectors.joining(DELIMITER)
                );
    }

}
