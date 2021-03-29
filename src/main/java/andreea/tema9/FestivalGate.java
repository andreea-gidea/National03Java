package andreea.tema9;

import java.util.ArrayDeque;
import java.util.Queue;

public class FestivalGate {

        private boolean available = true;

        private volatile Queue<FestivalAttendeeThread.TicketType> festivalGate = new ArrayDeque<>();

        public FestivalGate() {

        }

        public boolean isAvailable() {
                return available;
        }

        public void setAvailable(boolean available) {
                this.available = available;
        }

        public Queue<FestivalAttendeeThread.TicketType> getFestivalGate() {
                return festivalGate;
        }

}
