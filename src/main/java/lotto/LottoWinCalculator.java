package lotto;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 로또의 당첨 결과를 계산하는 클래스입니다.
 */
public class LottoWinCalculator {
    private static final int CLASS_5_AMOUNT = 3;
    private static final int CLASS_4_AMOUNT = 4;
    private static final int CLASS_2_TO_3_AMOUNT = 5;
    private static final int CLASS_1_AMOUNT = 6;
    
    private List<Integer> winningNums;
    private int bonusNum;
    
    /**
     * 로또의 당첨 결과를 계산하는 클래스입니다.
     * @param winningNums 당첨 번호
     * @param bonus 보너스 당첨 번호
     */
    public LottoWinCalculator(List<Integer> winningNums, int bonus) {
        this.winningNums = winningNums;
        this.bonusNum = bonus;
    }

    /**
     * 입력받은 로또의 당첨결과를 계산해 반환합니다.
     * @param lotto 당첨결과를 확인할 로또
     * @return 당첨결과
     */
    public WinningType getWinningResult(Lotto lotto) {
        int count = 0;
        for (int n : winningNums) {
            if (lotto.hasNumber(n)) {
                count++;
            }
        }
        return getWinningType(count, lotto.hasNumber(bonusNum));
    }
    
    private WinningType getWinningType(int count, boolean gotBonus) {
        if (count == CLASS_5_AMOUNT) {
            return WinningType.CLASS_5;
        }
        if (count == CLASS_4_AMOUNT) {
            return WinningType.CLASS_4;
        }
        if (count == CLASS_2_TO_3_AMOUNT && !gotBonus) {
            return WinningType.CLASS_3;
        }
        if (count == CLASS_2_TO_3_AMOUNT && gotBonus) {
            return WinningType.CLASS_2;
        }
        if (count == CLASS_1_AMOUNT) {
            return WinningType.CLASS_1;
        } return WinningType.NONE;
    }
    
    /**
     * 입력받은 로또의 당첨결과를 모두 계산해 Map 형태의 통계결과를 반환합니다.
     * <br/>반환값은 {@link WinningType}의 순서대로 정렬된 각 당첨종류별 갯수입니다.
     * @param lottos 당첨결과를 확인할 로또 리스트
     * @return {@link WinningType}의 순서대로 정렬된 각 당첨종류별 갯수를 담은 Map
     */
    public Map<WinningType, Integer> getWinningStat(List<Lotto> lottos) {
        Map<WinningType, Integer> resultStat = new TreeMap<WinningType, Integer>();
        for (Lotto lotto : lottos) {
            WinningType type = getWinningResult(lotto);
            if (!resultStat.containsKey(type)) {
                resultStat.put(type, 0);
            }
            resultStat.put(type, resultStat.get(type) + 1);
        }
        return resultStat;
    }
}
