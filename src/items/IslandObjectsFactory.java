package items;

import items.IslandObject;
import items.IslandObjectType;
import items.animal.herbivores.herbivoresMembers.*;
import items.animal.сarnivores.сarnivoresMembers.*;
import items.plant.plantsMembers.Grass;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class IslandObjectsFactory {

    public static final String CURRENT_PATH = "items";
    private Map<Class, Constructor<? extends IslandObjectType>> islandObjectsMap = new HashMap<>();

    public void initIslandObjectsMap() {
        Set<Class> allClassesFromMtPackage = findAllClassesUsingClassLoader(CURRENT_PATH);
        System.out.println();
    }

    public IslandObject createIslandObject(IslandObjectType islandObjectIslandObjectType) {
        return switch (islandObjectIslandObjectType) {
            case WOLF -> new Wolf();
            case BEAR -> new Bear();
            case EAGLE -> new Eagle();
            case FOX -> new Fox();
            case HOG -> new Hog();

            case BUFFALO -> new Buffalo();
            case CATERPILLAR -> new Caterpillar();
            case DEER -> new Deer();
            case DUCK -> new Duck();
            case GOAT -> new Goat();
            case HORSE -> new Horse();
            case MOUSE -> new Mouse();
            case RABBIT -> new Rabbit();
            case SHEEP -> new Sheep();

            case GRASS -> new Grass();
        };
    }

    private Set<Class> findAllClassesUsingClassLoader(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream( packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        var classes = reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toSet());
        return classes;
    }

    private Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {

        }
        return null;
    }
}
