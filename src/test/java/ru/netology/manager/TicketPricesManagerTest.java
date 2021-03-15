package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketPrices;
import ru.netology.repository.TicketPricesRepository;
import ru.netology.domain.TicketByTimeAscComparator;

import static org.junit.jupiter.api.Assertions.*;

class TicketPricesManagerTest {

    private TicketPricesRepository repository = new TicketPricesRepository();
    private TicketByTimeAscComparator comparator = new TicketByTimeAscComparator();
    private TicketPricesManager manager = new TicketPricesManager(repository);
    private TicketPrices first = new TicketPrices(1, 15000, "AAK", "DAB", 240);
    private TicketPrices second = new TicketPrices(2, 20000, "AAK", "LAC", 120);
    private TicketPrices third = new TicketPrices(3, 10000, "AAK", "DAB", 180);
    private TicketPrices fourth = new TicketPrices(4, 11000, "VAR", "DAB", 400);
    private TicketPrices fifth = new TicketPrices(5, 30000, "VAR", "LAC", 200);
    private TicketPrices sixth = new TicketPrices(6, 15000, "AAK", "DAB", 210);

    @BeforeEach
    public void setUp(){
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
    }

    @Test
    void shouldSearchDepartureArrival(){
        TicketPrices[] actual = manager.search("AAK", "DAB", comparator);
        TicketPrices[] expected = new TicketPrices[]{third, sixth, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFound(){
        TicketPrices[] actual = manager.search("ABK", "DBB", comparator);
        TicketPrices[] expected = new TicketPrices[0];
        assertArrayEquals(expected, actual);
    }

}