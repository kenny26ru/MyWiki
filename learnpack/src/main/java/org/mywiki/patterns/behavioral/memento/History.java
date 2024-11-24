package org.mywiki.patterns.behavioral.memento;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Хранитель истории снимков
 */
public class History {
    private final List<Snapshot> history = new LinkedList<>();

    private final AtomicInteger currentIndex = new AtomicInteger(-1);

    public boolean addSnapshot(Snapshot snapshot) {
        currentIndex.set(currentIndex.incrementAndGet());
        return history.add(snapshot);
    }

    public Snapshot getCurrent() {
        if (history.isEmpty()) return null;

        currentIndex.set(history.size() - 1);
        return history.get(currentIndex.get());
    }

    public Snapshot getPrevious() {
        if (history.isEmpty()) return null;

        if (currentIndex.get() != 0) {
            currentIndex.set(currentIndex.decrementAndGet());
        }
        return history.get(currentIndex.get());
    }

    public Snapshot getNext() {
        return null;
    }

    public Snapshot getLas() {
        return null;
    }
}
