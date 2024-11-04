package lotto.domain.repository;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.WinResult;

public class WinResultHistory {

    private static final WinResultHistory INSTANCE = new WinResultHistory();

    private final List<WinResult> winResultHistory = new ArrayList<>();

    private WinResultHistory() {

    }

    public static WinResultHistory getInstance() {
        return INSTANCE;
    }

    public void add(WinResult winResult) {
        winResultHistory.add(winResult);
    }

    public WinResult getRecent() {
        return winResultHistory.getLast();
    }

    public void clear() {
        winResultHistory.clear();
    }
}
