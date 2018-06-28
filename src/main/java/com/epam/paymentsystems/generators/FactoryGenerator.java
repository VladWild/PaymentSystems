package com.epam.paymentsystems.generators;

public enum FactoryGenerator {
    RANDOM {
        @Override
        protected Generator getGenerator() {
            return new RandomGenerator();
        }
    };

    protected abstract Generator getGenerator();

    public static Generator getTypeGenerator(FactoryGenerator typeGenerator){
        return typeGenerator.getGenerator();
    }
}
