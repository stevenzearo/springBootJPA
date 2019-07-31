package steve.spring.jpa.springboot_jpa.model.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import steve.spring.jpa.springboot_jpa.model.pojo.TicketInfo;

import java.io.Serializable;

/**
 * @Author steve
 * @Date 2019/7/31
 * @Time 18:24
 * @Version 1.0
 */

@Repository
public interface TicketDao extends JpaRepository<TicketInfo, String>, JpaSpecificationExecutor<TicketInfo>, Serializable {
	Integer countByTicketStatus(String ticketStatus);
	Page<TicketInfo> findByTicketStatusOrderByTicketTimeAsc(String ticketStatus, Pageable pageable);

	@Query(value = "select queue_no, busi_type, queue_status, queue_time from queue_info where queue_status like ?1 order by queue_time limit 1", nativeQuery = true)
	TicketInfo findOldestTicketByTicketStatus(String status);
}
