package lotto;

import static lotto.StringPool.INVALID_WINNING_NUMBERS_INPUT;
import static lotto.StringPool.MONEY_NOT_DIVIDED_BY_1000;
import static lotto.StringPool.PRINT_SOLD_LOTTO_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class LottoSystem {
    private static LottoCustomer customer = new LottoCustomer();
    private ArrayList<LottoRank> rankPerCount = new ArrayList<>(Arrays.asList(LottoRank.values()));
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private int printLottoCount;


    public List<Lotto> buyLotto(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(MONEY_NOT_DIVIDED_BY_1000);
        }
        printLottoCount = money / 1000;
        customer.addBetMoney(money);
        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < printLottoCount; ++i) {
            lottos.add(createAutoLotto());
        }
        return lottos;
    }

    public void printSoldLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + PRINT_SOLD_LOTTO_COUNT);
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
                --count;
            }
            LottoRank rank = rankPerCount.get(count);
            rank.addCount();
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
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
