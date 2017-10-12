package com.frank.chapter44.domain.s;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jianweilin on 2017/10/12.
 */
public interface MessageRepository extends JpaRepository<Message,Long> {
}
