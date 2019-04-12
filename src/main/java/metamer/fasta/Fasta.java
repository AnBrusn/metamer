package metamer.fasta;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.stream.Stream;
import metamer.utils.Paths;

public class Fasta {
    private final String SP = System.getProperty("line.separator");
    public static final String FASTA_EXTENSION = "fasta";
    public final Path filePath;

    public Fasta(Path filePath) {
        this.filePath = filePath;
    }

    public boolean isFileValid() {
        File file = filePath.toFile();
        return (file.exists() && file.isFile());
    }

    public Stream<Record> records() {
        try {
            if (!metamer.utils.Paths.extension(filePath).equals(FASTA_EXTENSION)) {
                throw new IOException("File is not fastA");
            }
            if (!isFileValid()) {
                throw new IOException("FastA file is invalid");
            }
            return Parser.parseString(Files.lines(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Stream.empty();
    }

    public void write(Collection<Record> records) throws IOException {
        if (!Paths.extension(filePath).equals(FASTA_EXTENSION)) {
            throw new IllegalArgumentException("Not a fasta extension!");
        }

        try {
            File file = new File(filePath.toString());
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            Stream<String> stream = new Parser().parseRecords(records.stream());
            stream.forEach((str) -> {
                try {
                    bufferedWriter.write(str + SP);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            bufferedWriter.close();
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
