package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final List<Lotto> tickets = new ArrayList<>();
    private Lotto winningNumber;
    private int bonusNumber;

    public void purchaseTicket(int amount) {
        validate(amount);
        int count = amount / 1000;
        for (int i = 0; i < count; i++) {
            // 로또 생성 메소드
            // tickets.add();
        }
    }

    private void validate(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력 해야 합니다.");
        }
    }

    public void setWinningNumber(List<Integer> number) {
        winningNumber = new Lotto(number);
    }

    public void setBonusNumber(int number) {
        this.bonusNumber = number;
    }
}
