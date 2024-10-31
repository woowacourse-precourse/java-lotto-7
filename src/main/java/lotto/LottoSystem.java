package lotto;

import static lotto.StringPool.INVALID_WINNING_NUMBERS_INPUT;
import static lotto.StringPool.MONEY_NOT_DIVIDED_BY_1000;
import static lotto.StringPool.PRINT_SOLD_LOTTO_COUNT;
import static lotto.StringPool.PRIZE_MATCH_RESULT_TEMPLATE;
import static lotto.StringPool.RATE_OF_RETURN;
import static lotto.StringPool.SEPARATION_LINE;
import static lotto.StringPool.WINNING_STATISTICS;

import camp.nextstep.edu.missionutils.Randoms;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class LottoSystem {
    private HashMap<Integer, LottoRank> ranks = new HashMap<>();
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private int issuedLottoCount;

    public LottoSystem() {
        int i = 3;
        for (LottoRank rank : LottoRank.values()) {
            ranks.put(i, rank);
            ++i;
        }
    }

    public List<Lotto> buyLotto(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(MONEY_NOT_DIVIDED_BY_1000);
        }
        issuedLottoCount = money / 1000;
        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < issuedLottoCount; ++i) {
            lottos.add(createAutoLotto());
        }
        return lottos;
    }

    public void printSoldLottos(List<Lotto> lottos) {
        System.out.printf((PRINT_SOLD_LOTTO_COUNT) + "%n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void setWinningNumbers(String input) {
        StringTokenizer strtok = new StringTokenizer(input, ",");
        ArrayList<Integer> winningNumbers = new ArrayList<>();
        while (strtok.hasMoreTokens()) {
            int luckyNumber = Integer.parseInt(strtok.nextToken());
            if (winningNumbers.contains(luckyNumber) || !isNumberInRange(luckyNumber)) {
                throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_INPUT);
            }
            winningNumbers.add(luckyNumber);
        }
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void processLottoResult(List<Lotto> lottos) {
        List<List<Integer>> eachLottos = lottos.stream().map(Lotto::getNumbers).toList();
        for (List<Integer> lottoPaper : eachLottos) {
            int count = (int) lottoPaper.stream().filter(this.winningNumbers::contains).count();
            if (count == 5 && !hasBonusNumber(lottoPaper)) {
                count = 7;
            }
            if (count >= 3) {
                LottoRank rank = ranks.get(count);
                rank.addWinningCount();
            }
        }
    }

    public void printWinningStatistics() {
        DecimalFormat formatter = new DecimalFormat("###,###");
        System.out.println(WINNING_STATISTICS);
        System.out.println(SEPARATION_LINE);
        for (LottoRank rank : LottoRank.values()) {
            System.out.printf(PRIZE_MATCH_RESULT_TEMPLATE + "%n", rank.getMatchCount(), formatter.format(rank.getPrize()), rank.getWinningCount());
        }
        System.out.printf(RATE_OF_RETURN, calculateReturnRate());
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    private double calculateReturnRate() {
        int totalReturn = 0;
        for (LottoRank rank : LottoRank.values()) {
            totalReturn += rank.getWinningCount() * rank.getPrize();
        }
        return Math.round(10 * (double) totalReturn / (issuedLottoCount * 1000) * 100);
    }
    private boolean hasBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(this.bonusNumber);
    }

    private boolean isNumberInRange(int num) {
        return num >= 1 && num <= 45;
    }

    private Lotto createAutoLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
