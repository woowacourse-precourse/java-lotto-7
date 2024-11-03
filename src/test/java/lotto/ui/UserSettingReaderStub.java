package lotto.ui;

public class UserSettingReaderStub extends UserSettingReader {
    private int testSeedMoney;
    private WinningNumberSettings testNumberSettings;

    public UserSettingReaderStub() {
        super(null, null);
    }

    public int readSeedMoney() {
        return testSeedMoney;
    }

    public WinningNumberSettings readWinningNumbers() {
        return testNumberSettings;
    }

    public void setTestSeedMoney(int testSeedMoney) {
        this.testSeedMoney = testSeedMoney;
    }

    public void setTestNumberSettings(WinningNumberSettings testNumberSettings) {
        this.testNumberSettings = testNumberSettings;
    }
}
