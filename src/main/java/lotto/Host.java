package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.LottoGenerator.MIN_NUMBER;
import static lotto.LottoGenerator.MAX_NUMBER;

public class Host {

    private Lotto selectedNumbers;
    private int bonusNumber;

    private static Host host = new Host();

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
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1이상 45이하의 숫자입니다.");
        }
        if (selectedNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호 6개와 중복될 수 없습니다.");
        }
    }
}
