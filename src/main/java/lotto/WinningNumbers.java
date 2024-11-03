package lotto;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WinningNumbers {
    private static final int COUNT = 6;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException(String.format("[ERROR] 당첨 번호는 %d개여야 합니다.", COUNT));
        }
        for (Integer number : numbers) {
            if (!(START_NUMBER <= number && number <= END_NUMBER)) {
                throw new IllegalArgumentException(
                        String.format("[ERROR] 당첨 번호는 %d~%d사이의 번호여야 합니다.", START_NUMBER, END_NUMBER)
                );
            }
        }
        Set<Integer> s = new HashSet<>();
        for (Integer number : numbers) {
            if(!s.add(number)){
                throw new IllegalArgumentException(
                        String.format("[ERROR] 중복된 번호가 있습니다: (%d).", number)
                );
            }
        }

        if (!(START_NUMBER <= bonusNumber && bonusNumber <= END_NUMBER)) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 보너스 번호는 %d~%d사이의 번호여야 합니다.", START_NUMBER, END_NUMBER));
        }

        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복이 되면 안됩니다.");
        }
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<Rank, Integer> countRank(List<Lotto> lottos) {
        Map<Rank, Integer> counts = initRankCounts();
        for (Lotto lotto : lottos) {
            Rank rank = judgeRank(lotto);
            counts.put(rank, counts.get(rank) + 1);
        }
        return counts;
    }

    private Map<Rank, Integer> initRankCounts() {
        Map<Rank, Integer> counts = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            counts.put(rank, 0);
        }
        return counts;
    }

    public Rank judgeRank(Lotto lotto) {
        return Rank.from(
                countMatch(lotto),
                hasMatchNumber(lotto)
        );
    }

    public int countMatch(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::hasNumber)
                .count();
    }

    public boolean hasMatchNumber(Lotto lotto) {
        return lotto.hasNumber(bonusNumber);
    }

}
