package lotto.domain;

import java.util.List;

public interface DrawTool {
    List<Integer> quickPicks();
    Boolean gamesLeft();
}
