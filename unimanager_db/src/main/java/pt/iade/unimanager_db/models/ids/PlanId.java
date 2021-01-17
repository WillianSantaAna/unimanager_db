package pt.iade.unimanager_db.models.ids;

import java.io.Serializable;

public class PlanId implements Serializable{
    private static final long serialVersionUID = 3103463164387407729L;
    private int unitId;
    private int courseId;

    public PlanId() {
    }

    public PlanId(int unitId, int courseId) {
        this.unitId = unitId;
        this.courseId = courseId;
    }

    public int getUnitId() {
        return unitId;
    }

    public int getCourseId() {
        return courseId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + courseId;
        result = prime * result + unitId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PlanId other = (PlanId) obj;
        if (courseId != other.courseId)
            return false;
        if (unitId != other.unitId)
            return false;
        return true;
    }
}
