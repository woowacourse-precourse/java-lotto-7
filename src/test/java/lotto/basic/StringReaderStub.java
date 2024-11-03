package lotto.basic;

public class StringReaderStub extends StringReader {
    private String testValue;

    public void setTestValue(String testValue) {
        this.testValue = testValue;
    }

    @Override
    public String readLine() {
        return testValue;
    }
}
