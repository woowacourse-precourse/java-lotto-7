package lotto.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.Set;
import java.util.Arrays;

import static lotto.constant.ErrorConstants.DUPLICATE_NOT_ALLOWED;
import static lotto.constant.UtilConstants.SEPARATOR;
import static lotto.constant.UtilConstants.ZERO;
import static lotto.constant.UtilConstants.MINIMUM_PRICE;

public class LottoRepository {
    private final List<Lotto> lottoTickets = new ArrayList<>();
    private List<Integer> lottoPlaceCount;
    private Lotto winningLotto;
    private HashSet<Integer> winningLottoComparable = new HashSet<>();
    private int bonusNumber;
    private int profit;

    public LottoRepository() {
        lottoPlaceCount = new ArrayList<>(Collections.nCopies(5, 0));
    }

    public void saveLotto(Lotto lotto) {
        lottoTickets.add(lotto);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public void increaseCount(int place) {
        if (place < ZERO) {
            return;
        }

        int currentCount = lottoPlaceCount.get(place);
        lottoPlaceCount.set(place, currentCount + 1);
    }

    public List<Integer> getLottoPlaceCount() {
        return Collections.unmodifiableList(lottoPlaceCount);
    }

    public Set<Integer> getWinningLotto() {
        return Collections.unmodifiableSet(winningLottoComparable);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void createWinningLotto(String input) {
        List<Integer> winningNumbers = parseInput(input);
        winningLotto = new Lotto(winningNumbers);
        winningLottoComparable = new HashSet<>(winningLotto.getNumbers());
    }

    public void setBonusNumber(String bonusNumber) {
        this.bonusNumber = Integer.parseInt(bonusNumber);
        checkIfBonusNumberIsDuplicate();
    }

    public void increaseProfit(int money) {
        profit += money;
    }

    public float getProfitRate() {
        float profitRate = (float) profit / (lottoTickets.size() * MINIMUM_PRICE) * 100.0f;
        return profitRate;
    }

    private void checkIfBonusNumberIsDuplicate(){
        if(winningLotto.getNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException(DUPLICATE_NOT_ALLOWED.getMessage());
        }
    }

    private List<Integer> parseInput(String input) {
        return Arrays.stream(input.split(SEPARATOR))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
