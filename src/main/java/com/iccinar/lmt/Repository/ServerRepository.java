package com.iccinar.lmt.Repository;

import com.iccinar.lmt.entity.Server;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author iccinar
 * @date 30.10.2017.
 */
public interface ServerRepository extends JpaRepository<Server, Long>{

    List<Server> findByLabId (Long labId);
}
