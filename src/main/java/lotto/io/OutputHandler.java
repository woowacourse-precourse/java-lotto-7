package lotto.io;

import lotto.dto.UserLotto;
import lotto.dto.WinningResult;
import lotto.io.writer.Writer;

public class OutputHandler {

    private final Writer writer;
    private final UserLottoParser userLottoParser;
    private final WinningResultParser winningResultParser;

    public OutputHandler(Writer writer,
                         UserLottoParser userLottoParser,
                         WinningResultParser winningResultParser) {
        this.writer = writer;
        this.userLottoParser = userLottoParser;
        this.winningResultParser = winningResultParser;
    }

    public void userLottoHandle(UserLotto userLotto) {
        String resultString = userLottoParser.parseUserLotto(userLotto);
        writer.write(resultString);
    }

    public void winningResultHandle(WinningResult winningResult) {
        String resultString = winningResultParser.parseWinningResult(winningResult);
        writer.write(resultString);
    }
}
