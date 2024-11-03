package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.LottoNumbers;
import lotto.dto.LottoBundle;

public class LottoTicket {
    private List<Lotto> lottoTicket;

    public LottoTicket(List<Lotto> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public LottoBundle getLottoBundle(){
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for(Lotto lotto : lottoTicket) {
            lottoNumbers.add(lotto.getLottoNumbers());
        }
        return new LottoBundle(lottoNumbers);
    }
}
