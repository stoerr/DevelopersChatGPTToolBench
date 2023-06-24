package net.stoerr.chatgpt.devtoolbench;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class ReplaceActionIT extends AbstractActionIT {

    @Test
    public void testReplaceOperation() throws Exception {
        try {
            String content = Files.readString(Paths.get("src/test/resources/testdir/secondfile.md"), UTF_8);
            Files.writeString(Paths.get("src/test/resources/testdir/replace.txt"), content, UTF_8);
            checkResponse("/replace?path=replace.txt&searchString=duck&replacement=goose", "POST", null, 200, "replacedinfile.txt");
        } finally {
            Files.deleteIfExists(Paths.get("src/test/resources/testdir/replace.txt"));
        }
    }

}
