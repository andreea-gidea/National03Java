package andreea.tema7;

import lombok.*;

import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.util.Objects;


@Builder
public class BiathlonAthlete implements Comparable<BiathlonAthlete> {

    private int athleteNumber;
    private String athleteName;
    private String countryCode;
    private LocalTime skiTimeResult;
    private LocalTime timeAdded ;
    @Size(min = 5, max = 5)
    private String firstShootingRange;
    @Size(min = 5, max = 5)
    private String secondShootingRange;
    @Size(min = 5, max = 5)
    private String thirdShootingRange;


    //
    public BiathlonAthlete(int athleteNumber, String athleteName, String countryCode, LocalTime skiTimeResult, @Size(min = 5, max = 5) String firstShootingRange, @Size(min = 5, max = 5) String secondShootingRange, @Size(min = 5, max = 5) String thirdShootingRange) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.firstShootingRange = firstShootingRange;
        this.secondShootingRange = secondShootingRange;
        this.thirdShootingRange = thirdShootingRange;
    }
    public BiathlonAthlete(int athleteNumber , String athleteName, String countryCode, LocalTime skiTimeResult,  LocalTime timeAdded, @Size(min = 5, max = 5) String firstShootingRange, @Size(min = 5, max = 5) String secondShootingRange, @Size(min = 5, max = 5) String thirdShootingRange) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.firstShootingRange = firstShootingRange;
        this.secondShootingRange = secondShootingRange;
        this.thirdShootingRange = thirdShootingRange;
        this.timeAdded = timeAdded;
    }


    public int getAthleteNumber() {
        return athleteNumber;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public LocalTime getSkiTimeResult() {
        return skiTimeResult;
    }

    public String getFirstShootingRange() {
        return firstShootingRange;
    }

    public String getSecondShootingRange() {
        return secondShootingRange;
    }

    public String getThirdShootingRange() {
        return thirdShootingRange;
    }

    public LocalTime getTimeAdded() { return timeAdded; }

    public void setAthleteNumber(int athleteNumber) {
        this.athleteNumber = athleteNumber;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setSkiTimeResult(LocalTime skiTimeResult) {
        this.skiTimeResult = skiTimeResult;
    }

    public void setFirstShootingRange(String firstShootingRange) {
        this.firstShootingRange = firstShootingRange;
    }

    public void setSecondShootingRange(String secondShootingRange) {
        this.secondShootingRange = secondShootingRange;
    }

    public void setThirdShootingRange(String thirdShootingRange) {
        this.thirdShootingRange = thirdShootingRange;
    }

    public void setTimeAdded(LocalTime timeAdded) { this.timeAdded = timeAdded; }



    @Override
    public String toString() {
        return "BiathlonAthlete{" +
                "athleteNumber=" + athleteNumber +
                ", athleteName='" + athleteName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", skiTimeResult=" + skiTimeResult +
                ", firstShootingRange='" + firstShootingRange + '\'' +
                ", secondShootingRange='" + secondShootingRange + '\'' +
                ", thirdShootingRange='" + thirdShootingRange + '\'' +
                '}';
    }

    @Override
    public int compareTo(BiathlonAthlete o1) {
        LocalTime totalTimeThis = (this.getSkiTimeResult()).plusSeconds(this.getTimeAdded().getSecond()).plusMinutes(this.getTimeAdded().getMinute());
        LocalTime totalTimeOther =(o1.getSkiTimeResult()).plusSeconds(o1.getTimeAdded().getSecond()).plusMinutes(o1.getTimeAdded().getMinute());
        if (totalTimeThis.isAfter(totalTimeOther)){

            return 1;
        }
        if (totalTimeThis.isBefore(totalTimeOther)){
            return -1;
        }

        return totalTimeThis.compareTo(totalTimeOther);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BiathlonAthlete athlete = (BiathlonAthlete) o;
        return athleteNumber == athlete.athleteNumber &&
                athleteName.equals(athlete.athleteName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(athleteNumber, athleteName);
    }
}


