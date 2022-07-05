package practice.designpatterns.prototype;

import lombok.Getter;

@Getter
public abstract class Shape implements Cloneable {
    private String id;
    protected String type;

    abstract void draw();

    public void setId(String id){
        this.id = id;
    }

    @Override
    protected Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
