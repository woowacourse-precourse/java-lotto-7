package lotto.vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineServiceImpl implements VendingMachineService {

    private final VendingMachineRepository vendingMachineRepository;

    public VendingMachineServiceImpl(VendingMachineRepository vendingMachineRepository) {
        this.vendingMachineRepository = vendingMachineRepository;
    }

    @Override
    public List<Lotto> generate(int amount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            List<Integer> numbers = pickRandomNumbers().stream()
                    .sorted()
                    .toList();
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private List<Integer> pickRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return numbers;
    }

    @Override
    public void recordLottos(List<Lotto> lottos) {
        vendingMachineRepository.save(lottos);
    }

    @Override
    public List<Lotto> getIssuedLottoTickets() {
        return vendingMachineRepository.getStoredLottoTickets();
    }

}
