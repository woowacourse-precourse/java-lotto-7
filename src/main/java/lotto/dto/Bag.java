package lotto.dto;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private int numberOfLottoTickets;
    private final List<Lotto> purchasedLotto;

    public Bag() {
        purchasedLotto = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        purchasedLotto.add(lotto);
        numberOfLottoTickets++;
    }

    public List<Lotto> getPurchasedLotto() {
        validateNumberOfLottoTickets();
        return purchasedLotto;
    }
    public int getNumberOfLottoTickets() {
        validateNumberOfLottoTickets();
        return numberOfLottoTickets;
    }
    private void validateNumberOfLottoTickets() {
        if(numberOfLottoTickets !=purchasedLotto.size()) {
            throw new RuntimeException("[ERROR] 구매횟수와 저장된 로또 리스트의 크기가 상이합니다.");
        }
    }
}
