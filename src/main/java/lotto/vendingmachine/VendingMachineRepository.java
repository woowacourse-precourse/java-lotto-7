package lotto.vendingmachine;

import java.util.List;

public interface VendingMachineRepository {

    void save(List<Lotto> lottos);

    List<Lotto> getStoredLottoTickets();
}
