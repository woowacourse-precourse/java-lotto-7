package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public class Ticket {
    private final List<Lotto> lottos;
    private final int price;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final EnumMap<Prize, Integer> result;

    public Ticket(List<Lotto> lottos, int price, List<Integer> winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.price = price;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        validate(price, winningNumbers, bonusNumber);
        this.result = makeResult();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public EnumMap<Prize, Integer> getResult() {
        return this.result;
    }

    public double getEarningRate() {
        int totalPrize = result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();

        double earningRate = (double) totalPrize / price;
        return Math.round(earningRate * 10) / 10.0;
    }

    private void validate(int price, List<Integer> winningNumbers, int bonusNumber) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입은 1,000원 단위로 구입해야 합니다.");
        }

        for (int winningNumber : winningNumbers) {
            if (winningNumber < 0 || winningNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45숫자만 가능합니다.");
            }
        }

        if (bonusNumber < 0 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45숫자만 가능합니다.");
        }

        if (winningNumbers.size() != winningNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private EnumMap<Prize, Integer> makeResult() {
        EnumMap<Prize, Integer> result = new EnumMap<>(Prize.class);
        Arrays.stream(Prize.values()).forEach(prize -> result.put(prize, 0));

        lottos.forEach(lotto -> {
            Prize prize = Prize.getPrize(lotto, winningNumbers, bonusNumber);
            result.put(prize, result.getOrDefault(prize, 0) + 1);
        });

        return result;
    }
}
