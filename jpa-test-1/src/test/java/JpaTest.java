import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static EntityTransaction transaction;

    @BeforeAll
    public static void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa-test");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
        transaction.begin();

    }


    @Test
    public void testPersistence() {

    }







    @AfterAll
    public static void destroy() {
        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

}
