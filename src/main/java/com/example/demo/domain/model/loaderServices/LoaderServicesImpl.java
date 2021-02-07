package com.example.demo.domain.model.loaderServices;

import com.example.demo.domain.model.Transaction;
import com.example.demo.domain.model.loadedVariation.ILoadedVariation;
import com.example.demo.domain.model.session.Session;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Data
public class LoaderServicesImpl  implements ILoaderServies{
    private List<Session> sessions;

    public LoaderServicesImpl(int numSession, ILoadedVariation loadedVariation) {
        this.setSessions(numSession);
        this.setloadedVariation(loadedVariation);
    }

    private void setloadedVariation(ILoadedVariation loadedVariation){
        sessions.forEach(t->t.setLoadedVariation(loadedVariation));
    }

    private void setSessions(int numSession) {
        sessions = new ArrayList<>(numSession);
        for (int i = 0; i < numSession; i++){
            sessions.add(new Session());
        }
    }

    @Override
    public List<Transaction> loadData() {
        try {
            sessions.get(0).getData().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
