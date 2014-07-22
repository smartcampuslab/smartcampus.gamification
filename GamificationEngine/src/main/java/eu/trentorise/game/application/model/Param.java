package eu.trentorise.game.application.model;

/**
 *
 * @author Luca Piras
 */
public class Param {
    
    protected String name;
    protected Action action;
    
    protected CompositeParam compositeParam;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public CompositeParam getCompositeParam() {
        return compositeParam;
    }

    public void setCompositeParam(CompositeParam compositeParam) {
        this.compositeParam = compositeParam;
    }

    @Override
    public String toString() {
        return "Param{" + "name=" + name + ", action=" + action + ", compositeParam=" + compositeParam + '}';
    }
}