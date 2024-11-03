package lotto.vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineRepositoryImpl implements VendingMachineRepository {

    private static List<Lotto> lottoStorage = new ArrayList<>();

    @Override
    public void save(List<Lotto> lottos) {
        lottoStorage.addAll(lottos);
    }

    @Override
    public List<Lotto> getStoredLottoTickets() {
        return lottoStorage;
    }
}
