package streams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CountLongWords {

    public static void main(String[] args) throws IOException {
        var contents = Files.readString(Paths.get("gutenberg/alice30.txt"));
        List<String> words = List.of(contents.split("\\PL+"));

        long count = 0;
        for (String w : words) {
            System.out.println(w);
            if (w.length() > 12) count++;
        }
        System.out.println(count);

        count = words.stream().filter(w -> w.length() > 12).count();
        System.out.println(count);

        count = words.parallelStream().filter(w -> w.length() > 12).count();
        System.out.println(count);
    }
}
