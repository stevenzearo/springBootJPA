package steve.spring.jpa.springboot_jpa.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author steve
 * @Date 2019/7/31
 * @Time 18:10
 * @Version 1.0
 */
@Entity
@Table(name = "queue_info")
public class TicketInfo {
    @Id
    @Column(name = "queue_no")
    private String ticketId;
    @Column(name = "busi_type")
    private String ticketType;
    @Column(name = "queue_time")
    private String ticketTime;
    @Column(name = "queue_status")
    private String ticketStatus;

    public TicketInfo() {
    }

    public TicketInfo(String ticketId, String ticketType, String ticketTime, String ticketStatus) {
        this.ticketId = ticketId;
        this.ticketType = ticketType;
        this.ticketTime = ticketTime;
        this.ticketStatus = ticketStatus;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getTicketTime() {
        return ticketTime;
    }

    public void setTicketTime(String ticketTime) {
        this.ticketTime = ticketTime;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    @Override
    public String toString() {
        return "TicketInfo{" +
                "ticketId='" + ticketId + '\'' +
                ", ticketType='" + ticketType + '\'' +
                ", ticketTime='" + ticketTime + '\'' +
                ", ticketStatus='" + ticketStatus + '\'' +
                '}';
    }
}
