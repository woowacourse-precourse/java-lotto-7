package lotto.model;

import lotto.constants.Ranking;
import lotto.utils.WinningNumberValidation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoHandler {

    private List<Lottos> lottos = new ArrayList<>();
    private Lotto winningLottoNumbers;
    private int bonusNumber;

    public void buyLottos(int lottoTickets) {
        for (int num = 0; num < lottoTickets; num++) {
            Lottos lottoNumbers = Lottos.generateLottoNumbers();
            lottos.add(lottoNumbers);
        }
    }

    public String getLottoList() {
        return getLottos().stream()
                .map(lottos -> lottos.getLottoNumbers().toString())
                .collect(Collectors.joining("\n"));
    }

    public List<Lottos> getLottos() {
        return lottos;
    }

    public void inputWinningLottoNumbers(String rawWinningNumbers) {
        List<Integer> winningNumbers = Arrays.stream(rawWinningNumbers.split(","))
                .map(String::trim)
                .map(WinningNumberValidation::validateNumberFormat)
                .collect(Collectors.toList());

        WinningNumberValidation.validateNumberRange(winningNumbers);

        winningLottoNumbers = new Lotto(winningNumbers);
    }

    public void setBonusNumber(int rawBonusNumber) {
        this.bonusNumber = rawBonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLottoNumbers.getNumbers();
    }

    public void staticsResults(Customer customer) {
        customer.initializeRankingResults();

        for (Lottos lotto : lottos) {
            Ranking ranking = checkedResult(winningLottoNumbers, lotto);
            customer.updateLottoRanking(ranking);
        }
    }

    public Ranking checkedResult(Lotto winningLotto, Lottos buyLottos) {
        int rankedNumber = checkSameNumber(winningLotto.getNumbers(), buyLottos.getLottoNumbers());
        boolean checkedBonus = checkedBonusNumber(getBonusNumber(), buyLottos);
        Ranking ranking = Ranking.values()[rankedNumber];
        if (ranking == Ranking.FIVE && checkedBonus) {
            return Ranking.FIVE_BONUS;
        }
        return ranking;
    }

    private boolean checkedBonusNumber(int bonusNumber, Lottos buyLottos) {
        return buyLottos.getLottoNumbers().contains(bonusNumber);
    }

    private int checkSameNumber(List<Integer> winningLottoNumbers, List<Integer> buyLottoNumbers) {
        int count = 0;
        for (int num : buyLottoNumbers) {
            if (winningLottoNumbers.contains(num)) {
                count++;
            }
        }
        return count;
    }


}
