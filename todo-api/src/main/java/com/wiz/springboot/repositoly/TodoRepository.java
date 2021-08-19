package com.wiz.springboot.repositoly;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wiz.springboot.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
