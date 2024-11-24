package org.mywiki.patterns.behavioral.memento;

import java.time.LocalDate;

public class Contract {
    private String number;
    private LocalDate startDate;
    private LocalDate endDate;

    private Contract() {}

    private void fill(Contract c) {
        this.number = c.number;
        this.startDate = c.startDate;
        this.endDate = c.endDate;
    }

    public Snapshot createSnapshot() {
        return new Snapshot(this);
    }

    public void restoreFromSnapshot(Snapshot snapshot) {
        if (snapshot == null) return;

        fill(snapshot.getContractSnapshot());
    }

    @Override
    public String toString() {
        return "{\n\t" +
                "\"number\": \"" + number + "\",\n\t\"startDate\": \"" + startDate +
                "\",\n\t\"endDate\": \"" + endDate + "\"\n" +
                "}";
    }

    static Builder builder() {
        return new Builder();
    }

    static class Builder {
        private final Contract contract;

        public Builder() {
            this.contract = new Contract();
        }

        public Builder number(String number) {
            this.contract.number = number;
            return this;
        }

        public Builder startDate(LocalDate startDate) {
            this.contract.startDate = startDate;
            return this;
        }

        public Builder endDate(LocalDate endDate) {
            this.contract.endDate = endDate;
            return this;
        }

        public Contract build() {
            return this.contract;
        }
    }
}
