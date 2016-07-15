package net.zuobin.dao.primary;

import net.zuobin.entity.primary.Ticket;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Sahinn
 * @date 16/7/15
 *
 */
public interface TicketDao extends JpaRepository<Ticket,String> {

    @Query("from Ticket order by createTime asc")
    public List<Ticket> readWaitingArchiveData(Pageable pageable);

    @Query("from Ticket where userno = :merchantNo order by createTime asc")
    public List<Ticket> readWaitingDeleteData(Pageable pageable, @Param("merchantNo") String merchantNo);
}
