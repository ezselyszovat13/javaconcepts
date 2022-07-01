package practice.designpatterns.builder;

public class Builder {
    public static void main(String[] args){
        HouseBuilder iglooBuilder = new IglooHouseBuilder();
        CivilEngineer iglooEngineer = new CivilEngineer(iglooBuilder);
        iglooEngineer.constructHouse();
        System.out.println(iglooEngineer.getHouse());

        HouseBuilder woodHouseBuilder = new WoodHouseBuilder();
        CivilEngineer woodEngineer = new CivilEngineer(woodHouseBuilder);
        woodEngineer.constructHouse();
        System.out.println(woodEngineer.getHouse());
    }
}
