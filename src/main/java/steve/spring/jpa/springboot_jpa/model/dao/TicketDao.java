package steve.spring.jpa.springboot_jpa.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import steve.spring.jpa.springboot_jpa.model.pojo.TicketInfo;
import sun.security.krb5.internal.Ticket;

import java.io.Serializable;

/**
 * @Author steve
 * @Date 2019/7/31
 * @Time 18:24
 * @Version 1.0
 */

@Repository
public interface TicketDao extends JpaRepository<TicketInfo, String>, JpaSpecificationExecutor<TicketInfo>, Serializable {
}
