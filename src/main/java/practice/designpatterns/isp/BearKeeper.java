package practice.designpatterns.isp;

public interface BearKeeper {
    void washTheBear();
    void feedTheBear();
    //it shouldn't be the keeper's responsibility
    void petTheBear();
}
