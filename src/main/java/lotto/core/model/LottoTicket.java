package lotto.core.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.core.dto.LottoTicketDto;

public class LottoTicket {

    private final List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoTicket dtoOf(LottoTicketDto dto) {
        List<Lotto> lottos = dto.lottos().stream().map(Lotto::dtoOf).toList();
        return new LottoTicket(lottos);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public int count() {
        return this.lottos.size();
    }

    public List<WinningRank> getWinningRanks(Lotto winningLotto, LottoNumber bonusNumber) {
        Set<WinningRank> winningRanks = new HashSet<>();
        for (Lotto lotto : this.lottos) {
            int matchCount = lotto.getMatchCount(winningLotto);
            boolean matchBonus = lotto.containsBonusNumber(bonusNumber);
            WinningRank matchRank = WinningRank.match(matchCount, matchBonus);
            if (matchRank == null) continue;
            winningRanks.add(matchRank);
        }
        return new ArrayList<>(winningRanks);
    }
}
