package practice.designpatterns.state;

public class CanvasMain {
    public static void main(String[] args){
        Tool brushTool = new Brush();
        Tool selectionTool = new Selection();
        Canvas canvas = new Canvas();

        canvas.setCurrentTool(selectionTool);
        canvas.mouseDown();
        canvas.mouseUp();

        canvas.setCurrentTool(brushTool);
        canvas.mouseDown();
        canvas.mouseUp();
    }
}
