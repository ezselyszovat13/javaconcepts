package practice.designpatterns.memento;

public class EditorMain {
    public static void main(String[] args){
        History history = new History();
        Editor editor = new Editor(history);
        editor.createState("KACSA");
        System.out.println(editor.getContent());
        editor.createState("KACSA KUTYA");
        System.out.println(editor.getContent());
        editor.createState("KACSA KUTYA CICA");
        System.out.println(editor.getContent());
        System.out.println(editor.getHistory().getStates());
        editor.restorePrevious();
        System.out.println(editor.getContent());
        System.out.println(editor.getHistory().getStates());
        editor.restore(new EditorState("KACSA"));
        System.out.println(editor.getHistory().getStates());
        System.out.println(editor.getContent());
    }
}
