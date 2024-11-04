package lotto.model;

import lotto.constants.Ranking;
import lotto.constants.lottoType.LottoType;
import lotto.constants.messageType.OutputMessageType;
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

    public String getAllLottos() {
        return getLottos().stream()
                .map(lottos -> lottos.getLottoNumbers().toString())
                .collect(Collectors.joining(OutputMessageType.NEW_LINE.getMessage()));
    }

    public void inputWinningLottoNumbers(String rawWinningNumbers) {
        List<Integer> winningNumbers = Arrays.stream(rawWinningNumbers.split(OutputMessageType.COMMA.getMessage()))
                .map(String::trim)
                .map(WinningNumberValidation::validateNumberFormat)
                .collect(Collectors.toList());

        WinningNumberValidation.validateNumberRange(winningNumbers);

        winningLottoNumbers = new Lotto(winningNumbers);
    }

    public void staticsResults(Customer customer) {
        customer.initializeRankingResults();

        for (Lottos lotto : lottos) {
            Ranking ranking = checkedResult(winningLottoNumbers, lotto);
            customer.updateLottoRanking(ranking);
        }
    }

    public Ranking checkedResult(Lotto winningLotto, Lottos boughtLottos) {
        int rankedNumber = checkedSameNumber(winningLotto.getNumbers(), boughtLottos.getLottoNumbers());
        boolean checkedBonus = checkedBonusNumber(getBonusNumber(), boughtLottos);
        Ranking ranking = Ranking.values()[rankedNumber];
        if (ranking == Ranking.FIVE && checkedBonus) {
            return Ranking.FIVE_BONUS;
        }
        return ranking;
    }

    private boolean checkedBonusNumber(int bonusNumber, Lottos boughtLottos) {
        return boughtLottos.getLottoNumbers().contains(bonusNumber);
    }

    private int checkedSameNumber(List<Integer> winningLottoNumbers, List<Integer> boughtLottoNumbers) {
        int count = LottoType.LOTTO_INIT_RANK.getValue();
        for (int num : boughtLottoNumbers) {
            if (winningLottoNumbers.contains(num)) {
                count++;
            }
        }
        return count;
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

    public List<Lottos> getLottos() {
        return lottos;
    }

}
