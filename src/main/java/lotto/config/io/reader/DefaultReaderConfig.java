package lotto.config.io.reader;

import lotto.io.reader.MissionUtilsReader;
import lotto.io.reader.Reader;

public class DefaultReaderConfig implements ReaderConfig {

    private final Reader reader;

    public DefaultReaderConfig() {
        this.reader = new MissionUtilsReader();
    }

    @Override
    public Reader getReader() {
        return this.reader;
    }
}
