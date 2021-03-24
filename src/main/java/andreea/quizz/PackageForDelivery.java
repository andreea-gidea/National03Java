package andreea.quizz;

import lombok.Builder;

import java.time.LocalDate;

//@AllArgsConstructor
//@Getter
//@Setter
@Builder
public class PackageForDelivery implements Comparable<PackageForDelivery> {
    private int packageValue;
    private LocalDate deliveryDate;
    private targetLocation targetLocation;

    enum targetLocation {
        //        BRASOV(184),  am vrut sa fac din Bucuresti in tara, dar dureaza prea mult, sper ca e ok
//        TIMISOARA(540),
//        SIBIU(270 ),
//        CLUJ(444 ),
//        FAGARAS(248);
        BRASOV(10),
        TIMISOARA(15),
        SIBIU(7),
        CLUJ(9),
        FAGARAS(4);

        private final int numberOfKM;

        targetLocation(int i) {
            numberOfKM = i;
        }

        public int getNumberOfKM() {
            return numberOfKM;
        }
    }

    public PackageForDelivery(int packageValue, LocalDate deliveryDate, PackageForDelivery.targetLocation targetLocation) {
        this.packageValue = packageValue;
        this.deliveryDate = deliveryDate;
        this.targetLocation = targetLocation;
    }

    public int getPackageValue() {
        return packageValue;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public PackageForDelivery.targetLocation getTargetLocation() {
        return targetLocation;
    }

    public void setPackageValue(int packageValue) {
        this.packageValue = packageValue;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setTargetLocation(PackageForDelivery.targetLocation targetLocation) {
        this.targetLocation = targetLocation;
    }

    @Override
    public int compareTo(PackageForDelivery o) {

        if (this.getTargetLocation().toString().compareTo(o.getTargetLocation().toString()) >= 1) {
            return 1;
        }

        if (this.getTargetLocation().toString().compareTo(o.getTargetLocation().toString()) <= -1) {
            return -1;
        }

        return this.getDeliveryDate().compareTo(o.getDeliveryDate());
    }

    @Override
    public String toString() {
        return "PackageForDelivery{" +
                "packageValue=" + packageValue +
                ", deliveryDate=" + deliveryDate +
                ", targetLocation=" + targetLocation +
                '}';
    }
}
