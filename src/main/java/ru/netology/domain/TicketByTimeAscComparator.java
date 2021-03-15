package ru.netology.domain;

import java.util.Comparator;

public class TicketByTimeAscComparator implements Comparator<TicketPrices> {
    public int compare(TicketPrices o1, TicketPrices o2) {
        return o1.getTravelTime() - o2.getTravelTime();
    }
}
