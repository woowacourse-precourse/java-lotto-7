package lotto.constants.collection;

import lotto.constants.Constants;

import java.util.ArrayList;
import java.util.List;

public enum ScoreSystemPrintForm implements Constants<List<String>> {

    DEFAULT(List.of("3개 일치 (5,000원) - %d개",
            "4개 일치 (50,000원) - %d개",
            "5개 일치 (1,500,000원) - %d개",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개",
            "6개 일치 (2,000,000,000원) - %d개"));

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
