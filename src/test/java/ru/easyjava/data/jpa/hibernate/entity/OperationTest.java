package ru.easyjava.data.jpa.hibernate.entity;

import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class OperationTest {
    private EntityManagerFactory entityManagerFactory;

    @Before
    public void testManager() throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("ru.easyjava.data.jpa.hibernate");
    }

    @Test
    public void testGreeter() {
        //New op
        Operation op = new Operation();

        op.setId(1L);
        op.setAccountId(100500);
        op.setAmount(BigDecimal.TEN);
        op.setTimestamp(ZonedDateTime.now());
        op.setDescription("Test operation");
        op.setOpCode(9000);

        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(op); // op is MANAGED now
        em.flush();

        op.setDescription("New operation name.");
        em.getTransaction().commit();
        em.close(); // op is DETACHED now

        em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        op = em.find(Operation.class, 1L);
        em.remove(op); // op is REMOVED now
        em.getTransaction().commit();
        em.close(); // op is DETACHED now
    }
}