package steve.spring.jpa.springboot_jpa.model.pojo;

/**
 * @Author steve
 * @Date 2019/7/31
 * @Time 19:12
 * @Version 1.0
 */
public class TicketInCache {
    private TicketInfo ticketInfo;
    private Integer ticketSaveNum;
    private Integer ticketGetNum;

    public TicketInCache() {
    }

    public TicketInCache(TicketInfo ticketInfo, Integer ticketSaveNum, Integer ticketGetNum) {
        this.ticketInfo = ticketInfo;
        this.ticketSaveNum = ticketSaveNum;
        this.ticketGetNum = ticketGetNum;
    }

    public TicketInfo getTicketInfo() {
        return ticketInfo;
    }

    public void setTicketInfo(TicketInfo ticketInfo) {
        this.ticketInfo = ticketInfo;
    }

    public Integer getTicketSaveNum() {
        return ticketSaveNum;
    }

    public void setTicketSaveNum(Integer ticketSaveNum) {
        this.ticketSaveNum = ticketSaveNum;
    }

    public Integer getTicketGetNum() {
        return ticketGetNum;
    }

    public void setTicketGetNum(Integer ticketGetNum) {
        this.ticketGetNum = ticketGetNum;
    }

    @Override
    public String toString() {
        return "TicketInCache{" +
                "ticketInfo=" + ticketInfo +
                ", ticketSaveNum=" + ticketSaveNum +
                ", ticketGetNum=" + ticketGetNum +
                '}';
    }
}
