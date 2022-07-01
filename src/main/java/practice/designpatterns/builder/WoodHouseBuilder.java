package practice.designpatterns.builder;

public class WoodHouseBuilder implements HouseBuilder {
    private House house;

    public WoodHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void buildBasement() {
        house.setBasement("Wood bars");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Wood beams");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Wood dome");
    }

    @Override
    public void buildInterior() {
        house.setInterior("Wood carvings");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}
