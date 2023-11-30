import services.ConfigReader;
import simulation.SimulationSettings;
import simulation.SimulationStarter;

public class Application {
    public static void main(String[] args) {
        SimulationSettings simulationSettings = new SimulationSettings();
        ConfigReader configReader = new ConfigReader();
        simulationSettings = configReader.readSimulationSettings();
        System.out.println(simulationSettings.getHeightMap());
        SimulationStarter simulationStarter = new SimulationStarter();
        simulationStarter.start();
    }
}