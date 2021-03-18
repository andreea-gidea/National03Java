package andreea.tema7;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class PartII {
    public static void main(String[] args) throws IOException {
        String separator = File.separator;

        Path path = Paths.get("src" + separator + "main" + separator + "resources" + separator);
        Path path2 = Paths.get(path + "/Athletes.csv");
        Path path3 = Paths.get(path + "/File.txt");
        File file = new File(path + "/Athletes.csv");
        String textToAppend = "Text adus dupa";

        List<Path> collect = createListOfFileDirectoryName(path); //cerinta 1

        String endsWith = ".csv";
        findAllFilesThatEndWith(path, endsWith); //cerinta 2

        checkIfFileOrDirectoryExists(path2); //cerinta 3

        checkIfIsReadableAndWritable(path2); //cerinta4

        checkIfDirectoryOrFile(path);//cerinta5

        printLastModifiedDateHourMinute(file);//cerinta6

        findSizeOfFileInBytesKBMB(path2);//cerinta7

        List<String> something = storeTextInArrayList(path3);//cerinta8

        String[] arrayFromFiles = storeFileTextInArray(path3);//cerinta9

        readAndWriteFromFile(path3);//cerinta10

        appendTextToExistingFile(path3, textToAppend); //cerinta11

        readFirstThreeLines(path3);//cerinta12

        findTheLongestWord(path3);//cerinta13

        String wordToFind = "officia";
        System.out.println(finfWordInFile(path3, wordToFind));//cerinta14

    }

    private static List<Path> createListOfFileDirectoryName(Path path) {
        List<Path> collect = null;
        try {
            collect = Files.walk(path)
                    .skip(1)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(collect);
        return collect;
    }

    private static void findAllFilesThatEndWith(Path path, String endsWith) {
        try {
            Files.walk(path)
                    .filter(p -> !Files.isDirectory(p))
                    .map(p -> p.toString())
                    .filter(s -> s.endsWith(endsWith))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkIfFileOrDirectoryExists(Path path) {
        if (Files.exists(path)) {
            System.out.println(path + "  Does actually exist");
        } else {
            System.out.println("  Sorry," + path + "does not exist");
        }
    }

    private static void checkIfIsReadableAndWritable(Path p) {
        if (Files.isReadable(p) && Files.isWritable(p)) {
            System.out.println(p + " Is both readable and writable ");
        } else {
            System.out.println(p + " Is not readable and writable ");
        }
    }

    private static void checkIfDirectoryOrFile(Path p) {
        if (Files.isDirectory(p)) {
            System.out.println(p + " Is a directory ");
        } else if (Files.isRegularFile(p)) {
            System.out.println(p + " Is a file ");
        }
    }

    private static void printLastModifiedDateHourMinute(File f) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        System.out.println(simpleDateFormat.format(f.lastModified()));
    }

    private static void findSizeOfFileInBytesKBMB(Path p) {
        double d = 0;
        try {
            d = Files.size(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File size is  " + d + " bytes");
        System.out.println("              " + d / 1024 + " Kb");
        System.out.println("              " + d / 1024 / 1024 + " Mb");
    }

    private static List<String> storeTextInArrayList(Path p) {
        List<String> arrayListOfLinesInFile = new ArrayList<>();
        try {

            arrayListOfLinesInFile = Files.readAllLines(p)
                    .stream()
                    .filter(s -> StringUtils.isNotBlank(s))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arrayListOfLinesInFile;
    }

    private static String[] storeFileTextInArray(Path p) {
        List<String> something2 = storeTextInArrayList(p);
        String[] arrayOfLines = new String[something2.size()];

        for (int i = 0; i < something2.size(); i++) {
            arrayOfLines[i] = something2.get(i);
        }
        return arrayOfLines;
    }

    private static void readAndWriteFromFile(Path p) {
        try (InputStream in = new BufferedInputStream(new FileInputStream(p.toFile()));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(p + "File2.txt"))
        ) {
            int val;

            byte[] buffer = new byte[4000];

            while ((val = in.read(buffer)) != -1) {
                out.write(buffer, 0, val);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void appendTextToExistingFile(Path p, String textToAppend) throws IOException {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(String.valueOf(p), true), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        writer.newLine();
        writer.write(textToAppend);
        writer.flush();
        writer.close();
    }

    private static void readFirstThreeLines(Path path3) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path3)));
        String line;
        for (int i = 0; i < 3; i++) {

            if ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    private static void findTheLongestWord(Path p) throws IOException {
        List<String> linesCollected = Files.readAllLines(p)
                .stream()
                .map(s -> s = s.replaceAll(",", " "))
                .map(i -> i = i.trim())
                .collect(Collectors.toList());
        int maxLength = 0;
        String maxString = "0";
        for (String s : linesCollected) {
            String[] splited = s.split(" ");
            for (int i = 0; i < splited.length; i++) {

                if (maxLength < splited[i].length()) {
                    maxLength = splited[i].length();
                    maxString = splited[i];
                }
            }
        }
        System.out.println("Max length of word is  " + maxLength + " characters and the word is: " + maxString);
    }

    private static boolean finfWordInFile(Path p, String wordToFind) throws IOException {
        List<String> linesCollected = Files.readAllLines(p)
                .stream()
                .map(s -> s = s.replaceAll(",", " "))
                .map(i -> i = i.trim())
                .collect(Collectors.toList());
        for (String s : linesCollected) {
            String[] splited = s.split(" ");
            for (int i = 0; i < splited.length; i++) {
                if (wordToFind.equals(splited[i])) {
                    return true;
                }
            }
        }
        return false;
    }


}
