package lotto.core.model;

import java.util.ArrayList;
import java.util.List;
import lotto.core.dto.LottoTicketDto;
import lotto.core.enums.WinningRank;

public class LottoTicket {

    private final LottoPurchaseAmount amount;

    private final List<Lotto> lottos;

    public LottoTicket(LottoPurchaseAmount amount, List<Lotto> lottos) {
        this.amount = amount;
        this.lottos = lottos;
    }

    public static LottoTicket dtoOf(LottoTicketDto dto) {
        LottoPurchaseAmount amount = LottoPurchaseAmount.dtoOf(dto.amount());
        List<Lotto> lottos = dto.lottos().stream().map(Lotto::dtoOf).toList();
        return new LottoTicket(amount, lottos);
    }

    public LottoPurchaseAmount getAmount() {
        return this.amount;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public int count() {
        return this.lottos.size();
    }

    public List<WinningRank> getWinningRanks(Lotto winningLotto, LottoNumber bonusNumber) {
        List<WinningRank> winningRanks = new ArrayList<>();
        for (Lotto lotto : this.lottos) {
            int matchCount = lotto.getMatchCount(winningLotto);
            boolean matchBonus = lotto.containsBonusNumber(bonusNumber);
            WinningRank matchRank = WinningRank.match(matchCount, matchBonus);
            if (matchRank == null) continue;
            winningRanks.add(matchRank);
        }
        return winningRanks;
    }
}
