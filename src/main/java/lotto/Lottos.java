package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private WinningLotto winningLotto;
    private List<Lotto> lottos;

    public Lottos(WinningLotto winningLotto, int price) {
        validate(price);
        this.winningLotto = winningLotto;
        this.lottos = new ArrayList<>();
        for (int i = 0; i < price / 1000; i++) {
            this.lottos.add(new Lotto(getSixRandomNumbers()));
        }
    }

    private void validate(int price) {
        if ((price % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 입력한 금액이 1000으로 나누어 떨어지지 않습니다.");
        }
    }

    private List<Integer> getSixRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private int getPrice() {
        return lottos.size() * 1000;
    }

    private List<Rank> getRanks() {
        return lottos.stream()
                .map(lotto -> winningLotto.getRank(lotto))
                .toList();
    }

    private double getEarningRate() {
        Result result = new Result(getRanks());
        int totalPrize = result.getTotalPrize();
        return Math.round((double) totalPrize / getPrice());
    }
}
