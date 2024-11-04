package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;

public class LottoMachine implements DrawTool{

    private Long leftGames;

    public LottoMachine(Long gamesLeft) {
        this.leftGames = gamesLeft;
    }

    @Override
    public List<Integer> quickPicks() {
        leftGames--;
        return sortedNumbers();
    }

    private List<Integer> sortedNumbers() {
        return mixedEntry()
                .stream()
                .sorted()
                .toList();
    }

    private List<Integer> mixedEntry() {
        return pickUniqueNumbersInRange(
                GameStatus.START_NUMBER.getInt(),
                GameStatus.END_NUMBER.getInt(),
                GameStatus.TOTAL_BALL_COUNT.getInt());
    }

    @Override
    public Boolean gamesLeft() {
        return leftGames > GameStatus.LOWEST_GAME_COUNT.get();
    }
}
