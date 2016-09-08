package ru.easyjava.data.jpa.hibernate.listeners;

import ru.easyjava.data.jpa.hibernate.entity.Operation;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

/**
 * JPA callback example
 */
public class OperationListener {
    @PrePersist
    public void prePersist(Operation o) {
        System.out.println("Pre-Persistiting operation: " + o.getDescription());
    }

    @PostPersist
    public void postPersist(Operation o) {
        System.out.println("Post-Persist operation: " + o.getDescription());
    }

    @PreRemove
    public void preRemove(Operation o) {
        System.out.println("Pre-Removing operation: " + o.getDescription());
    }

    @PostRemove
    public void postRemove(Operation o) {
        System.out.println("Post-Remove operation: " + o.getDescription());
    }

    @PreUpdate
    public void preUpdate(Operation o) {
        System.out.println("Pre-Updating operation: " + o.getDescription());
    }

    @PostUpdate
    public void postUpdate(Operation o) {
        System.out.println("Post-Update operation: " + o.getDescription());
    }
}
