package com.frank.chapter412.config;

import org.jooq.Transaction;
import org.springframework.transaction.TransactionStatus;

/**
 * Adapts a Spring transaction for JOOQ.
 *
 * @author Lukas Eder
 * @author Andreas Ahlenstorf
 * @author Phillip Webb
 */
public class SpringTransaction implements Transaction {

    // Based on the jOOQ-spring-example from https://github.com/jOOQ/jOOQ

    private final TransactionStatus transactionStatus;

    SpringTransaction(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public TransactionStatus getTxStatus() {
        return this.transactionStatus;
    }

}