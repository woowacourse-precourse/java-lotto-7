package lotto.service;

import lotto.domain.Lotto;
import lotto.staticenum.WinningAmountEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

import static lotto.staticenum.LottoStatic.*;

/**
 * 출력해야 되는 부분
 * 1. 5등부터 1등까지 각각 몇개인지
 * 2. 총 당첨금액은 얼마인지
 * 3. 수익률은 얼마인지
 * README 기능
 * 4. 번호 비교 후 당첨 기능
 * 5. 수익률 계산 기능
 * 6. 당첨 내역 및 수익률 출력 기능
 */
public class LottoWinning {

    List<Integer> winningNumbers;
    List<Lotto> lottos;
    int bonusNumber;
    int winningAmount = 0;
    int winning1stCount = 0;
    int winning2ndCount = 0;
    int winning3rdCount = 0;
    int winning4thCount = 0;
    int winning5thCount = 0;

    public LottoWinning(List<Integer> winningNumbers, int bonusNumber, List<Lotto> lottos) {
        this.winningNumbers = winningNumbers;
        this.lottos = lottos;
        this.bonusNumber = bonusNumber;
    }

    public void start() {
        for (Lotto lotto : lottos) {
            int winningNumberCount = getWinningNumberCount(lotto); //당첨번호가 몇개인지 가져오기
            int ranking = getRanking(winningNumberCount, lotto); //해당 로또의 랭킹이 몇위인지 가져오기
            addWinningAmount(ranking); //로또의 등수에 따라 당첨금 추가
        }
        showWinningDetails();
    }

    //통계 출력
    private void showWinningDetails() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (%s원) - %d개\n", WinningAmountEnum.FIVE.getStringValue(), winning5thCount);
        System.out.printf("4개 일치 (%s원) - %d개\n", WinningAmountEnum.FOUR.getStringValue(), winning4thCount);
        System.out.printf("5개 일치 (%s원) - %d개\n", WinningAmountEnum.THREE.getStringValue(), winning3rdCount);
        System.out.printf("5개 일치, 보너스 볼 일치 (%s원) - %d개\n", WinningAmountEnum.TWO.getStringValue(), winning2ndCount);
        System.out.printf("6개 일치 (%s원) - %d개\n", WinningAmountEnum.ONE.getStringValue(), winning1stCount);
        System.out.print("총 수익률은 " + getYield() + "%입니다." );
    }

    private int getRanking(int winningCount, Lotto lotto) {
        if (winningCount == 3) return 5;
        if (winningCount == 4) return 4;
        if (winningCount == 5 && lotto.getLottoNumbers().contains(bonusNumber)) return 2;
        if (winningCount == 5) return 3;
        if (winningCount == 6) return 1;
        return -1;
    }

    private void addWinningAmount(int ranking) {
        if (ranking < 0) return;
        if (ranking == 5) addCountAndWinningAmount(WinningAmountEnum.FIVE);
        if (ranking == 4) addCountAndWinningAmount(WinningAmountEnum.FOUR);
        if (ranking == 3) addCountAndWinningAmount(WinningAmountEnum.THREE);
        if (ranking == 2) addCountAndWinningAmount(WinningAmountEnum.TWO);
        if (ranking == 1) addCountAndWinningAmount(WinningAmountEnum.ONE);
    }

    private void addCountAndWinningAmount(WinningAmountEnum rank) {
        winningAmount += rank.getValue();
        if (rank == WinningAmountEnum.FIVE) winning5thCount++;
        if (rank == WinningAmountEnum.FOUR) winning4thCount++;
        if (rank == WinningAmountEnum.THREE) winning3rdCount++;
        if (rank == WinningAmountEnum.TWO) winning2ndCount++;
        if (rank == WinningAmountEnum.ONE) winning1stCount++;
    }

     //5. 수익률 계산 기능
    public double getYield() {
        int money = lottos.size() * LOTTO_PRICE;
        double yield = (double) winningAmount / money;
        BigDecimal bigDecimal = new BigDecimal(yield * 100);
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        return Double.parseDouble(decimalFormat.format(bigDecimal));
    }

    private int getWinningNumberCount(Lotto lotto) {
        int winning = 0;
        List<Integer> lottoNumbers = lotto.getLottoNumbers();
        for (Integer lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                winning++;
            }
        }
        return winning;
    }

}
