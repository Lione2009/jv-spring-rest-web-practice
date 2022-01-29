package mate.academy.spring.service.dto.mapping.impl.response;

import java.util.stream.Collectors;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;

public class ShoppingCartResponseMapper {
    public ShoppingCartResponseDto toDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto shoppingCartResponseDto = new ShoppingCartResponseDto();
        shoppingCartResponseDto.setUserId(shoppingCart.getId());
        shoppingCartResponseDto.setTicketIds(shoppingCart.getTickets().stream().map(
                Ticket::getId).collect(Collectors.toList()));
        return shoppingCartResponseDto;
    }
}
