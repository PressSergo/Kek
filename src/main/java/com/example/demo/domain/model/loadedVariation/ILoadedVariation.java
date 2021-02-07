package com.example.demo.domain.model.loadedVariation;

import com.example.demo.domain.model.Transaction;

import java.util.List;
import java.util.concurrent.Callable;

public interface ILoadedVariation extends Callable<List<Transaction>> {
}
