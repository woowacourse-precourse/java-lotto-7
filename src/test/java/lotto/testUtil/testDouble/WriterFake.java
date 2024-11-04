package lotto.testUtil.testDouble;

import java.util.ArrayList;
import java.util.List;
import lotto.io.writer.Writer;

public class WriterFake implements Writer {

    private final List<String> outputs = new ArrayList<>();

    @Override
    public void writeLine(String value) {
        outputs.add(value);
    }

    public List<String> getOutputs() {
        return outputs;
    }
}
