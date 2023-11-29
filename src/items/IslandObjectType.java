package items;


public enum IslandObjectType {
    WOLF(""),
    BEAR(""),
    BOA(""),
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

    IslandObjectType(String unicodeSymbol) {
        this.unicodeSymbol = unicodeSymbol;
    }
}
