package ru.netology.manager;

import ru.netology.domain.TicketPrices;
import ru.netology.repository.TicketPricesRepository;

import java.util.Arrays;

public class TicketPricesManager {
    private TicketPricesRepository repository;

    public TicketPricesManager(TicketPricesRepository repository)  {
        this.repository = repository;
    }

    public TicketPrices[] search(String departure, String arrival) {
        TicketPrices[] offers = new TicketPrices[0];
        for (TicketPrices offer : repository.findAll()) {
            if (offer.matches(departure, arrival)) {
                TicketPrices[] tmp = new TicketPrices[offers.length + 1];
                System.arraycopy(offers, 0, tmp, 0, offers.length);
                tmp[tmp.length - 1] = offer;
                offers = tmp;
            }
        }
        Arrays.sort(offers);
        return offers;
    }
}
