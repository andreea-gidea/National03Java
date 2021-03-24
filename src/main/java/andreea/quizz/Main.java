package andreea.quizz;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        String[] arguments = new String[] {};
        WritePackagesToCSV.main(arguments);

        String separator = File.separator;
        String urlToResources = "src" + separator + "main" + separator + "resources" + separator;
        File file = new File(urlToResources + "Packages.csv");

        PackageForDelivery.targetLocation brasov = PackageForDelivery.targetLocation.BRASOV;
        PackageForDelivery.targetLocation cluj = PackageForDelivery.targetLocation.CLUJ;
        PackageForDelivery.targetLocation sibiu = PackageForDelivery.targetLocation.SIBIU;

        LocalDate dateOfDelivery = LocalDate.of(2021, 04, 01);
        LocalDate dateOfDelivery2 = LocalDate.of(2021, 04, 02);

        List<PackageForDelivery> packagesToBVFirstApril = getCollectForCertainDestinationAndDate(file, brasov, dateOfDelivery);
        int packageForDeliveryInBVFirstAprilValue = calculateTotalDeliveryValue(packagesToBVFirstApril);
        int groupRevenueToBVFirstApril = getGroupRevenue(packagesToBVFirstApril);
        deliverPackages(packagesToBVFirstApril);


        List<PackageForDelivery> packagesToBVSecondApril = getCollectForCertainDestinationAndDate(file, brasov, dateOfDelivery2);
        int packageForDeliveryInBVSecondAprilValue = calculateTotalDeliveryValue(packagesToBVSecondApril);
        int groupRevenueToBVSecondApril = getGroupRevenue(packagesToBVSecondApril);
        deliverPackages(packagesToBVSecondApril);

        List<PackageForDelivery> packagesToCJFirstApril = getCollectForCertainDestinationAndDate(file, cluj, dateOfDelivery);
        int packageForDeliveryInCJFirstAprilValue = calculateTotalDeliveryValue(packagesToCJFirstApril);
        int groupRevenueForDeliveryInCJFirstApril = getGroupRevenue(packagesToCJFirstApril);
        deliverPackages(packagesToCJFirstApril);

        List<PackageForDelivery> packagesToSBFirstApril = getCollectForCertainDestinationAndDate(file, sibiu, dateOfDelivery);
        int packageForDeliveryInSBFirstAprilValue = calculateTotalDeliveryValue(packagesToCJFirstApril);
        int groupRevenueForDeliveryInSBFirstApril = getGroupRevenue(packagesToSBFirstApril);
        deliverPackages(packagesToSBFirstApril);


    }


    public static List<PackageForDelivery> getCollectForCertainDestinationAndDate(File file, PackageForDelivery.targetLocation destination, LocalDate dateOfDelivery) throws IOException {
        return Files.readAllLines(file.toPath())
                .stream()
                .skip(1)
                .filter(s -> StringUtils.isNotBlank(s))
                .map(Main::readPackageFromCSV)
                .filter(PackageForDelivery -> PackageForDelivery.getTargetLocation() == (destination))
                .filter(PackageForDelivery -> PackageForDelivery.getDeliveryDate().equals(dateOfDelivery))///inca nu e ok
                .collect(Collectors.toList());
    }


    public static PackageForDelivery readPackageFromCSV(String line) {
        String[] fields = line.split(",");
        return PackageForDelivery.builder()
                .targetLocation(PackageForDelivery.targetLocation.valueOf(fields[0].toUpperCase()))
                .packageValue(Integer.parseInt(fields[1].trim()))
                .deliveryDate(LocalDate.parse(fields[3]))
                .build();
    }

    private static int calculateTotalDeliveryValue(List<PackageForDelivery> totalPackagesToDeliver) {
        int totalSum = 0;
        for (PackageForDelivery p : totalPackagesToDeliver) {
            totalSum += p.getPackageValue();
        }
        System.out.println("This group's total value is  " + totalSum + "  LEI");
        return totalSum;
    }

    private static int getGroupRevenue(List<PackageForDelivery> totalPackagesToDeliver) {
        int groupRevenue = 0;
        for (PackageForDelivery p : totalPackagesToDeliver) {
            groupRevenue += p.getTargetLocation().getNumberOfKM();
        }
        System.out.println("This group's total revenue is  " + groupRevenue + "  LEI");
        return groupRevenue;
    }

    private static Runnable getRunnable() {
        return () -> {
        };
    }

    private static void deliverPackages(List<PackageForDelivery> listOfPackagesToDeliver) throws InterruptedException {
        long i = listOfPackagesToDeliver.get(0).getTargetLocation().getNumberOfKM();

        Runnable runnableClasaAnonima = getRunnable();
        Thread threadClasaAnonima = new Thread(runnableClasaAnonima);
        double beforeDelivery = System.currentTimeMillis();
        threadClasaAnonima.start();
        threadClasaAnonima.sleep(i*1000);
        int deliveryTotalTime = (int) (System.currentTimeMillis() - beforeDelivery)/1000;
        System.out.println("[Delivering for <"+ listOfPackagesToDeliver.get(0).getTargetLocation()+"> Date <"+ listOfPackagesToDeliver.get(0).getDeliveryDate()+"> in <"+deliveryTotalTime+"> seconds]");
    }
}
