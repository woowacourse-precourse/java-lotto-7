package lotto.View;

import static lotto.Util.Constant.IOMessage.OUTPUT_LOTTO_COUNT;

import java.util.List;
import lotto.DTO.RandomLottoNumberDTO;
import lotto.Domain.Lotto;
import lotto.Domain.LottoTickets;

public class OutputView {
    private LottoTickets lottoTickets;
    private List<Lotto> lottos;
    private Integer lottoPurchaseCount;

    public void outputRandomLottoNumber(RandomLottoNumberDTO randomLottoNumberDTO) {
        this.lottoTickets = randomLottoNumberDTO.getLottoTickets();
        this.lottos = lottoTickets.getTickets();
        this.lottoPurchaseCount = lottoTickets.getTicketCount();

        System.out.println(OUTPUT_LOTTO_COUNT.format(lottoPurchaseCount));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

}
