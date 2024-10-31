package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.model.Lotto;

public class LottoService {
    private final int LOTTO_NUM_COUNT = 6;
    private final int LOTTO_PRICE = 1000;
    private final int LOTTO_NUM_START = 1;
    private final int LOTTO_NUM_END = 45;

    private List<Lotto> lottos = new ArrayList<>();
    private List<Integer> winNum = new ArrayList<>();
    private Integer bonusNum;

    public void buyLotto(int amount) {
        int lottoCount = amount/LOTTO_PRICE;
        for(int count = 0; count < lottoCount; count++) {
            createLottoNum();
        }
    }

    private void createLottoNum() {
        List<Integer> randomNumbers =
                Randoms.pickUniqueNumbersInRange(LOTTO_NUM_START, LOTTO_NUM_END, LOTTO_NUM_COUNT);
        List<Integer> numbers = new ArrayList<>(randomNumbers);
        numbers.sort(Comparator.naturalOrder());
        lottos.add(new Lotto(numbers));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void inputWinNum(List<Integer> winNum) {
        this.winNum = winNum;
    }

    public void inputBonusNum(Integer bonusNum) {
        this.bonusNum = bonusNum;
    }

    public void checkLottosWin() {
        for(Lotto lotto : lottos) {
            lotto.inputWin(winNum, bonusNum);
        }
    }

    public List<Integer> getLottosWin() {
        List<Integer> lottosWin = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        for(Lotto lotto : lottos) {
            if (lotto.getWin() == null) {
                continue;
            }
            int index = lotto.getWin().getIndex();
            lottosWin.set(index, lottosWin.get(index) + 1);
        }
        return lottosWin;
    }

    public Double getWinningsRate() {
        long totalWinnings = 0L;
        for (Lotto lotto : lottos) {
            if (lotto.getWin() == null) {
                continue;
            }
            totalWinnings += lotto.getWin().getWinnings();
        }

        double winningsRate = (double) totalWinnings / (lottos.size() * LOTTO_PRICE) * 100;
        return Math.round(winningsRate * 10) / 10.0;
    }
}
