package lotto.model;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoDispenser {
    
    private static final int LOTTO_PRICE = 1000;

    public LottoDispenser() {
    }

    public LottoCollection executeTransactionAndDispense(String inputMoney) {
        int NumberOfTickets = executeTransaction(inputMoney);
        return dispenseTicket(NumberOfTickets);
    }

    private int executeTransaction(String inputMoney) {
        validateInput(inputMoney);
        int money = parseMoney(inputMoney);
        validateMoney(money);
        int NumberOfTickets = money / LOTTO_PRICE;
        return NumberOfTickets; 
    }


    private void validateInput(String inputMoney) {
        if (inputMoney == null || inputMoney.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액이 입력되지 않았습니다.");
        }

        try {
            int money = Integer.parseInt(inputMoney);
            if (money <= 0) {
                throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 양수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자만 입력 가능합니다.");
        }
    }

    private int parseMoney(String inputMoney) {
        return Integer.parseInt(inputMoney);
    }

    private void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private LottoCollection dispenseTicket(int NumberOfTickets) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < NumberOfTickets; i++) {
            List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            randomNumbers.sort(null);
            Lotto ticket = new Lotto(randomNumbers);
            lottos.add(ticket);
        }
        return new LottoCollection(lottos);
    }
}
