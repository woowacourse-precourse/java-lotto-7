package user;

import lotto.type.WinType;

import java.util.*;

public class User {

    private final Map<WinType, Integer> recordWin = new HashMap<>();

    public User() {
        for (WinType value : WinType.values()) {
            recordWin.put(value, 0);
        }
    }

    public Map<WinType, Integer> getRecordWin() {
        return recordWin;
    }

    public void updateRecordWin(WinType type) {
        int winCount = recordWin.get(type);
        recordWin.put(type, ++winCount);
    }

    public long getTotalLottoWinnings() {
        long totalLottoWinnings = 0;
        List<WinType> values = Arrays.stream(WinType.values())
                .sorted(Comparator.reverseOrder()).toList();
        for (WinType value : values) {
            Integer winCount = getRecordWin().get(value);
            totalLottoWinnings += value.getLottoWinnings() * winCount;
        }
        return totalLottoWinnings;
    }
}
