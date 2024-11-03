package lotto.domain;

import lotto.dto.MatchResult;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    private final List<Lotto> ticket;

    private LottoTicket(List<Lotto> lottos) {
        validateNonEmptyTicket(lottos);
        this.ticket = List.copyOf(lottos);
    }

    public static LottoTicket of(LottoNumberGenerator lottoNumberGenerator, PurchaseAmount purchaseAmount) {
        int quantity = purchaseAmount.countLottoQuantity();
        return new LottoTicket(generateLottos(lottoNumberGenerator, quantity));
    }

    public List<MatchResult> gatherMatchResult(WinningNumber winningNumber, BonusNumber bonusNumber) {
        return ticket.stream()
                .map(lotto -> lotto.compareWithWinningNumbers(winningNumber, bonusNumber))
                .toList();
    }

    public List<Lotto> getTicket() {
        return ticket;
    }

    private static List<Lotto> generateLottos(LottoNumberGenerator lottoNumberGenerator, int lottoQuantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoQuantity; i++) {
            lottos.add(createLotto(lottoNumberGenerator));
        }
        return lottos;
    }

    private static Lotto createLotto(LottoNumberGenerator lottoNumberGenerator) {
        List<Integer> numbers = lottoNumberGenerator.generate();
        return new Lotto(numbers);
    }

    private void validateNonEmptyTicket(List<Lotto> lottos) {
        if (lottos.isEmpty()) {
            throw new IllegalArgumentException("로또 티켓은 하나 이상의 로또를 포함해야 합니다.");
        }
    }
}
