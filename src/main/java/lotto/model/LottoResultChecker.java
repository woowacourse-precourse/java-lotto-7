package lotto.model;


import java.util.ArrayList;
import java.util.List;

public class LottoResultChecker {
    // 발급된 로또 리스트
    private List<Lotto> purchaseLottoList;
    // 입력한 당첨 로또
    private Lotto prizeLotto;


    public LottoResultChecker(List<Lotto> purchaseLottoList, List<Integer> prizeNumbers) {
        this.purchaseLottoList = purchaseLottoList;
        this.prizeLotto = new Lotto(prizeNumbers);
    }

    public List<Integer> getPrizeResult() {
        List<Integer> prizeCount = new ArrayList<>();
        for (int i = 0; i < purchaseLottoList.size(); i++) {
            prizeCount.add(i,getPrizeCount(purchaseLottoList.get(i),prizeLotto));
        }
        return prizeCount;
    }


    private Integer getPrizeCount(Lotto purchaseLotto, Lotto prizeLotto) {
        Integer prize = 0;
        for (int i = 0; i < 6; i++) {
            if (prizeLotto.getNumbers().contains(purchaseLotto.getNumbers().get(i))) {
                prize++;
            }
        }
        return prize;
    }

}
