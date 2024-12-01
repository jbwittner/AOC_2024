package fr.jbwittner.aoc2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class FileHelper {

    private String resourcePath;

    // Constructeur pour initialiser le chemin du fichier dans le classpath
    public FileHelper(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    /**
     * Charge les lignes d'un fichier depuis le classpath et retourne un Stream<String>.
     *
     * @return Stream<String> - Stream des lignes du fichier
     * @throws IOException si le fichier ne peut pas être lu
     */
    public Stream<String> loadLinesFromClasspath() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath);

        if (inputStream == null) {
            throw new IOException("Le fichier '" + resourcePath + "' n'existe pas dans le classpath.");
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return reader.lines();
    }

}
