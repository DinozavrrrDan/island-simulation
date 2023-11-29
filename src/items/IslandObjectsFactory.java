package items;

import annotations.Property;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import items.animal.herbivores.herbivoresMembers.*;
import items.animal.carnivores.carnivoresMembers.*;
import items.plant.plantsMembers.Grass;
import lombok.SneakyThrows;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IslandObjectsFactory {

    public static final String CURRENT_PATH = "items";
    public static final String PROPERTY_PATH = "src/models/animals.properties";
    private Map<Class, Object> islandObjectsMap = new HashMap<>();

    @SneakyThrows
    public void initIslandObjectsMap() {
        Properties properties = new Properties();
        try (FileReader reader = new FileReader(PROPERTY_PATH)) {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<Class<?>> allClassesFromMtPackage = findAllClassesUsingClassLoader(CURRENT_PATH);

        for (Class<?> aClass : allClassesFromMtPackage) {
            Annotation islandObjectAnnotation = aClass.getAnnotation(annotations.IslandObject.class);
            if (islandObjectAnnotation == null){
                continue;
            }
            String islandObjectName = ((annotations.IslandObject) islandObjectAnnotation).name();
            System.out.println(islandObjectName);

            Class<?> parentClass = aClass.getSuperclass();
            Class<?> animalClass = parentClass.getSuperclass();

            Field[] parentClassFields = animalClass.getDeclaredFields();

            List<String> propertiesValues = Arrays.stream(parentClassFields)
                    .filter(parentClassField -> parentClassField.isAnnotationPresent(Property.class))
                    .map(IslandObjectsFactory::getPropertyName)
                    .map(propertyName -> islandObjectName + '.' + propertyName)
                    .filter(el->el.startsWith(islandObjectName))
                    .sorted()
                    .toList();

            Constructor<?> constructor = aClass.getDeclaredConstructor(double.class, int.class, int.class, double.class, String.class);
            Double weight = Double.valueOf((String) properties.get(propertiesValues.get(4)));
            Integer maxOnSquare = Integer.valueOf((String) properties.get(propertiesValues.get(1)));
            Integer speed = Integer.valueOf((String) properties.get(propertiesValues.get(2)));
            Double enoughFoodForFullSaturation = Double.valueOf((String) properties.get(propertiesValues.get(0)));
            String unicode = String.valueOf(properties.get(propertiesValues.get(3)));
            islandObjectsMap.put(aClass, constructor.newInstance(weight, maxOnSquare, speed, enoughFoodForFullSaturation, unicode));
        }

    }

    private static String getPropertyName(Field parentClassField) {
        Annotation propertyAnnotation = parentClassField.getAnnotation(Property.class);
        String propertyName = ((Property) propertyAnnotation).propertyName();
        return propertyName;
    }

    public IslandObject createIslandObject(IslandObjectType islandObjectIslandObjectType) {
        return switch (islandObjectIslandObjectType) {
            case WOLF -> (Wolf) islandObjectsMap.get(Wolf.class);
            case BOA -> (Boa) islandObjectsMap.get(Boa.class);
            case BEAR -> (Bear) islandObjectsMap.get(Bear.class);
            case EAGLE -> (Eagle) islandObjectsMap.get(Eagle.class);
            case FOX -> (Fox) islandObjectsMap.get(Fox.class);
            case HOG -> (Hog) islandObjectsMap.get(Hog.class);

            case BUFFALO -> (Buffalo) islandObjectsMap.get(Buffalo.class);
            case CATERPILLAR -> (Caterpillar) islandObjectsMap.get(Caterpillar.class);
            case DEER -> (Deer) islandObjectsMap.get(Deer.class);
            case DUCK -> (Duck) islandObjectsMap.get(Duck.class);
            case GOAT -> (Goat) islandObjectsMap.get(Goat.class);
            case HORSE -> (Horse) islandObjectsMap.get(Horse.class);
            case MOUSE -> (Mouse) islandObjectsMap.get(Mouse.class);
            case RABBIT -> (Rabbit) islandObjectsMap.get(Rabbit.class);
            case SHEEP -> (Sheep) islandObjectsMap.get(Sheep.class);

            case GRASS -> new Grass();
        };
    }

    private Set<Class<?>> findAllClassesUsingClassLoader(String packageName) {
        var classReader = getPackageBufferedReader(packageName);
        var classes = classReader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toSet());

        var packageReader = getPackageBufferedReader(packageName);
        var packages = packageReader.lines()
                .filter(line -> !line.endsWith(".class"))
                .map(line -> findAllClassesUsingClassLoader(packageName + '.' + line))
                .collect(Collectors.toSet());

        var totalClasses = packages.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
        totalClasses.addAll(classes);
        return totalClasses;
    }

    private BufferedReader getPackageBufferedReader(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        return new BufferedReader(new InputStreamReader(stream));
    }

    private Class<?> getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {

        }
        return null;
    }
}