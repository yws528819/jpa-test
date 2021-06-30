import com.yws.bean.Customer;
import com.yws.bean.Order;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    public void testManyToOnePersist() {
        Customer customer = new Customer();
        customer.setLastName("zhangsan");
        customer.setAge(18);
        customer.setEamil("123@163.com");
        customer.setBirth(new Date());
        customer.setCreatedTime(new Date());

        Set<Order> orders = new HashSet<>();
        Order order1 = new Order();
        order1.setOrderName("d1");
        order1.setCustomer(customer);
        Order order2 = new Order();
        order2.setOrderName("d2");
        order2.setCustomer(customer);
        orders.add(order1);
        orders.add(order2);

        customer.setOrders(orders);

        entityManager.persist(customer);
    }

    @Test
    public void testRemove() {
        Customer customer = entityManager.find(Customer.class,4);

        /**
         * orphanRemoval = true 时，如果cascade为CascadeType.ALL, 持久化对象的子集合，进行remove方法时，也会删除数据库里的记录
         * orphanRemoval = false时，如果cascade为CascadeType.ALL, 持久化对象的子集合，进行remove方法时，不会删除数据库里的记录
         */
//        Set<Order> orders = customer.getOrders();
//        orders.remove(orders.iterator().next());


        //如果cascade为CascadeType.ALL或者REMOVE，关联表jpa_order也会删除
        entityManager.remove(customer);
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
