package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TicketPrices implements Comparable<TicketPrices> {
    private int id;
    private int price;
    private String departure;
    private String arrival;
    private int travelTime;


    @Override
    public int compareTo(TicketPrices o) {
        return price - o.price;
    }

    public boolean matches(String departure, String arrival) {
        if (this.getDeparture().equalsIgnoreCase(departure) &&
                this.getArrival().equalsIgnoreCase(arrival)) {
            return true;
        } else return false;
    }
}
