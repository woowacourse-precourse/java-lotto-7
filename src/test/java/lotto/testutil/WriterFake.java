package lotto.testutil;

import java.util.ArrayList;
import java.util.List;
import lotto.io.writer.Writer;

public class WriterFake implements Writer {

    private final List<String> outputs = new ArrayList<>();

    public List<String> getOutputs() {
        return outputs;
    }

    @Override
    public void write(String value) {
        outputs.add(value);
    }
}
