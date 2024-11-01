package lotto.application.dto.request;

import lotto.domain.cost.Cost;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;

import java.util.List;

public record ManageLottoRequest(Cost cost, List<Lotto> lottos, WinningLotto winningLotto) implements Request {
}
