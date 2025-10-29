package com.cpg.pprojects.ecommerce.usecase.common;

import java.util.function.Supplier;

public interface ITransactionRunner {

    <T> T executeInTransaction(Supplier<T> work);

    default void runInTransaction(Runnable work) {
        executeInTransaction(() -> {
            work.run();
            return null;
        });
    }
}