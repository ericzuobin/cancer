package net.zuobin.dao.secondary;

import net.zuobin.entity.primary.Ticket;
import net.zuobin.entity.secondary.ReadOnlyTicket;
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
public interface ReadOnlyTicketDao extends JpaRepository<ReadOnlyTicket,String> {

    @Query("from ReadOnlyTicket order by createTime asc")
    public List<ReadOnlyTicket> readWaitingArchiveData(Pageable pageable);

    @Query("from ReadOnlyTicket where userno = :merchantNo order by createTime asc")
    public List<ReadOnlyTicket> readWaitingDeleteData(Pageable pageable, @Param("merchantNo") String merchantNo);
}
