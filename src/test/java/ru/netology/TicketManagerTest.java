package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketOffer;
import ru.netology.manager.TicketOfferManager;
import ru.netology.repository.TicketOfferRepository;



import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketManagerTest {
TicketOfferRepository repository = new TicketOfferRepository();
TicketOfferManager manager = new TicketOfferManager(repository);
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
    void shouldFindAllSameFromTo() {
    TicketOffer[] expected = new TicketOffer[] {fourth, second};
    TicketOffer[] actual = manager.getAll("VKO", "NUX");
    assertArrayEquals (expected, actual);
}
@Test
    void shouldFindOneSameFromTo() {
    TicketOffer[] expected = new TicketOffer[] {first};
    TicketOffer[] actual = manager.getAll("SVO", "LED");
    assertArrayEquals (expected, actual);
}
@Test
    void shouldFindIfNotExists() {
    TicketOffer[] expected = new TicketOffer[] {};
    TicketOffer[] actual = manager.getAll("SVO", "DME");
    assertArrayEquals (expected, actual);
}

}
