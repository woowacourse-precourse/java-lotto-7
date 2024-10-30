package lotto;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstant;

public class LottoMachineService {
    LottoService lottoService = new LottoService();

    public int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount/ LottoConstant.LOTTO_PRICE;
    }


    public LottoTickets createLottoTickets(int purchaseAmount) {
        int lottoTicketAmount = calculateLottoCount(purchaseAmount);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoTicketAmount; i++){
            lottos.add(lottoService.createLotto());
        }
        return new LottoTickets(lottos);
    }
}
