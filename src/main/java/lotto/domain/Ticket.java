package lotto.domain;

import java.util.EnumMap;
import java.util.List;

public class Ticket {
    private final List<Lotto> lottos;
    private final int price;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Ticket(List<Lotto> lottos, int price, List<Integer> winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.price = price;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        validatePrice(price);
        validateDuplication(winningNumbers);
        validateBonusNumber(bonusNumber);
    }

    public EnumMap<Prize, Integer> getLottoResults() {
        EnumMap<Prize, Integer> lottoResults = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.values()) {
            lottoResults.put(prize, 0);
        }

        lottos.forEach(lotto -> {
            Prize prize = Prize.getPrize(lotto, winningNumbers, bonusNumber);
            lottoResults.put(prize, lottoResults.get(prize) + 1);
        });

        return lottoResults;
    }

    private void validatePrice(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입은 1,000원 단위로 구입해야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
