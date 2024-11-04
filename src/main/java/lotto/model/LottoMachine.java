package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.dto.WinningNumberDto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoMachine {
    private final List<Lotto> lottos;
    private final int money;

    public LottoMachine(int money) {
        validateMoney(money);
        this.lottos = createLotto(money);
        this.money = money;
    }

    // Test용 생성자
    public LottoMachine(List<Lotto> lottos) {
        this.lottos = lottos;
        this.money = lottos.size() * 1000;
    }

    private void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위여야 합니다.");
        }
    }

    private List<Lotto> createLotto(int money) {
        List<Lotto> lottos = new ArrayList<>();
        int quantity = money / 1000;
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public List<String> displayLottos() {
        return lottos.stream()
                .map(Lotto::toLottoDto)
                .map(lotto -> lotto.numbers().toString())
                .collect(Collectors.toList());
    }

    public Map<Prize, Integer> calculateWinningCounts(WinningNumber winningNumber) {
        Map<Prize, Integer> prizeCount = new EnumMap<>(Prize.class);
        for (Lotto lotto : lottos) {
            Prize prize = lotto.determinePrize(winningNumber.getNumbers(), winningNumber.getBonus());
            prizeCount.put(prize, prizeCount.getOrDefault(prize, 0) + 1);
        }
        return prizeCount;
    }

    public double calculateReturnRate(Map<Prize, Integer> prizeCount) {
        long totalPrize = calculateTotalPrize(prizeCount);
        return (double) totalPrize / money * 100;
    }

    private long calculateTotalPrize(Map<Prize, Integer> prizeCount) {
        return prizeCount.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getMoney() * entry.getValue())
                .sum();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
