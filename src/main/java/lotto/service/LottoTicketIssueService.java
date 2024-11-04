package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class LottoTicketIssueService {
    private final Integer lottoTicketAmount;
    private final LottoNumberGeneratorService lottoNumberGeneratorService;

    public LottoTicketIssueService(Integer lottoTicketAmount, LottoNumberGeneratorService lottoNumberGeneratorService) {
        this.lottoTicketAmount = lottoTicketAmount;
        this.lottoNumberGeneratorService = lottoNumberGeneratorService;
    }

    public List<Lotto> issueLotto() {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoTicketAmount; i++) {
            lottoList.add(new Lotto(lottoNumberGeneratorService.generateRandomLottoNumbers()));
        }
        return lottoList;
    }
}
