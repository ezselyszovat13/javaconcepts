package practice.designpatterns.isp;

public class BearCarer implements BearCleaner, BearFeeder{
    @Override
    public void washTheBear() {}

    @Override
    public void feedTheBear() {}
}
