package items;

import annotations.Parent;
import annotations.Property;
import items.animal.carnivores.carnivoresMembers.*;
import items.animal.herbivores.herbivoresMembers.*;
import items.plant.plantsMembers.Grass;
import lombok.SneakyThrows;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class IslandObjectsFactory {

    public static final String CURRENT_PATH = "items";
    public static final String PROPERTY_PATH = "src/models/animals.properties";
    public static final String DOT = ".";
    private final Map<Class<?>, Object> islandObjectsMap = new HashMap<>();

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
            annotations.IslandObject islandObjectAnnotation = getIslandObject(aClass);
            if (islandObjectAnnotation == null) {
                continue;
            }

            Class<?> parentClass = getParentClass(aClass);

            var annotationParentClassFields = Arrays.stream(parentClass.getDeclaredFields())
                    .filter(parentClassField -> parentClassField.isAnnotationPresent(Property.class))
                    .toList();

            SortedMap<Integer, String> fieldsMap = new TreeMap<>();
            SortedMap<Integer, String> typesMap = new TreeMap<>();

            for (Field field : annotationParentClassFields) {
                fieldsMap.put(field.getAnnotation(Property.class).priority(), islandObjectAnnotation.name() + DOT + field.getAnnotation(Property.class).propertyName());
                typesMap.put(field.getAnnotation(Property.class).priority(), field.getAnnotation(Property.class).type());
            }
            Class<?>[] constructorArray = new Class[annotationParentClassFields.size()];

            for (int i = 0; i < fieldsMap.size(); i++) {
                String type = typesMap.get(i);
                Class<?> clazz = Class.forName("java.lang." + type);
                constructorArray[i] = clazz;
            }

            var constructor = aClass.getDeclaredConstructor(constructorArray);

            Double weight = Double.valueOf((String) properties.get(fieldsMap.get(0)));
            Integer maxOnSquare = Integer.valueOf((String) properties.get(fieldsMap.get(1)));
            Integer speed = Integer.valueOf((String) properties.get(fieldsMap.get(2)));
            Double enoughFoodForFullSaturation = Double.valueOf((String) properties.get(fieldsMap.get(3)));
            String unicode = String.valueOf(properties.get(fieldsMap.get(4)));

            islandObjectsMap.put(aClass, constructor.newInstance(weight, maxOnSquare, speed, enoughFoodForFullSaturation, unicode));
        }

    }

    private static annotations.IslandObject getIslandObject(Class<?> aClass) {
        return aClass.getAnnotation(annotations.IslandObject.class);
    }

    private static Class<?> getParentClass(Class<?> aClass) {
        Class<?> parentClass = aClass.getSuperclass();
        while (!parentClass.isAnnotationPresent(Parent.class)) {
            parentClass = parentClass.getSuperclass();
            if (parentClass == null) {
                throw new IllegalArgumentException();
            }
        }
        return parentClass;
    }

    public IslandObject createRandomIslandObject() {
        IslandObjectType[] islandObjectTypes = IslandObjectType.values();
        IslandObjectType islandObjectType = islandObjectTypes[ThreadLocalRandom.
                current().nextInt(islandObjectTypes.length)];
        return createIslandObject(islandObjectType);
    }


    public IslandObject createIslandObject(IslandObjectType islandObjectIslandObjectType) {
        return switch (islandObjectIslandObjectType) {
            case WOLF -> (Wolf) islandObjectsMap.get(islandObjectIslandObjectType.getAClass());
            case BOA -> (Boa) islandObjectsMap.get(islandObjectIslandObjectType.getAClass());
            case BEAR -> (Bear) islandObjectsMap.get(islandObjectIslandObjectType.getAClass());
            case EAGLE -> (Eagle) islandObjectsMap.get(islandObjectIslandObjectType.getAClass());
            case FOX -> (Fox) islandObjectsMap.get(islandObjectIslandObjectType.getAClass());
            case HOG -> (Hog) islandObjectsMap.get(islandObjectIslandObjectType.getAClass());

            case BUFFALO -> (Buffalo) islandObjectsMap.get(islandObjectIslandObjectType.getAClass());
            case CATERPILLAR -> (Caterpillar) islandObjectsMap.get(islandObjectIslandObjectType.getAClass());
            case DEER -> (Deer) islandObjectsMap.get(islandObjectIslandObjectType.getAClass());
            case DUCK -> (Duck) islandObjectsMap.get(islandObjectIslandObjectType.getAClass());
            case GOAT -> (Goat) islandObjectsMap.get(islandObjectIslandObjectType.getAClass());
            case HORSE -> (Horse) islandObjectsMap.get(islandObjectIslandObjectType.getAClass());
            case MOUSE -> (Mouse) islandObjectsMap.get(islandObjectIslandObjectType.getAClass());
            case RABBIT -> (Rabbit) islandObjectsMap.get(islandObjectIslandObjectType.getAClass());
            case SHEEP -> (Sheep) islandObjectsMap.get(islandObjectIslandObjectType.getAClass());

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
            return Class.forName(packageName + DOT
                    + className.substring(0, className.lastIndexOf(DOT)));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}