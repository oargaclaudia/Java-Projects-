package org.example.domain;
import java.io.Serial;
import java.io.Serializable;

public class Entity<ID> implements Serializable {

    @Serial
    private static final long serialVersionUID = 4500794925126064682L;
    private ID id;
    public ID getId() {
        return id;
    }
    public void setId(ID id) {
        this.id = id;
    }
}