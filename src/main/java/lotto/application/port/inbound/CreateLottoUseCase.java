package lotto.application.port.inbound;

import lotto.domain.lotto.Lotto;

import java.util.List;

public interface CreateLottoUseCase {
    List<Lotto> create(int count);
}
