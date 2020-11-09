package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketByFlightDurationAsComparator;
import ru.netology.domain.TicketOffer;
import ru.netology.manager.TicketOfferManager;
import ru.netology.repository.TicketOfferRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketManagerTest {
TicketOfferRepository repository = new TicketOfferRepository();
TicketOfferManager manager = new TicketOfferManager(repository);
TicketByFlightDurationAsComparator comparator = new TicketByFlightDurationAsComparator();
TicketOffer first = new TicketOffer(1, 5000, "SVO", "LED", 55);
TicketOffer second = new TicketOffer(2, 40000, "VKO", "NUX", 180);
TicketOffer third = new TicketOffer(3, 53000, "SVO", "JFK", 660);
TicketOffer fourth = new TicketOffer(4, 24000, "VKO", "NUX", 180);
TicketOffer fifth = new TicketOffer(5, 16000, "DME", "KZN", 90);

@BeforeEach
    public void setUp() {
    repository.save (first);
    repository.save (second);
    repository.save (third);
    repository.save (fourth);
    repository.save (fifth);


}
@Test
    void shouldFindAllSameFromToAndDuration() {
    TicketOffer[] expected = new TicketOffer[] {second, fourth};
    TicketOffer[] actual = manager.findAll("VKO", "NUX", comparator);
    assertArrayEquals (expected, actual);
}
@Test
    void shouldFindOne() {
    TicketOffer[] expected = new TicketOffer[] {first};
    TicketOffer[] actual = manager.findAll("SVO", "LED", comparator);
    assertArrayEquals (expected, actual);
}
@Test
    void shouldFindIfNotExists() {
    TicketOffer[] expected = new TicketOffer[] {};
    TicketOffer[] actual = manager.findAll("SVO", "DME", comparator);
    assertArrayEquals (expected, actual);
}
    @Test
    void shouldFindFlightDuration() {
        TicketOffer[] expected = new TicketOffer[]{third};
        TicketOffer[] actual = manager.findAll("SVO", "JFK", comparator);
        assertArrayEquals(expected, actual);
    }

}
