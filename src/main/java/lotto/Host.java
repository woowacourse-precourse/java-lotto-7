package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.LottoGenerator.MIN_NUMBER;
import static lotto.LottoGenerator.MAX_NUMBER;

public class Host {

    private Lotto selectedNumbers;
    private int bonusNumber;

    private static final Host host = new Host();

    private Host() {}

    public static Host getHost() {
        return host;
    }

    public void setSelectedNumbers(List<Integer> numbers) {
        this.selectedNumbers = new Lotto(numbers);
    }

    public List<Integer> getSelectedNumbers() {
        return this.selectedNumbers.getNumbers();
    }

    public void setBonusNumber(int bonusNumber) {
        BonusValidate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public int countResult(Lotto lotto) {
        Set<Integer> client = new HashSet<>(lotto.getNumbers());
        Set<Integer> answer = new HashSet<>(selectedNumbers.getNumbers());

        client.retainAll(answer);
        return client.size();
    }

    public boolean isBonus(Lotto lotto) {
        return lotto.getNumbers().contains(this.bonusNumber);
    }

    private void BonusValidate(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(Error.BONUS_NUMBER_INVALID_RANGE.message());
        }
        if (selectedNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(Error.BONUS_NUMBER_DUPLICATED.message());
        }
    }
}
