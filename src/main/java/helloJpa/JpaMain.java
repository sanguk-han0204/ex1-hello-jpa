package helloJpa;

import helloJpa.entity.Member;
import helloJpa.entity.RoleType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
Member member1 = new Member();
member1.setUsername("A");

Member member2 = new Member();
member2.setUsername("B");

Member member3 = new Member();
member3.setUsername("C");

member1.setRoleType(RoleType.ADMIN);
            System.out.println("------------------ = ");
em.persist(member1);
em.persist(member2);
em.persist(member3);

            System.out.println("------------------ = ");
            tx.commit();

        }
        catch(Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
