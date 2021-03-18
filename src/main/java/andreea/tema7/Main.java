package andreea.tema7;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    static BufferedWriter writer;

    public static void main(String[] args) throws IOException {

        String separator = File.separator;
        String urlToResources = "src" + separator + "main" + separator + "resources" + separator;
        File file = new File(urlToResources + "Athletes.csv");

        writer = getWriterInstance();

        BiathlonAthlete athlete1 = new BiathlonAthlete(1, "Ana Maria", "RO", LocalTime.of(0, 8, 23), "xoooo", "oooox", "ooooo");
        BiathlonAthlete athlete2 = new BiathlonAthlete(2, "Raluca Postavaru", "RO", LocalTime.of(0, 10, 10), "xoxoo", "xxoox", "xxoox");
        BiathlonAthlete athlete3 = new BiathlonAthlete(3, "Elena Maritoi", "RO", LocalTime.of(0, 9, 15), "xxxxo", "xooox", "xxxoo");
        BiathlonAthlete athlete4 = new BiathlonAthlete(4, "Carmen Nova", "RO", LocalTime.of(0, 11, 01), "xxxxo", "xxoox", "xxxox");
        BiathlonAthlete athlete5 = new BiathlonAthlete(5, "Oana Bologa", "RO", LocalTime.of(0, 8, 46), "ooxxo", "xxxxx", "xxxox");
        BiathlonAthlete athlete6 = new BiathlonAthlete(6, "Casiana Helga", "RO", LocalTime.of(0, 8, 18), "xoxxo", "xxoox", "xxxox");
        BiathlonAthlete athlete7 = new BiathlonAthlete(7, "Andreea Andrei", "RO", LocalTime.of(0, 9, 5), "xoxxo", "xxooo", "xxxxx");

        List<BiathlonAthlete> athletes = new ArrayList<>();

        athletes.add(athlete1);
        athletes.add(athlete2);
        athletes.add(athlete3);
        athletes.add(athlete4);
        athletes.add(athlete5);
        athletes.add(athlete6);
        athletes.add(athlete7);

        writeHearer(writer);

        for (BiathlonAthlete athlete : athletes) {
            writeAthlete(writer, athlete);
        }
        writer.flush();

        List<BiathlonAthlete> athletesFromCVS = makeListFromCVS(file);
        printFirstRunner(athletesFromCVS);
    }

    static BufferedWriter getWriterInstance() throws IOException {

        if (writer != null) {
            return writer;
        }
        return new BufferedWriter(new FileWriter(new File("src/main/resources/Athletes.csv")));
    }

    private static void writeHearer(BufferedWriter writer) {
        try {
            getWriterInstance().write("athleteNumber,athleteName,countryCode,time,firstShootingRange,secondShootingRange,thirdShootingRange");
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Exception while writing header ");
        }
    }

    static void writeAthlete(BufferedWriter writer, BiathlonAthlete biathlonAthlete) {
        try {
            String line = biathlonAthlete.getAthleteNumber() + "," + biathlonAthlete.getAthleteName() + "," + biathlonAthlete.getCountryCode() + "," + biathlonAthlete.getSkiTimeResult() + "," + biathlonAthlete.getFirstShootingRange() + "," + biathlonAthlete.getSecondShootingRange() + "," + biathlonAthlete.getThirdShootingRange();
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Exception while writing athlete " + biathlonAthlete);
        }
    }

    static List<BiathlonAthlete> makeListFromCVS(File file) throws IOException {
        List<BiathlonAthlete> athletesFromCVS = Files.readAllLines(file.toPath())
                .stream()
                .skip(1) //skip header
                .filter(s -> StringUtils.isNotBlank(s))
                .map(Main::readAthleteFromCSV)
                .collect(Collectors.toList());
        return athletesFromCVS;
    }


    public static BiathlonAthlete readAthleteFromCSV(String line) {
        String[] fields = line.split(",");
        LocalTime l = LocalTime.of(0, 0, 0);
        return BiathlonAthlete.builder()
                .athleteNumber(Integer.parseInt(fields[0].trim()))
                .athleteName(fields[1])
                .countryCode(fields[2])
                .skiTimeResult(LocalTime.parse(fields[3]))
                .firstShootingRange(fields[4])
                .secondShootingRange(fields[5])
                .thirdShootingRange(fields[6])
                .timeAdded(l)
                .build();
    }

    public static void printFirstRunner(List<BiathlonAthlete> list) {
        sortListByTotalTime(list);
        System.out.println("Winner - " + (list.get(0).getAthleteName()) + "  "
                + ((list.get(0).getSkiTimeResult()).plusSeconds(list.get(0).getTimeAdded().getSecond()).plusMinutes(list.get(0).getTimeAdded().getMinute()))
                + " ("
                + (list.get(0).getSkiTimeResult())
                + " + "
                + (list.get(0).getTimeAdded()) + " )");
        System.out.println("Runner-up -" + (list.get(1).getAthleteName()) + "  "
                + ((list.get(1).getSkiTimeResult()).plusSeconds(list.get(1).getTimeAdded().getSecond()).plusMinutes(list.get(1).getTimeAdded().getMinute()))
                + " ("
                + (list.get(1).getSkiTimeResult())
                + " + "
                + (list.get(1).getTimeAdded()) + " )");
        System.out.println("Third Place -" + (list.get(2).getAthleteName()) + "  "
                + ((list.get(2).getSkiTimeResult()).plusSeconds(list.get(2).getTimeAdded().getSecond()).plusMinutes(list.get(2).getTimeAdded().getMinute()))
                + " ("
                + (list.get(2).getSkiTimeResult())
                + " + "
                + (list.get(2).getTimeAdded()) + " )");
    }

    static void sortListByTotalTime(List<BiathlonAthlete> list) {
        for (BiathlonAthlete b : list) {
            int misses = b.getFirstShootingRange().replaceAll("x", "").trim().length()
                    + b.getSecondShootingRange().replaceAll("x", "").trim().length()
                    + b.getThirdShootingRange().replaceAll("x", "").trim().length();
            b.setTimeAdded(b.getTimeAdded().plusSeconds(10 * misses));
        }
        Collections.sort(list);
    }

}