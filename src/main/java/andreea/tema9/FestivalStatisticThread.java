package andreea.tema9;


public class FestivalStatisticThread extends Thread {

    private FestivalGate gate;

    public FestivalStatisticThread(FestivalGate gate) {
        this.gate = gate;
    }


    @Override

    public synchronized void run() {
//        while (gate.isAvailable()){
//            try {
//                wait(1);
//            } catch (InterruptedException e) {
//            }
//        }
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gate.setAvailable(false);
        notifyAll();

        calculateAndPrintAtendees();
        gate.setAvailable(true);
        notifyAll();
    }

    private void calculateAndPrintAtendees() {
        int nrOfFull = 0;
        int nrOfFullVIP = 0;
        int nrOFFree = 0;
        int nrOfOneDay = 0;
        int nrOfOneDayVIP = 0;

        for (int i = 0; i <= gate.getFestivalGate().size(); i++) {
            switch (String.valueOf((gate.getFestivalGate().poll())).toLowerCase()) {
                case "full":
                    nrOfFull += 1;
                    break;
                case "full_vip":
                    nrOfFullVIP += 1;
                    break;
                case "free_pass":
                    nrOFFree += 1;
                    break;
                case "one_day":
                    nrOfOneDay += 1;
                    break;
                case "one_day_vip":
                    nrOfOneDayVIP += 1;
                    break;
            }
        }

        int total = nrOfFull + nrOfFullVIP + nrOFFree + nrOfOneDay + nrOfOneDayVIP;
        System.out.println(total + "  people entered");
        System.out.println(nrOfFull + "  people have full tickets");
        System.out.println(nrOfFullVIP + "  people have full VIP tickets");
        System.out.println(nrOFFree + "  people have free passes");
        System.out.println(nrOfOneDay + "  people have one-day passes");
        System.out.println(nrOfOneDayVIP + "  people have one-day VIP passes");
    }
}

