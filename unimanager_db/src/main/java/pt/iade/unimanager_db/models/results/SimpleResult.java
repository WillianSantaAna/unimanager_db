package pt.iade.unimanager_db.models.results;

public class SimpleResult {
    private String result;
    private Object object;

    public SimpleResult(String result, Object object) {
        this.result = result;
        this.object = object;
    }

    public String getResult() {
        return result;
    }

    public Object getObject() {
        return object;
    }
}
