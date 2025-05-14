package com.azadkaya.ticketapp.dto.request;

import com.azadkaya.ticketapp.utils.TicketEnumStatus;
import lombok.Data;

@Data
public class TicketUpdateRequestDto {
    private TicketEnumStatus status;
    private String adminResponse;
}
