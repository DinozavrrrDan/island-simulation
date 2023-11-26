package island;

import items.IslandObject;
import items.IslandObjectType;
import items.animal.IslandObjectsFactory;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
public class IslandMap {
    private final IslandObjectsFactory islandObjectsFactory;
    private final int height;
    private final int width;
    private final Location[][] locations;

    public IslandMap(int height, int width) {
        this.islandObjectsFactory = new IslandObjectsFactory();
        this.height = height;
        this.width = width;
        this.locations = new Location[height][width];
        islandObjectsFactory.initIslandObjectsMap();
    }
    
    public void init(){
        for (int coordinateX = 0; coordinateX < width; coordinateX++) {
            for (int coordinateY = 0; coordinateY < height; coordinateY++) {
                locations[coordinateX][coordinateY] = new Location(coordinateX, coordinateY);
            }
        }
    }

    public void fill(int maxIslandObjectCount){
        for (int coordinateX = 0; coordinateX < width; coordinateX++) {
            for (int coordinateY = 0; coordinateY < height; coordinateY++) {
                for (int i = 0; i < maxIslandObjectCount; i++) {
                    IslandObject islandObject = getRandomIslandObject();

                    var islandObjectAsString = islandObject.getClass().getSimpleName();
                    var islandObjectCountOnLocation = locations[coordinateX][coordinateY]
                            .getIslandObjetsCount()
                            .getOrDefault(islandObjectAsString, 0);
                    if (islandObjectCountOnLocation >= islandObject.getMaxOnSquare()){
                        continue;
                    }
                    locations[coordinateX][coordinateY].addIslandObject(islandObject);

                }
            }
        }
    }

    private IslandObject getRandomIslandObject() {
        IslandObjectType[] islandObjectTypes = IslandObjectType.values();
        IslandObjectType islandObjectType = islandObjectTypes[ThreadLocalRandom.
                current().nextInt( islandObjectTypes.length)];
        return islandObjectsFactory.createIslandObject(islandObjectType);
    }
}
