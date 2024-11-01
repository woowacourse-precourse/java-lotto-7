package lotto;

import static lotto.AppConstants.INSERT_MONEY;
import static lotto.AppConstants.INVALID_WINNING_NUMBERS_INPUT;
import static lotto.AppConstants.LOTTO_NUMBER_COUNT;
import static lotto.AppConstants.LOTTO_NUMBER_MAX;
import static lotto.AppConstants.LOTTO_NUMBER_MIN;
import static lotto.AppConstants.LOTTO_PRICE;
import static lotto.AppConstants.MATCH_COUNT_FOR_SECOND_PRIZE;
import static lotto.AppConstants.MATCH_COUNT_FOR_THIRD_PRIZE;
import static lotto.AppConstants.MONEY_LESS_THAN_1000;
import static lotto.AppConstants.MONEY_NOT_DIVIDED_BY_1000;
import static lotto.AppConstants.PRINT_SOLD_LOTTO_COUNT;
import static lotto.AppConstants.PRIZE_MATCH_RESULT_TEMPLATE;
import static lotto.AppConstants.RATE_OF_RETURN;
import static lotto.AppConstants.SEPARATION_LINE;
import static lotto.AppConstants.WINNING_STATISTICS;

import camp.nextstep.edu.missionutils.Randoms;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class LottoSystem {
    private static final int MIN_MATCH_COUNT = 3;

    private HashMap<Integer, LottoPrize> prizes = new HashMap<>();
    private HashSet<Integer> winningNumbers;
    private int bonusNumber;
    private int issuedLottoCount;

    public LottoSystem() {
        int matchCount = MIN_MATCH_COUNT;
        for (LottoPrize prize : LottoPrize.values()) {
            prizes.put(matchCount, prize);
            ++matchCount;
        }
    }

    public List<Lotto> buyLotto(int money) {
        issuedLottoCount = money / LOTTO_PRICE;
        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < issuedLottoCount; ++i) {
            lottos.add(createAutoLotto());
        }
        return lottos;
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        System.out.printf((PRINT_SOLD_LOTTO_COUNT) + "%n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void setWinningNumbers(HashSet<Integer> numbers) {

        this.winningNumbers = numbers;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void processLottoResult(List<Lotto> lottos) {
        List<List<Integer>> eachLottos = lottos.stream().map(Lotto::getNumbers).toList();
        for (List<Integer> lottoPaper : eachLottos) {
            int matchedCount = (int) lottoPaper.stream().filter(this.winningNumbers::contains).count();
            if (matchedCount == MATCH_COUNT_FOR_THIRD_PRIZE && !hasBonusNumber(lottoPaper)) {
                matchedCount = MATCH_COUNT_FOR_SECOND_PRIZE;
            }
            if (matchedCount >= MIN_MATCH_COUNT) {
                LottoPrize rank = prizes.get(matchedCount);
                rank.addWinningCount();
            }
        }
    }

    public void printWinningStatistics() {
        DecimalFormat formatter = new DecimalFormat("###,###");
        System.out.println(WINNING_STATISTICS);
        System.out.println(SEPARATION_LINE);
        for (LottoPrize rank : LottoPrize.values()) {
            System.out.printf(PRIZE_MATCH_RESULT_TEMPLATE + "%n", rank.getMatchCount(), formatter.format(rank.getPrize()), rank.getWinningCount());
        }
        System.out.printf(RATE_OF_RETURN, calculateReturnRate());
    }

    public HashSet<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    private double calculateReturnRate() {
        int totalReturn = 0;
        for (LottoPrize rank : LottoPrize.values()) {
            totalReturn += rank.getWinningCount() * rank.getPrize();
        }
        return Math.round((double) totalReturn / (issuedLottoCount * LOTTO_PRICE) * 100);
    }
    private boolean hasBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(this.bonusNumber);
    }

    private boolean isNumberInRange(int num) {
        return num >= LOTTO_NUMBER_MIN && num <= LOTTO_NUMBER_MAX;
    }

    private Lotto createAutoLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT));
    }
}
