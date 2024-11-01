package lotto;

/**
 * 로또 당첨 종류을 표시합니다.
 */
public enum WinningType {
    NONE,
    CLASS_1,
    CLASS_2,
    CLASS_3,
    CLASS_4,
    CLASS_5;
    
    public static WinningType[] reversedValues() {
        WinningType[] values = values();
        for (int i = 0; i < values.length/2; i++) {
            WinningType temp = values[i];
            values[i] = values[values.length - 1 - i];
            values[values.length - 1 - i] = temp;
        }
        return values;
    }
}
