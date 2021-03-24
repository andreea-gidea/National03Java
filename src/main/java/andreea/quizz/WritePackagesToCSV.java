package andreea.quizz;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class WritePackagesToCSV {
    static BufferedWriter writer;
    public static void main(String[] args) throws IOException {

        System.out.println("First writing in CSV");

        String separator = File.separator;
        String urlToResources = "src" + separator + "main" + separator + "resources" + separator;
        File file = new File(urlToResources + "Packages.csv");


        PackageForDelivery packageForDelivery1 = new PackageForDelivery(100, LocalDate.of(2021,04,01), PackageForDelivery.targetLocation.BRASOV);
        PackageForDelivery packageForDelivery2 = new PackageForDelivery(50,LocalDate.of(2021,04,03), PackageForDelivery.targetLocation.BRASOV);
        PackageForDelivery packageForDelivery3 = new PackageForDelivery(30,LocalDate.of(2021,04,02), PackageForDelivery.targetLocation.BRASOV);
        PackageForDelivery packageForDelivery4 = new PackageForDelivery(40,LocalDate.of(2021,04,02), PackageForDelivery.targetLocation.BRASOV);
        PackageForDelivery packageForDelivery5 = new PackageForDelivery(50,LocalDate.of(2021,04,01), PackageForDelivery.targetLocation.CLUJ);
        PackageForDelivery packageForDelivery6 = new PackageForDelivery(50,LocalDate.of(2021,04,01), PackageForDelivery.targetLocation.CLUJ);
        PackageForDelivery packageForDelivery7 = new PackageForDelivery(50,LocalDate.of(2021,04,02), PackageForDelivery.targetLocation.CLUJ);
        PackageForDelivery packageForDelivery8 = new PackageForDelivery(20,LocalDate.of(2021,04,01), PackageForDelivery.targetLocation.SIBIU);
        PackageForDelivery packageForDelivery9 = new PackageForDelivery(50,LocalDate.of(2021,04,01), PackageForDelivery.targetLocation.SIBIU);
        PackageForDelivery packageForDelivery10 = new PackageForDelivery(100,LocalDate.of(2021,04,02), PackageForDelivery.targetLocation.SIBIU);
        PackageForDelivery packageForDelivery11 = new PackageForDelivery(50,LocalDate.of(2021,04,01), PackageForDelivery.targetLocation.FAGARAS);
        PackageForDelivery packageForDelivery12 = new PackageForDelivery(150,LocalDate.of(2021,04,01), PackageForDelivery.targetLocation.FAGARAS);

        List<PackageForDelivery> packages = new ArrayList<>();

        packages.add(packageForDelivery1);
        packages.add(packageForDelivery2);
        packages.add(packageForDelivery3);
        packages.add(packageForDelivery4);
        packages.add(packageForDelivery5);
        packages.add(packageForDelivery6);
        packages.add(packageForDelivery7);
        packages.add(packageForDelivery8);
        packages.add(packageForDelivery9);
        packages.add(packageForDelivery10);
        packages.add(packageForDelivery11);
        packages.add(packageForDelivery12);



        writer = getWriterInstance();

        writeHearer(writer);

        for (PackageForDelivery p : packages) {
            writePackage(writer, p);
        }
        writer.flush();

    }


    static BufferedWriter getWriterInstance() throws IOException {

        if (writer != null) {
            return writer;
        }
        return new BufferedWriter(new FileWriter(new File("src/main/resources/Packages.csv")));
    }
    private static void writeHearer(BufferedWriter writer) {
        try {
            getWriterInstance().write("targetLocation,packageValue,targetLocationNrOfKM,deliveryDate");
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Exception while writing header ");
        }
    }
    static void writePackage(BufferedWriter writer, PackageForDelivery packageForDelivery) {
        try {
            String line = packageForDelivery.getTargetLocation() + "," + packageForDelivery.getPackageValue() + "," + packageForDelivery.getTargetLocation().getNumberOfKM() + "," + packageForDelivery.getDeliveryDate();
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Exception while writing athlete " + packageForDelivery);
        }
    }

}
