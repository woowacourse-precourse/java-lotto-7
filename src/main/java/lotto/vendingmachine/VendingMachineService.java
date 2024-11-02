package lotto.vendingmachine;

import java.util.List;

public interface VendingMachineService {

    List<Lotto> generate(int amount);

    void recordLottos(List<Lotto> lottos);

    List<Lotto> getIssuedLottoTickets();
}
