package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Seller {
    private final String PAY_PATTERN = "^[1-9][0-9]{3,}";

    public void validate(String input) {
        Pattern patternPay = Pattern.compile(PAY_PATTERN);
        Matcher matcherPay = patternPay.matcher(input);

        if (!matcherPay.matches()) {
            reject();
        }

        int money = Integer.parseInt(input);
        if (money % 1000 != 0) {
            reject();
        }
    }

    public List<Lotto> createLottoTickets(int money) {
        List<Lotto> lottos = new ArrayList<>();
        int howmany = money / 1000;

        for (int i = 0; i < howmany; i++) {
            setLottoTicket(lottos, new Lotto(getRandomNumber()));
        }

        return lottos;
    }

    public void setLottoTicket(List<Lotto> lottos, Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Integer> getRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void reject() {
        throw new IllegalArgumentException();
    }
}
