package andreea.tema9;

import java.util.Random;

public class FestivalAttendeeThread extends Thread {

    private TicketType ticketType;
    private FestivalGate gate;

    enum TicketType {
        FULL, FULL_VIP, FREE_PASS, ONE_DAY, ONE_DAY_VIP
    }

    public FestivalAttendeeThread(FestivalGate gate) {
        this.gate = gate;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType() {
        int pick = new Random().nextInt(TicketType.values().length);
        this.ticketType = TicketType.values()[pick];
    }

    @Override

    public void run() {

        synchronized (this) {
            while (!gate.isAvailable()) {
                try {
                    wait(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
//            gate.setAvailable(false);
//            notify();

            for (int i = 0; ; i++) {
                setTicketType();
                synchronized (this) {
                    gate.getFestivalGate().add(this.ticketType);
                }
                try {
                    sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
