package com.bitaka.pfe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitaka.pfe.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
