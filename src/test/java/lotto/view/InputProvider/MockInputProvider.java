package lotto.view.InputProvider;

import java.util.List;

public class MockInputProvider implements InputProvider {
    private final List<String> preDefinedInputs;
    private int index = 0;

    public MockInputProvider(List<String> preDefinedInputs) {
        this.preDefinedInputs = preDefinedInputs;
    }

    @Override
    public String readLine() {
        String value = preDefinedInputs.get(index);
        index = (index + 1) % preDefinedInputs.size();
        return value;
    }

    @Override
    public void close() {

    }
}