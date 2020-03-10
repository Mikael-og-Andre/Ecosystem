public class Main {
    public static void main(String[] args) {
        int steps = 100;
        int waitTime = 100;
        int foxes;
        int lemmings;
        int step;

        Simulator sim = new Simulator(100,100);
        CSVLogger log = new CSVLogger();
        log.addToString("Lemming");
        log.addToString("Fox");
        log.addToStringNewLine("Step");

        for (int i = 0; i < steps; i++) {
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sim.simulateOneStep();
            foxes = sim.getCount(Fox.class);
            lemmings = sim.getCount(Lemming.class);
            step = sim.getStep();
            log.addToString(""+lemmings);
            log.addToString(""+foxes);
            log.addToStringNewLine(""+step);
        }
        System.out.println(log.getBuilder().toString());
    }
}
