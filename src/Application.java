import services.ConfigReader;
import simulation.SimulationSettings;
import simulation.SimulationStarter;

public class Application {
    public static void main(String[] args) {
        SimulationStarter simulationStarter = new SimulationStarter();
        simulationStarter.start();
    }
}