package mate.academy.spring.service.dto.mapping.impl.response;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.OrderResponseDto;

public class OrderResponseMapper {

    public OrderResponseDto toDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setOrderId(order.getId());
        orderResponseDto.setTicketIds(order.getTickets().stream().map(Ticket::getId).collect(
                Collectors.toList()));
        orderResponseDto.setOrderDate(LocalDateTime.now());
        orderResponseDto.setUserId(order.getUser().getId());
        return orderResponseDto;
    }
}
