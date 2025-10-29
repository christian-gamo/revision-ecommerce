package com.cpg.pprojects.ecommerce.infrastructure.util;

import com.cpg.pprojects.ecommerce.usecase.common.ITransactionRunner;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
public class SpringTransactionExecutor implements ITransactionRunner {

    private final TransactionTemplate transactionTemplate;

    @Override
    public <T> T executeInTransaction(Supplier<T> work) {
        return transactionTemplate.execute(status -> work.get());
    }
}
