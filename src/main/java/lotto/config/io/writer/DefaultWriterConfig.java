package lotto.config.io.writer;

import lotto.io.writer.SystemWriter;
import lotto.io.writer.Writer;

public class DefaultWriterConfig implements WriterConfig {

    private final Writer writer;

    public DefaultWriterConfig() {
        this.writer = new SystemWriter();
    }

    @Override
    public Writer getWriter() {
        return this.writer;
    }
}
