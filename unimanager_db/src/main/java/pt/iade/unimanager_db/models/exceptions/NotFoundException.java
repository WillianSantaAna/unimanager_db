package pt.iade.unimanager_db.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 5508221855575397057L;

    public NotFoundException(String id, String elemType, String idName) {
        super(elemType + " with " + idName + " " + id + " not found.");
    }
}
