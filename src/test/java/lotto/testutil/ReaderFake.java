package lotto.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.io.reader.Reader;

public class ReaderFake implements Reader {

    private final List<String> inputs = new ArrayList<>();
    private int inputCounter = 0;

    public void setInput(String... inputs) {
        this.inputs.addAll(Arrays.stream(inputs).toList());
    }

    @Override
    public String readLine() {
        return inputs.get(inputCounter++);
    }
}
