package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data


public class TicketOffer implements Comparable <TicketOffer> {
    int id;
    int price;
    String from;
    String to;
    int flightDuration;

    @Override
    public int compareTo(TicketOffer o) {
                return price - o.price;
    }
}
