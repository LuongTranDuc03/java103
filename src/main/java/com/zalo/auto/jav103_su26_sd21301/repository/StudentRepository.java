package com.zalo.auto.jav103_su26_sd21301.repository;

import com.zalo.auto.jav103_su26_sd21301.entity.Student;
import com.zalo.auto.jav103_su26_sd21301.utils.EntityManagerUtils;
import jakarta.persistence.EntityManager;

import java.util.List;

public class StudentRepository {
    public static List<Student> getStudent() {
        try (EntityManager em = EntityManagerUtils.getEntityManager()) {
            return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public void addStudent(Student student) {
        try(EntityManager em = EntityManagerUtils.getEntityManager()) {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        }
    }

    public static Student getStudentById(Long id) {
        try (EntityManager em = EntityManagerUtils.getEntityManager()) {
            return em.find(Student.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateStudent(Student student) {
        try(EntityManager em = EntityManagerUtils.getEntityManager()) {
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        }
    }

    public void deleteStudent(Long id) {
        try(EntityManager em = EntityManagerUtils.getEntityManager()) {
            em.getTransaction().begin();
            Student student = em.find(Student.class, id);
            if (student != null) {
                em.remove(student);
            }
            em.getTransaction().commit();
        }
    }
}
