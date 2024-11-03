package lotto.models;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.utils.MessageFormatter.formatErrorMessage;
import static lotto.utils.Constants.*;
import static lotto.utils.ErrorMessages.*;


public class LottoIssuer {
    private final int amount;
    private final int count;
    private final List<List<Integer>> IssuedLotto;

    public LottoIssuer(int amount) {
        validate(amount);
        this.amount = amount;
        this.count = amount / LOTTO_PRICE;
        this.IssuedLotto = IssueAllLotto();
    }

    private void validate(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(formatErrorMessage(AMOUNT_SHOULD, BE_POSITIVE));
        }
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(formatErrorMessage(MINIMUM_AMOUNT, LOTTO_PRICE));
        }
    }

    private List<Integer> pickRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_LOWER_BOUND, LOTTO_UPPER_BOUND, LOTTO_SIZE);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sortableList = new ArrayList<>(numbers);
        Collections.sort(sortableList);
        return sortableList;
    }


    private List<List<Integer>> IssueAllLotto () {
        List<List<Integer>> allLotto = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> singleLotto = sortNumbers(pickRandomLottoNumbers());
            allLotto.add(singleLotto);
        }
        return allLotto;
    }

    public int getAmount() {
        return amount;
    }

    public int getCount() {
        return count;
    }

    public List<List<Integer>> getAllIssuedLotto() {
        return IssuedLotto;
    }

}
