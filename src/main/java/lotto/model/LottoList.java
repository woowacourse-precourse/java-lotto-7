package lotto.model;

import lotto.model.type.LottoRank;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoList {
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottoList;
    private Lotto winningLotto;
    private int bonusNum;
    public LottoList() {
        this.lottoList = new ArrayList<>();
    }
    // 당첨 번호와 보너스 번호를 설정하는 메서드
    public void setWinningNumber(Lotto winningLotto, int bonusNum) {
        validateBonusNumber(winningLotto, bonusNum);
        this.winningLotto = winningLotto;
        this.bonusNum = bonusNum;
    }
    // 발행 로또 추가 메서드
    public void add(Lotto lotto){
        lottoList.add(lotto);
    }
    private void validateBonusNumber(Lotto winningLotto, int bonusNum) {
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningLotto.checkBonus(bonusNum)) {  // checkBonus 메서드 사용
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
    public List<Lotto> getLottoList(){return new ArrayList<>(lottoList);}
    // 각 로또 당첨 등수 계산
    public Map<LottoRank, Integer> calculateWinningStat()
    {
        Map<LottoRank, Integer> statistics = new EnumMap<>(LottoRank.class);
        for(LottoRank rank : LottoRank.values()){
            statistics.put(rank, 0);
        }
        for(Lotto lotto : lottoList){
            LottoRank rank = calculateLottoRank(lotto);
            statistics.put(rank, statistics.get(rank) + 1);
        }
        return statistics;
    }
    // 단일 로또의 당첨 등수 계산
    private LottoRank calculateLottoRank(Lotto lotto) {
        int matchCount = lotto.countMatchNumbers(winningLotto);
        boolean hasBonusNumber = matchCount == 5 && lotto.checkBonus(bonusNum);

        if (matchCount == 6) return LottoRank.FIRST;
        if (matchCount == 5 && hasBonusNumber) return LottoRank.SECOND;
        if (matchCount == 5) return LottoRank.THIRD;
        if (matchCount == 4) return LottoRank.FOURTH;
        if (matchCount == 3) return LottoRank.FIFTH;
        return LottoRank.NONE;
    }
    // 총 당첨금액 계산
    private int calculateTotalPrize() {
        int totalPrize = 0;
        Map<LottoRank, Integer> statistics = calculateWinningStat();

        for (LottoRank rank : LottoRank.values()) {
            totalPrize += rank.getPrize() * statistics.get(rank);
        }

        return totalPrize;
    }
    // 수익률 계산 (소수점 둘째 자리에서 반올림)
    public double calculateProfitRate() {
        int totalPrize = calculateTotalPrize();
        int totalCost = lottoList.size() * LOTTO_PRICE;
        return Math.round((double) totalPrize / totalCost * 1000) / 10.0;
    }
}
