package ru.netology.repository;

import ru.netology.domain.TicketPrices;

public class TicketPricesRepository {
    private TicketPrices[] offers = new TicketPrices[0];

    public void save(TicketPrices offer){
        int length = offers.length + 1;
        TicketPrices[] tmp = new TicketPrices[length];
        System.arraycopy(offers, 0, tmp, 0, offers.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = offer;
        offers = tmp;
    }

    public void removeById(int id) {
        int length = offers.length - 1;
        TicketPrices[] tmp = new TicketPrices[length];
        int index = 0;
        for (TicketPrices offer : offers) {
            if (offer.getId() != id) {
                tmp[index] = offer;
                index++;
            }
        }
        offers = tmp;
    }

    public TicketPrices[] findAll() {
        return offers;
    }

}
