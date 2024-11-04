package lotto.service.winning;

import java.util.List;
import lotto.Lotto;
import lotto.dto.PaperDto;
import lotto.dto.ResultDto;
import lotto.exception.winning.LottoNumberDuplicatedException;
import lotto.exception.winning.LottoNumberOutOfRangeException;
import lotto.rank.Rank;
import lotto.repository.winning.WinningRepository;

public class WinningServiceImpl implements WinningService {
    private final WinningRepository winningRepository;

    public WinningServiceImpl(WinningRepository winningRepository) {
        this.winningRepository = winningRepository;
    }

    @Override
    public void saveWinning(List<Integer> numbers) {
        Lotto winning = new Lotto(numbers);
        winningRepository.saveWinning(winning);
    }

    @Override
    public void saveBonusNumber(int bonusNumber) {
        Lotto winning = winningRepository.getWinning();
        List<Integer> numbers = winning.getLotto();

        if (numbers.contains(bonusNumber)) {
            throw new LottoNumberDuplicatedException();
        }
        if (isOutOfRange(bonusNumber)) {
            throw new LottoNumberOutOfRangeException();
        }
        winningRepository.saveBonusNumber(bonusNumber);
    }

    @Override
    public ResultDto getResult(List<PaperDto> papers) {
        List<Integer> winningNumbers = winningRepository.getWinningNumbers();
        int bonusNumber = winningRepository.getBonusNumber();
        double sum = 0;
        ResultDto result = new ResultDto();
        for (var paper : papers) {
            long matchCount = getMatchCount(paper, winningNumbers);
            boolean bonusMatch = paper.getLotto().contains(bonusNumber);

            var rank = Rank.valueOf(matchCount, bonusMatch);
            sum += rank.getPrize();
            result.addRank(rank);
        }
        result.setYield(sum / (papers.size() * 10));
        return result;
    }

    private long getMatchCount(PaperDto paper, List<Integer> winningNumbers) {
        return paper.getLotto().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean isOutOfRange(int number) {
        return number < 1 || number > 45;
    }
}
