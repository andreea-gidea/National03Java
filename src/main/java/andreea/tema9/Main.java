package andreea.tema9;

public class Main {

    public static void main(String[] args) {
        FestivalGate gate = new FestivalGate();
        FestivalAttendeeThread festivalAttendeeThread = new FestivalAttendeeThread(gate);
//        FestivalAttendeeThread festivalAttendeeThread1 = new FestivalAttendeeThread(gate);
//        FestivalAttendeeThread festivalAttendeeThread2 = new FestivalAttendeeThread(gate);
//        FestivalAttendeeThread festivalAttendeeThread3 = new FestivalAttendeeThread(gate);
//        FestivalAttendeeThread festivalAttendeeThread4 = new FestivalAttendeeThread(gate);
//        FestivalAttendeeThread festivalAttendeeThread5 = new FestivalAttendeeThread(gate);

        festivalAttendeeThread.start();
//        festivalAttendeeThread1.start();
//        festivalAttendeeThread2.start();
//        festivalAttendeeThread3.start();
//        festivalAttendeeThread4.start();
//        festivalAttendeeThread5.start();

        FestivalStatisticThread festivalStatisticThread = new FestivalStatisticThread(gate);
        festivalStatisticThread.start();

    }


}
