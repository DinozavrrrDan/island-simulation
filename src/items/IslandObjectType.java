package items;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IslandObjectType {
    WOLF(""),
    BEAR(""),
    EAGLE(""),
    FOX(""),
    HOG(""),
    BUFFALO(""),
    CATERPILLAR(""),
    DEER("\uD83E\uDD8C"),
    DUCK(""),
    GOAT(""),
    HORSE(""),
    MOUSE(""),
    RABBIT(""),
    SHEEP(""),
    GRASS("");
    private final String unicodeSymbol;
}
