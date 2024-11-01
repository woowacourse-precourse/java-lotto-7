package lotto.constants.collection;

import lotto.constants.Constants;
import lotto.constants.string.OutputMessage;

import java.util.ArrayList;
import java.util.List;

public enum ScoreSystemPrintForm implements Constants<List> {

    DEFAULT_PRINT(List.of(OutputMessage.THREE_MATCH.getInstance(),
            OutputMessage.FOUR_MATCH.getInstance(),
            OutputMessage.FIVE_MATCH.getInstance(),
            OutputMessage.FIVE_MATCH_AND_BONUS.getInstance(),
            OutputMessage.SIX_MATCH.getInstance()));

    private final List<String> scoreSystemPrintLogic;

    ScoreSystemPrintForm(List<String> scoreSystemPrintLogic) {
        this.scoreSystemPrintLogic = scoreSystemPrintLogic;
    }

    //방어적 복사
    @Override
    public List<String> getInstance() {
        return new ArrayList<>(scoreSystemPrintLogic);
    }
}
