package todo.vo;

/**
 * TODO検索結果１行単位のValueObject
 *
 */
public class TodoValueObject {

    /** TODOのタイトル */
    private String title;

    /** 詳細なタスクの名前 */
    private String task;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
