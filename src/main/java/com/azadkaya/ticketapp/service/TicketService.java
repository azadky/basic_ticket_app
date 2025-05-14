package com.azadkaya.ticketapp.service;

import com.azadkaya.ticketapp.dto.request.TicketRequestDto;
import com.azadkaya.ticketapp.dto.request.TicketUpdateRequestDto;
import com.azadkaya.ticketapp.dto.response.TicketResponseDto;
import com.azadkaya.ticketapp.utils.TicketEnumStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TicketService {

    TicketResponseDto createTicket(TicketRequestDto dto);

    List<TicketResponseDto> getCurrentUserTickets(String username);

    TicketResponseDto getTicketByIdForCurrentUser(Long ticketId, String username);

    TicketResponseDto closeTicket(Long ticketId, String username);

    Page<TicketResponseDto> getTicketsByStatus(TicketEnumStatus status, Pageable pageable);

    Page<TicketResponseDto> getAllTickets(Pageable pageable);

    TicketResponseDto updateTicket(Long id, TicketUpdateRequestDto dto);

    TicketResponseDto getTicketForAdmin(Long id);
}
