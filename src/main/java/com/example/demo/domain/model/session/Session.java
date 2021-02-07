package com.example.demo.domain.model.session;

import com.example.demo.domain.model.Transaction;
import com.example.demo.domain.model.loadedVariation.ILoadedVariation;
import lombok.Data;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Data
public class Session implements AutoCloseable {
    private ExecutorService executorService;
    private ILoadedVariation loadedVariation;

    public Session() {
        this.executorService = Executors.newSingleThreadScheduledExecutor();
    }

    public Future<List<Transaction>> getData(){
        return executorService.submit(loadedVariation);
    }

    @Override
    public void close() throws Exception {
        executorService.shutdown();
    }
}
