package com.yws.bean;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity(name = "jpa_customer")
public class Customer {

    private Integer id;
    private String lastName;
    private String eamil;
    private int age;
    private Date createdTime;
    private Date birth;

    private Set<Order> orders;


    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEamil() {
        return eamil;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_time")
    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Temporal(TemporalType.DATE)
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     *  映射单向 1-n 的关联关系
     *  使用@OneToMany 来映射 1-n 关联关系
     *  使用 @JoinColumn 来映射外键列的名称
     *  可以使用 @OneToMany 的fetch属性来修改默认的加载策略
     *  可以使用 @OneToMany 的cascade属性来修改默认的删除策略
     *  注意：若在1的一端的 @OneToMany 中使用mappedBy属性，则@OneToMany端就不能再使用@JoinColumn属性了
     */
    /**
     * orphanRemoval = true 时，如果cascade为CascadeType.ALL, 持久化对象的子集合，进行remove方法时，也会删除数据库里的记录
     * orphanRemoval = false时，如果cascade为CascadeType.ALL, 持久化对象的子集合，进行remove方法时，不会删除数据库里的记录
     */
    //@JoinColumn(name = "customer_id")
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE}, mappedBy = "customer")
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", eamil='" + eamil + '\'' +
                ", age=" + age +
                ", createdTime=" + createdTime +
                ", birth=" + birth +
                '}';
    }
}
