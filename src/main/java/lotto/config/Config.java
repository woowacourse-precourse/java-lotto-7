package lotto.config;

import lotto.io.reader.MissionUtilsReader;
import lotto.io.reader.Reader;
import lotto.io.writer.SystemWriter;
import lotto.io.writer.Writer;

public class Config {
    private final Reader reader;
    private final Writer writer;

    public Config() {
        this.reader = new MissionUtilsReader();
        this.writer = new SystemWriter();
    }

    public Reader getReader() {
        return reader;
    }

    public Writer getWriter() {
        return writer;
    }
}
