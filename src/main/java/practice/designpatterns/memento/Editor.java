package practice.designpatterns.memento;

import lombok.Getter;

@Getter
public class Editor {
    private String content;
    private History history;

    public Editor(History history) {
        this.history = history;
    }

    public void createState(String content){
        if(this.content != null){
            history.push(new EditorState(this.content));
        }
        this.content = content;
    }

    public void restore(EditorState editorState){
        if(isHistoryNotContainsState(editorState)){
            throw new RuntimeException("The state were not found!");
        }
        boolean isEditorStateFound = false;
        while(!history.isEmpty() && !isEditorStateFound){
            EditorState foundState = history.pop();
            isEditorStateFound = foundState.equals(editorState);
        }
        this.content = editorState.getContent();
    }

    public void restorePrevious(){
        if(history.isEmpty()){
            throw new RuntimeException("There is no history yet!");
        }
        this.content = history.pop().getContent();

    }

    private boolean isHistoryNotContainsState(EditorState editorState){
        return !history.isHistoryContainsState(editorState);
    }
}
