package lotto.config.io;

import lotto.config.io.writer.WriterConfig;
import lotto.io.OutputHandler;
import lotto.io.OutputParser;

public class OutputHandlerConfig {

    private final OutputHandler outputHandler;

    public OutputHandlerConfig(WriterConfig writerConfig) {
        this.outputHandler = new OutputHandler(writerConfig.getWriter(), new OutputParser());
    }

    public OutputHandler getOutputHandler() {
        return outputHandler;
    }
}
