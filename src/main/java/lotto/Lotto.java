package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    int bonusNumber;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        for(int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public void validateBonusNumber(int bonusNumber) {

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }


    public LottoRank findRank(LottoTicket ticket) {
        long matchCount = ticket.getNumbers().stream()
                .filter(numbers::contains)
                .count();

        boolean hasBonus = ticket.getNumbers().contains(bonusNumber);

        for (LottoRank rank : LottoRank.values()) {
            if (rank.getMatchCount() == matchCount && rank.hasBonus() == hasBonus) {
                return rank;
            }
        }

        return LottoRank.NONE;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                ", bonusNumber=" + bonusNumber +
                '}';
    }
}
