package lotto.model;

import java.util.Collections;
import java.util.List;

public class DrawResults {

    private final List<DrawResult> drawResults;

    public DrawResults(List<DrawResult> drawResults) {
        this.drawResults = drawResults;
    }

    public List<DrawResult> getDrawResults() {
        return Collections.unmodifiableList(drawResults);
    }

}
