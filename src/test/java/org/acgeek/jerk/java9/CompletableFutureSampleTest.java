package org.acgeek.jerk.java9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.TimeUnit;

class CompletableFutureSampleTest {

    @Test
    void completableFuture() {
        var s = CompletableFuture.supplyAsync(() -> {
                    System.out.printf("RUNNING at %s\n", Thread.currentThread().getName());
                    try {
                        Thread.onSpinWait();
                        Thread.sleep(2000);
                    } catch (InterruptedException ignored) {
                    }
                    return 1;
                }).completeAsync(() -> {
                    System.out.printf("COMPLETE at %s\n", Thread.currentThread().getName());
                    return 2;
                })
                .join();

        System.out.println(s);

        System.out.println("-------------");

        Assertions.assertThrows(CompletionException.class, () ->
                CompletableFuture.supplyAsync(() -> {
                            System.out.printf("RUNNING at %s\n", Thread.currentThread().getName());
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException ignored) {
                            }
                            return 1;
                        }).orTimeout(1, TimeUnit.SECONDS)
                        .join());

        System.out.println("Done");
    }
}
