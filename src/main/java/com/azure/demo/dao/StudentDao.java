package com.azure.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azure.demo.model.Student;
@Repository
public interface StudentDao extends JpaRepository<Student,Integer>
{



}
