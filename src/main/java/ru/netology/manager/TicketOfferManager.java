package ru.netology.manager;

import ru.netology.domain.TicketOffer;
import ru.netology.repository.TicketOfferRepository;

import java.util.Arrays;
import java.util.Comparator;

public class TicketOfferManager {
    private TicketOfferRepository repository;


    public TicketOfferManager(TicketOfferRepository repository) {
        this.repository = repository;
    }

    public void add(TicketOffer item) {
        repository.save(item);
    }

    public TicketOffer[] findAll(String from, String to, Comparator<TicketOffer> comparator) {
        TicketOffer[] items = new TicketOffer[0];
        for (TicketOffer item : repository.findAll()) {
            if (item.getFrom().equals(from) && item.getTo().equals(to)) {
                TicketOffer[] tmp = new TicketOffer[items.length + 1];
                System.arraycopy(items, 0, tmp, 0, items.length);
                tmp[tmp.length - 1] = item;
                items = tmp;
            }
        }
            Arrays.sort(items, comparator);
            return items;
        }
    }


