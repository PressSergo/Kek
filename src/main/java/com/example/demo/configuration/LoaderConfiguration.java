package com.example.demo.configuration;

import com.example.demo.domain.model.loadedVariation.ILoadedVariation;
import com.example.demo.domain.model.loadedVariation.loadedSQL.LoadedDataBaseImpl;
import com.example.demo.domain.model.loadedVariation.loadedSQL.repository.TransactionRepository;
import com.example.demo.domain.model.loaderServices.LoaderServicesImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoaderConfiguration {

    @Bean
    ILoadedVariation loadedVariation(TransactionRepository transactionRepository){
        LoadedDataBaseImpl loadedDataBase = new LoadedDataBaseImpl();
        loadedDataBase.setTransactionRepository(transactionRepository);
        return loadedDataBase;
    }

    @Bean
    public LoaderServicesImpl loaderServicesFromSql(ILoadedVariation loadedVariation){
        return new LoaderServicesImpl(1,loadedVariation);
    }
}
