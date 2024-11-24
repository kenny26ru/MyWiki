package org.mywiki.patterns.behavioral.memento;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        History history = new History();

        Contract contractV1 = Contract.builder()
                .number("123")
                .startDate(LocalDate.of(2024, 12,1))
                .endDate(LocalDate.of(2025, 1,30))
                .build();
        history.addSnapshot(contractV1.createSnapshot());

        contractV1 = Contract.builder()
                .number("124")
                .startDate(LocalDate.of(2025, 1,30))
                .endDate(LocalDate.of(2025, 2,15))
                .build();
        history.addSnapshot(contractV1.createSnapshot());
//        System.out.println(history.getCurrent().getContractSnapshot());

        contractV1 = Contract.builder()
                .number("125")
                .startDate(LocalDate.of(2025, 2,16))
                .endDate(LocalDate.of(2025, 3,15))
                .build();
        history.addSnapshot(contractV1.createSnapshot());

        System.out.println(contractV1);
        contractV1.restoreFromSnapshot(history.getPrevious());
        contractV1.restoreFromSnapshot(history.getPrevious());
        contractV1.restoreFromSnapshot(history.getPrevious()); // первая версия
        System.out.println(contractV1);
    }
}
