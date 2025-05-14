package com.azadkaya.ticketapp.mapper;

import com.azadkaya.ticketapp.dto.request.TicketRequestDto;
import com.azadkaya.ticketapp.dto.response.ResponseTicketDTO;
import com.azadkaya.ticketapp.dto.response.TicketResponseDto;
import com.azadkaya.ticketapp.model.Ticket;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketMapper {
    Ticket toEntity(TicketRequestDto dto);

    @Mapping(target = "adminResponse", source = "adminResponse")
    @Mapping(target = "username", source = "user.username")
    TicketResponseDto toDto(Ticket ticket);


    List<TicketResponseDto> toDto(List<Ticket> tickets);

    ResponseTicketDTO toAdminResponseDto(Ticket ticket);
}
