package practice.designpatterns.memento;

import lombok.Getter;
import java.util.Stack;

@Getter
public class History {
    private final Stack<EditorState> states;

    public History() {
        states = new Stack<>();
    }

    public void push(EditorState editorState){
        states.add(editorState);
    }

    public EditorState pop(){
        return states.pop();
    }

    public boolean isHistoryContainsState(EditorState editorState){
        return states.contains(editorState);
    }

    public boolean isEmpty(){
        return states.size() == 0;
    }
}
