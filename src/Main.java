public class Main {
    public static void main(String[] args) {
        Simulator sim = new Simulator(100,100);
        while(true) {
            sim.simulateOneStep();
        }
    }
}
