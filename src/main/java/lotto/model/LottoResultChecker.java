package lotto.model;


import java.util.*;

public class LottoResultChecker {
    // 발급된 로또 리스트
    private List<Lotto> purchaseLottoList;
    // 입력한 당첨 로또
    private Lotto prizeLotto;

    private Integer bonusNumber;


    public LottoResultChecker(List<Lotto> purchaseLottoList, List<Integer> prizeNumbers, Integer bonusNumber) {
        this.purchaseLottoList = purchaseLottoList;
        this.prizeLotto = new Lotto(prizeNumbers);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getPrizeResult() {
        List<Integer> prizeCount = new ArrayList<>();
        for (int i = 0; i < purchaseLottoList.size(); i++) {
            prizeCount.add(i, getPrizeCount(purchaseLottoList.get(i), prizeLotto));
        }
        return prizeCount;
    }

    private List<Integer> getPrizeResults() {
        return getPrizeResult();
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

    public List<Boolean> getPrizeBonusNumberList() {
        List<Boolean> isPrizeBonus = new ArrayList<>();
        for (int i = 0; i < purchaseLottoList.size(); i++) {
            isPrizeBonus.add(i, getBonusPrize(purchaseLottoList.get(i)));
        }

        return isPrizeBonus;
    }

    private Boolean getBonusPrize(Lotto purchaseLotto) {
        if (purchaseLotto.getNumbers().contains(bonusNumber)) {
            return true;
        }
        return false;
    }




}
