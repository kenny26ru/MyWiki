package org.mywiki.patterns.behavioral.memento;

/**
 * Класс хранит состояние объекта
 */
public class Snapshot {
    private final Contract contractSnapshot;

    public Snapshot(Contract contractSnapshot) {
        this.contractSnapshot = contractSnapshot;
    }

    public Contract getContractSnapshot() {
        return contractSnapshot;
    }
}
