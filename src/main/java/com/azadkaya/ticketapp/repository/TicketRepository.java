package com.azadkaya.ticketapp.repository;

import com.azadkaya.ticketapp.model.Ticket;
import com.azadkaya.ticketapp.utils.TicketEnumStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findAllByUser_Username(String username);

    Optional<Ticket> findByIdAndUser_Username(Long ticketId, String username);


    @Query("SELECT t FROM Ticket t LEFT JOIN t.user user " +
            "WHERE t.status = :status"
    )
    Page<Ticket> findByStatus(@Param("status") TicketEnumStatus status, Pageable pageable);

}
